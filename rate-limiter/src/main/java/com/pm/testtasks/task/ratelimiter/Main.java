package com.pm.testtasks.task.ratelimiter;

public class Main {
    private static final RateLimiter rateLimiter = new RateLimiter(10);
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println("Rate Limiter ***");
        for (var i = 0; i < 15; i++) {
            makeIntensiveCalculationWrapper();
        }
        System.out.println("Waiting for 1 second...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (var i = 0; i < 15; i++) {
            makeIntensiveCalculationWrapper();
        }
        System.out.println("*** Rate Limiter");
    }

    private static void makeIntensiveCalculationWrapper() {
        final var now = System.currentTimeMillis();
        if (rateLimiter.canExecute(now)) {
            rateLimiter.addExecution(now);
            makeIntensiveCalculation();
        }
    }

    private static void makeIntensiveCalculation() {
        System.out.printf("Function called (%d time)%n", ++count);
    }
}