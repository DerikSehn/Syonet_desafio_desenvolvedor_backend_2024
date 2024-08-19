
package com.syonet.application.scheduler;

import com.syonet.application.service.EmailService;

import io.quarkus.test.Mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailSchedulerTest {

    @Mock
    private EmailService emailService;

    private EmailScheduler emailScheduler;

    @BeforeEach
    public void setup() {
        emailScheduler = new EmailScheduler();
        emailScheduler.emailService = emailService;

    }

    @Test
    public void testScheduleDailyEmail() {
        emailScheduler.scheduleDailyEmail();
    }

}
