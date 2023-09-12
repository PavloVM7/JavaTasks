package com.pm.testtasks.task.division;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    static Stream<Arguments> n1N2AndExpected() {
        return Stream.of(
                Arguments.arguments(0, 123, 0),
                Arguments.arguments(6, 2, 3),
                Arguments.arguments(6, 3, 2),
                Arguments.arguments(-6, 3, -2),
                Arguments.arguments(6, -3, -2),
                Arguments.arguments(-6, -3, 2),
                Arguments.arguments(15, -3, -5),
                Arguments.arguments(23, 3, 7),
                Arguments.arguments(23, -3, -7),
                Arguments.arguments(-23, 3, -7),
                Arguments.arguments(-23, -3, 7)
        );
    }

    @Test
    void division_exception() {
        assertThrows(ArithmeticException.class, () -> Main.division(123, 0));
    }

    @Test
    void division_0() {
        assertEquals(0, Main.division(0, 1));
        assertEquals(0, Main.division(0, 123));
    }

    @ParameterizedTest
    @MethodSource("n1N2AndExpected")
    void division(int n1, int n2, int expected) {
        final var actual = Main.division(n1, n2);
        assertEquals(actual, expected);
    }
}