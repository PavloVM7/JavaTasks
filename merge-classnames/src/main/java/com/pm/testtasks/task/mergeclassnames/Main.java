package com.pm.testtasks.task.mergeclassnames;

public class Main {
    public static void main(String[] args) {
        System.out.println("Merge Classnames ***");
        System.out.println(ClassnamesMerger.classesToString("button"));
        //noinspection ConfusingArgumentToVarargsMethod
        System.out.println(ClassnamesMerger.classesToString(new String[]{"button", "disable"}));
        System.out.println(ClassnamesMerger.classesToString("button", new String[]{"primary", "disable"}));
        System.out.println("*** Merge Classnames");
    }
}