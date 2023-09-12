package com.pm.testtasks.task.fibonacci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FibonacciNumbersTest {

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate_exception() {
        assertThrows(IllegalArgumentException.class, () -> FibonacciNumbers.calculate(0));
        assertThrows(IllegalArgumentException.class, () -> FibonacciNumbers.calculate(-1));
    }
    @ParameterizedTest
    @MethodSource("intAndExpectedArray")
    void calculate(int count, long[] expected) {
        final var actual = FibonacciNumbers.calculate(count);
        assertArrayEquals(expected, actual, String.format("expected: %s\n  actual: %s\n", Arrays.toString(expected), Arrays.toString(actual)));
    }
    static Stream<Arguments> intAndExpectedArray() {
        return Stream.of(
                Arguments.arguments(1, new long[]{0}),
                Arguments.arguments(2, new long[]{0, 1}),
                Arguments.arguments(3, new long[]{0, 1, 1}),
                Arguments.arguments(4, new long[]{0, 1, 1, 2}),
                Arguments.arguments(5, new long[]{0, 1, 1, 2, 3}),
                Arguments.arguments(6, new long[]{0, 1, 1, 2, 3, 5}),
                Arguments.arguments(10, new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}),
                Arguments.arguments(20, new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181})
        );
    }
}