package com.pm.testtasks.task.intersectionlinkedlist;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Intersection of linked list ***");
        var list1 = new LinkedList<>(List.of('A', 'B', 'C', 'D', 'E'));
        var list2 = new LinkedList<>(List.of('F', 'G', 'H', 'C', 'D', 'E'));
        var res = intersection(list1, list2);
        var resY = intersectionY(list1, list2);
        System.out.printf("first list:     %s%n", list1);
        System.out.printf("second list:    %s%n", list2);
        System.out.printf("intersection:   %s%n", res);
        System.out.printf("intersection Y: %s%n", resY);
        System.out.println("*** Intersection of linked list");
    }

    static <T> List<T> intersection(List<T> list1, List<T> list2) {
        final var intersect = new HashSet<>(list1);
        intersect.retainAll(new HashSet<>(list2));
        return new LinkedList<>(intersect);
    }

    static <T> List<T> intersectionY(List<T> list1, List<T> list2) {
        final var len1 = list1.size();
        final var len2 = list2.size();
        final Iterator<T> big;
        final Iterator<T> small;
        final int delta;
        if (len1 > len2) {
            delta = len1 - len2;
            big = list1.iterator();
            small = list2.iterator();
        } else {
            delta = len2 - len1;
            big = list2.iterator();
            small = list1.iterator();
        }
        for (var i = 0; i < delta && big.hasNext(); i++) {
            big.next();
        }
        final var result = new LinkedList<T>();
        while (small.hasNext() && big.hasNext()) {
            final var bigVal = big.next();
            final var smallVal = small.next();
            if (bigVal.equals(smallVal)) {
                result.addLast(bigVal);
            }
        }
        return result;
    }
}