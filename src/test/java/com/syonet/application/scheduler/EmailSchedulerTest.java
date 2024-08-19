package com.syonet.application.scheduler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.syonet.application.service.EmailService;
import com.syonet.domain.model.Newsletter;
import com.syonet.domain.repository.NewsletterRepository;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class EmailSchedulerTest {

    @Inject
    EmailService emailService;

    @Inject
    NewsletterRepository newsletterRepository;

    @Test
    public void testScheduleDailyEmail() {
        emailService.sendDailyNewsletters();

        // assert that all newsLetters were marked as sent

        List<Newsletter> newsletters = newsletterRepository.findAll().list();

        for (Newsletter newsletter : newsletters) {
            assertEquals(newsletter.sent, true);
        }

    }
}
