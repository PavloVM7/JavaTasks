package com.pm.testtasks.task.parsecsv;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserCSVTest {
    private ParserCSV parser;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        final var file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("test.csv"))
                .getFile());
        parser = new ParserCSV(file);
    }

    @AfterEach
    void tearDown() throws IOException {
        if (parser != null) {
            parser.close();
            parser = null;
        }
    }

    @Test
    void parse() throws IOException {
        parser.parse();
        assertEquals(3, parser.errorsCount());
        assertEquals(32, parser.linesCount());
        parser.print();
    }
}