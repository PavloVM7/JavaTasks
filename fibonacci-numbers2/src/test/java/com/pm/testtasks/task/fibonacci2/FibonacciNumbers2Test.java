package com.pm.testtasks.task.fibonacci2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciNumbers2Test {
    static Stream<Arguments> numAndExpected() {
        return Stream.of(
                Arguments.arguments(0, 0),
                Arguments.arguments(1, 1),
                Arguments.arguments(2, 1),
                Arguments.arguments(3, 2),
                Arguments.arguments(4, 3),
                Arguments.arguments(5, 5),
                Arguments.arguments(6, 8),
                Arguments.arguments(7, 13),
                Arguments.arguments(8, 21),
                Arguments.arguments(9, 34),
                Arguments.arguments(10, 55),
                Arguments.arguments(11, 89),
                Arguments.arguments(12, 144),
                Arguments.arguments(13, 233),
                Arguments.arguments(14, 377),
                Arguments.arguments(15, 610),
                Arguments.arguments(16, 987),
                Arguments.arguments(17, 1597),
                Arguments.arguments(18, 2584),
                Arguments.arguments(19, 4181),
                Arguments.arguments(20, 6765)
        );
    }

    @ParameterizedTest
    @MethodSource("numAndExpected")
    void calculate(int n, int expected) {
        assertEquals(expected, FibonacciNumbers2.calculate(n));
    }

    @ParameterizedTest
    @MethodSource("numAndExpected")
    void calculateRecursion(int n, int expected) {
        assertEquals(expected, FibonacciNumbers2.calculateRecursion(n));
    }
}