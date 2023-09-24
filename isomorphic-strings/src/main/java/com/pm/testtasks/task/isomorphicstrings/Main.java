package com.pm.testtasks.task.isomorphicstrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Isomorphic Strings ***");
        for (var strings : new String[][]{
                {"aabb", "ccdd"},
                {"", ""},
                {"aabb", "aacc"},
                {"aaaa", "bbcc"},
                {"aabb", "cccc"},
                {"foo", "food"}
        }) {
            System.out.printf("strings '%s' and '%s' %s isomorphic%n",
                    strings[0], strings[1], isIsomorphic(strings[0], strings[1]) ? "are" : "aren't ");
        }
        System.out.println("*** Isomorphic Strings");
    }

    static boolean isIsomorphic(String base, String other) {
        Objects.requireNonNull(base);
        Objects.requireNonNull(other);
        if (base.length() != other.length()) {
            return false;
        }
        final var chars = new HashMap<Character, Character>(base.length());
        final var mapped = new HashSet<Character>(base.length());
        for (var i = 0; i < base.length(); i++) {
            final var baseCh = base.charAt(i);
            final var otherCh = other.charAt(i);
            final var ch = chars.get(baseCh);
            if (ch != null) {
                if (!ch.equals(otherCh)) {
                    return false;
                }
            } else {
                if (!mapped.add(otherCh)) {
                    return false;
                }
                chars.put(baseCh, otherCh);
            }
        }
        return true;
    }
}