package com.pm.testtasks.task.linkedlistcycledenection;

import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Linked list cycle detection ***");

        var machine = new Machine("Machine 1", new Machine("Machine 2", new Machine("Machine 3")));

        System.out.printf("%s -> %s -> %s -> null; has cycle: %b (loops), %b (set), %b (optimal)%n",
                machine.getName(), machine.getNext().getName(), machine.getNext().getNext().getName(),
                hasCycleByLoops(machine), hasCycleBySet(machine), hasCycleOptimal(machine));

        var machine1 = new Machine("Machine 1");
        var machine2 = new Machine("Machine 2");
        var machine3 = new Machine("Machine 3");
        machine1.setNext(machine2);
        machine2.setNext(machine3);
        machine3.setNext(machine1);

        System.out.printf("%s -> %s -> %s -> %s; has cycle: %b (loops), %b (set), %b (optimal)%n",
                machine1.getName(), machine2.getName(), machine3.getName(), machine3.getNext().getName(),
                hasCycleByLoops(machine1), hasCycleBySet(machine1), hasCycleOptimal(machine1));

        System.out.println("*** Linked list cycle detection");
    }

    static boolean hasCycleByLoops(Machine initialMachine) {
        var current = initialMachine;
        while (current.getNext() != null) {
            var temp = initialMachine;
            while (temp.getNext() != null && temp != current) {
                if (temp == current.getNext()) {
                    return true;
                }
                temp = temp.getNext();
            }
            current = current.getNext();
        }
        return false;
    }

    static boolean hasCycleBySet(Machine initialMachine) {
        final var machines = new HashSet<Machine>();
        var current = initialMachine;
        while (current != null) {
            if (!machines.add(current)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    static boolean hasCycleOptimal(Machine initialMachine) {
        var m1 = Objects.requireNonNull(initialMachine);
        var m2 = initialMachine.getNext();
        while (m2 != null) {
            if (m2.equals(m1)) {
                return true;
            } else if (m2.getNext() == null) {
                break;
            } else {
                m1 = m1.getNext();
                m2 = m2.getNext().getNext();
            }
        }
        return false;
    }
}