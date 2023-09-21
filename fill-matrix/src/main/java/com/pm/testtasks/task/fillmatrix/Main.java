package com.pm.testtasks.task.fillmatrix;

public class Main {

    static void printMatrix(int[][] matrix) {
        for (var row : matrix) {
            for (var j = 0; j < row.length; j++) {
                if (j != row.length - 1) {
                    System.out.printf("%3d", row[j]);
                } else {
                    System.out.printf("%3d%n", row[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Fill the matrix ***");

        for (var t = 1; t <= 9; t++) {
            var m = createMatrix();
            System.out.println("\n source matrix:");
            printMatrix(m);
            FillMatrix.fill(m, t);
            System.out.printf(" after fill (t=%d):%n", t);
            printMatrix(m);
        }
        System.out.println("*** Fill the matrix");

    }

    static int[][] createMatrix() {
        return new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }
}