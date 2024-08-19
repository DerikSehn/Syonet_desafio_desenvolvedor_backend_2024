package com.syonet.application.service;

import java.time.LocalDate;
import java.util.List;

import com.syonet.domain.model.Customer;
import com.syonet.domain.model.Newsletter;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EmailService {

    @Inject
    Mailer mailer;

    @Inject
    NewsletterService newsService;

    @Inject
    CustomerService customerService;

    @Transactional
    public void sendDailyNewsletters() {
        List<Customer> customers = customerService.getCustomers();
        List<Newsletter> newsletters = newsService.findUnsentNewsletters();

        for (Customer customer : customers) {
            StringBuilder emailBody = new StringBuilder();
            emailBody.append("Bom dia ").append(customer.name).append("!\n");

            if (customer.birthDate != null && customer.birthDate.isEqual(LocalDate.now())) {
                emailBody.append("Feliz aniversário!\n");
            }

            for (Newsletter newsletter : newsletters) {
                emailBody.append("\n").append(newsletter.title).append("\n");
                emailBody.append(newsletter.description).append("\n");
                if (newsletter.link != null) {
                    emailBody.append("Leia mais em: ").append(generateAnchor(newsletter.link)).append("\n");
                }
            }
            try {
                mailer.send(
                        Mail.withText(customer.email, "Notícias do dia!", emailBody.toString()));
            } catch (Exception e) {
                throw new RuntimeException("Erro ao enviar e-mail: " + e.getMessage());
            }
        }
    }

    private String generateAnchor(String link) {
        return "<a href=\"" + link + "\">" + link + "</a>";
    }
}
