package com.pm.testtasks.task.dyncallmethod;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    static Stream<Arguments> getTestObjects() {
        return Stream.of(
                Arguments.arguments(new Test1(1, "string 1")),
                Arguments.arguments(new Test1(231, "string -321")),
                Arguments.arguments(new Test1(123, "string 123"))
        );
    }

    @Test
    void getMethodName_exception() {
        assertThrows(IllegalArgumentException.class, () -> Main.getMethodName(""));
        assertThrows(IllegalArgumentException.class, () -> Main.getMethodName(" "));
        assertThrows(IllegalArgumentException.class, () -> Main.getMethodName("\t"));
        assertThrows(IllegalArgumentException.class, () -> Main.getMethodName(" \t "));
    }

    @Test
    void getMethodName() {
        assertEquals("getA", Main.getMethodName("a"));
        assertEquals("getA", Main.getMethodName(" a \t"));
        assertEquals("getFoo", Main.getMethodName("foo"));
    }

    @ParameterizedTest
    @MethodSource("getTestObjects")
    void getObjectProperty(Test1 object) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        final var countName = "count";
        final var stringName = "string";

        assertEquals(object.count, Main.getObjectProperty(object, countName));
        assertEquals(object.string, Main.getObjectProperty(object, stringName));
    }

    @SuppressWarnings("unused")
    private static class Test1 {
        final int count;
        final String string;

        private Test1(int count, String string) {
            this.count = count;
            this.string = string;
        }

        int getCount() {
            return count;
        }

        public String getString() {
            return string;
        }
    }
}