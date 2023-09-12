package com.pm.testtasks.task.fibonacci2;

public final class FibonacciNumbers2 {
    private FibonacciNumbers2() {
    }

    public static int calculateRecursion(int n) {
        return n < 2 ? n : calculateRecursion(n - 1) + calculateRecursion(n - 2);
    }

    public static int calculate(int n) {
        if (n < 2) {
            return n;
        }
        int step2 = 0;
        int step1 = 1;
        int result = 1;
        for (var i = 2; i <= n; i++) {
            result = step1 + step2;
            step2 = step1;
            step1 = result;
        }
        return result;
    }
}
