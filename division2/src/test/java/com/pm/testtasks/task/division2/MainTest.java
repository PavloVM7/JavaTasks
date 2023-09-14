package com.pm.testtasks.task.division2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    static Stream<Arguments> getN1N2Expected() {
        return Stream.of(
                Arguments.arguments(0, 123, new int[]{0, 0}),
                Arguments.arguments(123, 1, new int[]{123, 0}),
                Arguments.arguments(6, 2, new int[]{3, 0}),
                Arguments.arguments(6, 3, new int[]{2, 0}),
                Arguments.arguments(-6, 3, new int[]{-2, 0}),
                Arguments.arguments(6, -3, new int[]{-2, 0}),
                Arguments.arguments(-6, -3, new int[]{2, 0}),
                Arguments.arguments(15, -7, new int[]{-2, -1}),
                Arguments.arguments(23, 3, new int[]{7, 2}),
                Arguments.arguments(23, -3, new int[]{-7, -2}),
                Arguments.arguments(-23, 3, new int[]{-7, -2}),
                Arguments.arguments(-23, -3, new int[]{7, 2})

        );
    }

    @ParameterizedTest
    @MethodSource("getN1N2Expected")
    void divide(int n1, int n2, int[] expected) {
        assertArrayEquals(expected, Main.divide(n1, n2));
    }

    @Test
    void divide_0() {
        assertArrayEquals(new int[]{0, 0}, Main.divide(0, 1));
        assertArrayEquals(new int[]{0, 0}, Main.divide(0, 123));
    }

    @Test
    void divide_exception() {
        assertThrows(ArithmeticException.class, () -> Main.divide(123, 0));
    }
}