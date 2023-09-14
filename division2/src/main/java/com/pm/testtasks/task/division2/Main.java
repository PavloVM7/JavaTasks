package com.pm.testtasks.task.division2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Division without operator 2 ***");
        for (var ar : new int[][]{{6, 3}, {-6, 3}, {6, -2}, {-17, -4}, {0, 3}, {23, 4}, {29, -5}, {-31, 7}, {-37, -6}}) {
            final var res = divide(ar[0], ar[1]);
            System.out.printf("%3d / %-2d = %2d mod %d%n", ar[0], ar[1], res[0], res[1]);
        }
        System.out.println("*** Division without operator 2");
    }

    static int[] divide(int n1, int n2) {
        if (n1 == 0) {
            return new int[]{0, 0};
        }
        if (n2 == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        boolean negative = false;
        if (n1 < 0) {
            n1 = -n1;
            if (n2 < 0) {
                n2 = -n2;
            } else {
                negative = true;
            }
        } else if (n2 < 0) {
            n2 = -n2;
            negative = true;
        }
        int quotient = 0;
        while (n1 >= n2) {
            n1 -= n2;
            quotient++;
        }
        if (negative) {
            quotient = -quotient;
            n1 = -n1;
        }
        return new int[]{quotient, n1};
    }
}