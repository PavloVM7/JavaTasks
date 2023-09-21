package com.pm.testtasks.task.fillmatrix;

public final class FillMatrix {

    private FillMatrix() {
    }

    public static void fill(int[][] matrix, int t) {
        setMarks(matrix, t);
        fillMatrix(matrix, t);
    }

    static void setMarks(int[][] matrix, int t) {
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == t) {
                    matrix[i][0] = t;
                    matrix[0][j] = t;
                }
            }
        }
    }

    static void fillMatrix(int[][] matrix, int t) {
        int row = -1;
        for (var i = matrix.length - 1; i >= 0; i--) {
            if (matrix[i][0] == t) {
                row = i;
                break;
            }
        }
        if (row == -1) {
            return;
        }
        int col = -1;
        for (var j = matrix.length - 1; j >= 0; j--) {
            if (matrix[0][j] == t) {
                col = j;
                break;
            }
        }
        for (var j = 0; j < matrix.length; j++) {
            matrix[row][j] = t;
        }
        for (var i = 0; i < matrix.length; i++) {
            matrix[i][col] = t;
        }
    }
}
