package com.pm.testtasks.task.linkedlistcycledenection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    static Stream<Arguments> getInitialMachine() {
        return Stream.of(
                Arguments.arguments(createNotCycledList(), false),
                Arguments.arguments(createCycledList(), true)
        );
    }

    private static Machine createNotCycledList() {
        return createMachines()[0];
    }

    private static Machine createCycledList() {
        final var machines = createMachines();
        machines[3].setNext(machines[1]);
        return machines[0];
    }

    private static Machine[] createMachines() {
        final var result = new Machine[]{
                new Machine("Machine 1"),
                new Machine("Machine 2"),
                new Machine("Machine 3"),
                new Machine("Machine 4"),
                new Machine("Machine 5"),
        };
        for (var i = 0; i < result.length - 1; i++) {
            result[i].setNext(result[i + 1]);
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("getInitialMachine")
    void hasCycleByLoops(final Machine initialMachine, final boolean expected) {
        final var actual = Main.hasCycleByLoops(initialMachine);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getInitialMachine")
    void hasCycleBySet(final Machine initialMachine, final boolean expected) {
        final var actual = Main.hasCycleBySet(initialMachine);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getInitialMachine")
    void hasCycleOptimal(final Machine initialMachine, final boolean expected) {
        final var actual = Main.hasCycleOptimal(initialMachine);
        assertEquals(expected, actual);

    }
}