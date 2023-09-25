package com.pm.testtasks.task.linkedlistcycledenection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    @Test
    void name() {
        final var name = "Machine 1";
        final var machine = new Machine(name, null);
        assertEquals(name, machine.getName());
        assertNull(machine.getNext());
    }

    @Test
    void next() {
        final var machineEnd = new Machine("Machine 1", null);
        final var machine = new Machine("Machine 1", machineEnd);
        assertEquals(machineEnd, machine.getNext());
        assertNull(machineEnd.getNext());
    }

    @Test
    void creation_exception() {
        assertThrows(NullPointerException.class, () -> new Machine(null, new Machine("m1", null)));
    }
}