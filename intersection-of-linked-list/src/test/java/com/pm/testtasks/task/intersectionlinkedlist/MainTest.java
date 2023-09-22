package com.pm.testtasks.task.intersectionlinkedlist;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private static final Character[] expected = new Character[]{'C', 'D', 'E'};

    static Stream<Arguments> getLists() {
        return Stream.of(
                Arguments.arguments(
                        addExpected('A', 'B'),
                        addExpected('F', 'G', 'H')
                ),
                Arguments.arguments(
                        addExpected('A', 'B', 'K'),
                        addExpected('F', 'G', 'H')
                ),
                Arguments.arguments(
                        addExpected('A', 'B', 'K'),
                        addExpected('F', 'G')
                ),
                Arguments.arguments(
                        addExpected('A'),
                        addExpected()
                ),
                Arguments.arguments(
                        addExpected(),
                        addExpected('F')
                )
        );
    }

    private static List<Character> addExpected(Character... chars) {
        var result = new LinkedList<>(Arrays.asList(chars));
        result.addAll(Arrays.asList(expected));
        return result;
    }

    @ParameterizedTest
    @MethodSource("getLists")
    void intersectionY(List<Character> list1, List<Character> list2) {
        final LinkedList<Character> actual = (LinkedList<Character>) Main.intersectionY(list1, list2);
        assertArrayEquals(expected, actual.toArray(new Character[0]));
    }

    @Test
    void intersectionY_not_intersected() {
        var list1 = new LinkedList<>(List.of('A', 'B'));
        var list2 = new LinkedList<>(List.of('F', 'G', 'H'));
        var actual = Main.intersectionY(list1, list2);
        assertTrue(actual.isEmpty());
    }
}