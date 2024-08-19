package com.syonet.application.scheduler;

import com.syonet.application.service.EmailService;

import io.quarkus.scheduler.Scheduled;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailScheduler {

    @Inject
    EmailService emailService;

    // everyday 8AM
    @Scheduled(cron = "0 0 8 * * ?")
    public void scheduleDailyEmail() {
        emailService.sendDailyNewsletters();
    }
}
