package com.pm.testtasks.task.division;

public class Main {
    static int division(int n1, int n2) {
        if (n1 == 0) {
            return 0;
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
        }
        return quotient;
    }

    public static void main(String[] args) {
        System.out.println("*** Division without operator");
        for (var nm : new int[][]{{6, 3}, {-6, 3}, {6, -2}, {-17, -4}, {0, 3}, {23, 4}, {29, -5}, {-31, 7}, {-37, -6}}) {
            System.out.printf("%3d : %2d = %3d%n", nm[0], nm[1], division(nm[0], nm[1]));
        }
        System.out.println("Division without operator ***");
    }
}