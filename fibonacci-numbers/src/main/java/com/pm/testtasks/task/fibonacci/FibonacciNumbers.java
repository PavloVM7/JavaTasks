package com.pm.testtasks.task.fibonacci;

public final class FibonacciNumbers {
    private FibonacciNumbers() {
    }
    public static long[] calculate(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(String.format("Count (%d) is not valid.", count));
        }
        final long[] result = new long[count];
        for (var i = 0; i < result.length; i++) {
            if (i > 1) {
                result[i] = result[i - 1] + result[i - 2];
            } else {
                result[i] = i;
            }
        }
        return result;
    }
}
