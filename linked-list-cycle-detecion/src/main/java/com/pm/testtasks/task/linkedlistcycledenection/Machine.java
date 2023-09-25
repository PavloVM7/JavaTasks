package com.pm.testtasks.task.linkedlistcycledenection;

import java.util.Objects;

public class Machine {
    private final String name;
    private Machine next;

    public Machine(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public Machine(String name, Machine next) {
        this(name);
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public Machine getNext() {
        return next;
    }

    public void setNext(Machine next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Machine machine = (Machine) object;
        return Objects.equals(name, machine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Machine{" +
                "name='" + name + '\'' +
                ", next=" + (next != null ? "'" + next.name + "'" : "<null>") +
                '}';
    }
}
