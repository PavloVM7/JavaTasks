package com.pm.testtasks.task.ratelimiter;

import java.util.LinkedList;

public class RateLimiter {
    private static final long interval = 1000;
    private final LinkedList<Long> executionTimes;
    private final int executionLimit;

    public RateLimiter(int executionLimit) {
        this.executionLimit = executionLimit;
        executionTimes = new LinkedList<>();
    }

    public boolean canExecute(long now) {
        removeOld(now);
        return executionTimes.size() < executionLimit;
    }

    public void addExecution(long now) {
        executionTimes.addLast(now);
    }

    private void removeOld(long now) {
        while (!executionTimes.isEmpty()) {
            if (now - executionTimes.getFirst() > interval) {
                executionTimes.removeFirst();
            } else {
                break;
            }
        }
    }

}
