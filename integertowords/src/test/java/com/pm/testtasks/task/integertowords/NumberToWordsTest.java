package com.pm.testtasks.task.integertowords;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberToWordsTest {

    @ParameterizedTest(name = "{index}. {0}, ''{1}''")
    @CsvSource(textBlock = """
            0, 'Zero'
            7, 'Seven'
            10, 'Ten'
            15, 'Fifteen'
            20, 'Twenty'
            99, 'Ninety Nine'
            101, 'One Hundred One'
            110, 'One Hundred Ten'
            111, 'One Hundred Eleven'
            123, 'One Hundred Twenty Three'
            200, 'Two Hundred'
            1245, 'One Thousand Two Hundred Forty Five'
            3000, 'Three Thousand'
            5040, 'Five Thousand Forty'
            7209, 'Seven Thousand Two Hundred Nine'
            9999, 'Nine Thousand Nine Hundred Ninety Nine'
            """)
    void numberToWords(int number, String expected) {
        final var actual = NumberToWords.numberToWords(number);
        assertEquals(expected, actual, String.format("'%s' != '%s'", expected, actual));
    }
}