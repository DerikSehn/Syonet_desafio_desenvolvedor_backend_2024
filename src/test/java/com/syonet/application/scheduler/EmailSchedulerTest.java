package com.syonet.application.scheduler;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class EmailSchedulerTest {

    @Inject
    EmailScheduler emailScheduler;

    @Test
    public void testScheduleDailyEmail() {
        emailScheduler.scheduleDailyEmail();
    }
}
