package com.pm.testtasks.task.rgbcolorformatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RGBColorFormatterTest {
    private RGBColorFormatter formatter;

    static Stream<Arguments> getRgb() {
        return Stream.of(
                Arguments.arguments(0, 0, 0, "#000000"),
                Arguments.arguments(255, 255, 255, "#ffffff"),
                Arguments.arguments(127, 127, 127, "#7f7f7f"),
                Arguments.arguments(128, 128, 128, "#808080"),
                Arguments.arguments(127, 128, 255, "#7f80ff"),
                Arguments.arguments(98, 251, 138, "#62fb8a")
        );
    }

    @BeforeEach
    void setUp() {
        formatter = new RGBColorFormatter();
    }

    @AfterEach
    void tearDown() {
        formatter = null;
    }

    @ParameterizedTest
    @MethodSource("getRgb")
    void format(int r, int g, int b, String expected) {
        final var actual = formatter.format(r, g, b);
        assertEquals(expected, actual);
    }

    @Test
    void toHex() {
        assertEquals("00", RGBColorFormatter.toHex(0));
        assertEquals("ff", RGBColorFormatter.toHex(255));
        assertEquals("62", RGBColorFormatter.toHex(98));
        assertEquals("fb", RGBColorFormatter.toHex(251));
    }
}