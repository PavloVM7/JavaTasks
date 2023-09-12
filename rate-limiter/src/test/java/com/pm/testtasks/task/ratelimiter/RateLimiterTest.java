package com.pm.testtasks.task.ratelimiter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RateLimiterTest {
    private RateLimiter rateLimiter;

    @AfterEach
    void tearDown() {
        rateLimiter = null;
    }

    @Test
    void canExecute_next_interval() throws InterruptedException {
        rateLimiter = new RateLimiter(10);
        for (var i = 0; i < 10; i++) {
            final var now = System.currentTimeMillis();
            assertTrue(rateLimiter.canExecute(now));
            rateLimiter.addExecution(now);
            Thread.sleep(100);
        }
        assertTrue(rateLimiter.canExecute(System.currentTimeMillis()));
    }

    @Test
    void canExecute() throws InterruptedException {
        rateLimiter = new RateLimiter(3);
        var now = System.currentTimeMillis();
        assertTrue(rateLimiter.canExecute(now));
        rateLimiter.addExecution(now);
        Thread.sleep(50);
        now = System.currentTimeMillis();
        assertTrue(rateLimiter.canExecute(now));
        rateLimiter.addExecution(now);
        Thread.sleep(50);
        now = System.currentTimeMillis();
        assertTrue(rateLimiter.canExecute(now));
        rateLimiter.addExecution(now);
        Thread.sleep(50);
        now = System.currentTimeMillis();
        assertFalse(rateLimiter.canExecute(now));
    }

    @Test
    void addExecution() throws InterruptedException {
        rateLimiter = new RateLimiter(3);
        assertTrue(rateLimiter.canExecute(System.currentTimeMillis()));
        rateLimiter.addExecution(System.currentTimeMillis());
        Thread.sleep(50);
        rateLimiter.addExecution(System.currentTimeMillis());
        Thread.sleep(50);
        rateLimiter.addExecution(System.currentTimeMillis());
        Thread.sleep(50);
        assertFalse(rateLimiter.canExecute(System.currentTimeMillis()));
    }
}