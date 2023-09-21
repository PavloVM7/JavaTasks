package com.pm.testtasks.task.fillmatrix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FillMatrixTest {
    private int[][] matrix;

    static Stream<Arguments> fillsExpectedAndT() {
        return Stream.of(
                Arguments.arguments(1, new int[][]{
                        {1, 1, 1},
                        {1, 5, 6},
                        {1, 8, 9}
                }),
                Arguments.arguments(2, new int[][]{
                        {2, 2, 2},
                        {4, 2, 6},
                        {7, 2, 9}
                }),
                Arguments.arguments(3, new int[][]{
                        {3, 3, 3},
                        {4, 5, 3},
                        {7, 8, 3}
                }),
                Arguments.arguments(4, new int[][]{
                        {4, 2, 3},
                        {4, 4, 4},
                        {4, 8, 9}
                }),
                Arguments.arguments(5, new int[][]{
                        {1, 5, 3},
                        {5, 5, 5},
                        {7, 5, 9}
                }),
                Arguments.arguments(6, new int[][]{
                        {1, 2, 6},
                        {6, 6, 6},
                        {7, 8, 6}
                }),
                Arguments.arguments(7, new int[][]{
                        {7, 2, 3},
                        {7, 5, 6},
                        {7, 7, 7}
                }),
                Arguments.arguments(8, new int[][]{
                        {1, 8, 3},
                        {4, 8, 6},
                        {8, 8, 8}
                }),
                Arguments.arguments(9, new int[][]{
                        {1, 2, 9},
                        {4, 5, 9},
                        {9, 9, 9}
                })
        );
    }

    static Stream<Arguments> marksExpectedAndT() {
        return Stream.of(
                Arguments.arguments(1, new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(2, new int[][]{
                        {2, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(3, new int[][]{
                        {3, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(4, new int[][]{
                        {4, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(5, new int[][]{
                        {1, 5, 3},
                        {5, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(6, new int[][]{
                        {1, 2, 6},
                        {6, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(7, new int[][]{
                        {7, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }),
                Arguments.arguments(8, new int[][]{
                        {1, 8, 3},
                        {4, 5, 6},
                        {8, 8, 9}
                }),
                Arguments.arguments(9, new int[][]{
                        {1, 2, 9},
                        {4, 5, 6},
                        {9, 8, 9}
                })
        );
    }

    static Stream<Arguments> fillMatrixSources() {
        return Stream.of(
                Arguments.arguments(1, new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {1, 1, 1},
                        {1, 5, 6},
                        {1, 8, 9}
                }),
                Arguments.arguments(2, new int[][]{
                        {2, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {2, 2, 2},
                        {4, 2, 6},
                        {7, 2, 9}
                }),
                Arguments.arguments(3, new int[][]{
                        {3, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {3, 3, 3},
                        {4, 5, 3},
                        {7, 8, 3}
                }),
                Arguments.arguments(4, new int[][]{
                        {4, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {4, 2, 3},
                        {4, 4, 4},
                        {4, 8, 9}
                }),
                Arguments.arguments(5, new int[][]{
                        {1, 5, 3},
                        {5, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {1, 5, 3},
                        {5, 5, 5},
                        {7, 5, 9}
                }),
                Arguments.arguments(6, new int[][]{
                        {1, 2, 6},
                        {6, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {1, 2, 6},
                        {6, 6, 6},
                        {7, 8, 6}
                }),
                Arguments.arguments(7, new int[][]{
                        {7, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {7, 2, 3},
                        {7, 5, 6},
                        {7, 7, 7}
                }),
                Arguments.arguments(8, new int[][]{
                        {1, 8, 3},
                        {4, 5, 6},
                        {8, 8, 9}
                }, new int[][]{
                        {1, 8, 3},
                        {4, 8, 6},
                        {8, 8, 8}
                }),
                Arguments.arguments(9, new int[][]{
                        {1, 2, 9},
                        {4, 5, 6},
                        {9, 8, 9}
                }, new int[][]{
                        {1, 2, 9},
                        {4, 5, 9},
                        {9, 9, 9}
                })
        );
    }

    @BeforeEach
    void setUp() {
        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }

    @AfterEach
    void tearDown() {
        matrix = null;
    }

    @ParameterizedTest(name = "{index}. t={0}, {1}")
    @MethodSource("fillsExpectedAndT")
    void fill(int t, int[][] expected) {
        FillMatrix.fill(matrix, t);
        assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest(name = "{index}. t={0}, {1}")
    @MethodSource("marksExpectedAndT")
    void setMarks(int t, int[][] expected) {
        FillMatrix.setMarks(matrix, t);
        assertArrayEquals(expected, matrix);
    }

    @ParameterizedTest(name = "{index}. t={0}, {1} => {2}")
    @MethodSource("fillMatrixSources")
    void fillMatrix(int t, int[][] source, int[][] expected) {
        FillMatrix.fillMatrix(source, t);
        System.out.println("t = " + t);
        Main.printMatrix(source);
        assertArrayEquals(expected, source);
    }
}