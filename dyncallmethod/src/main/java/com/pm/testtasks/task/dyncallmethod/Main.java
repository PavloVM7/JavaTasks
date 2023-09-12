package com.pm.testtasks.task.dyncallmethod;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    static String getMethodName(String property) {
        if (property == null || property.isEmpty() || property.isBlank()) {
            throw new IllegalArgumentException(String.format("property name '%s' not valid", property));
        }
        property = property.trim();
        var result = "get" + property.substring(0, 1).toUpperCase();
        if (property.length() > 1) {
            result += property.substring(1);
        }
        return result;
    }

    static Object getObjectProperty(Object object, String property) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final var methodName = getMethodName(property);
        Method method = getMethod(object.getClass(), methodName);
        if (method == null) {
            throw new NoSuchMethodException(String.format("Method '%s' not found.", methodName));
        }
        if (method.trySetAccessible()) {
            return method.invoke(object);
        }
        throw new IllegalAccessException(String.format("Method '%s' not accessible", methodName));
    }

    private static Method getMethod(Class<?> clazz, String methodName) {
        for (var method : clazz.getDeclaredMethods()) {
            if (methodName.equals(method.getName())) {
                return method;
            }
        }
        var cl = clazz.getSuperclass();
        return cl != null ? getMethod(cl, methodName) : null;
    }

    public static void main(String[] args) {
        System.out.println("*** Dynamically call a method");
        final var name = "any-file.dat";
        final var object = new File(name);
        try {
            System.out.printf("name: '%s'%n" +
                            "path: '%s'%n" +
                            "absolute path: '%s'%n" +
                            "canonical path: '%s'%n" +
                            "parent: '%s'%n" +
                            "total space: %s%n" +
                            "free space: %s%n" +
                            "usable space: %s%n" +
                            "class: '%s'%n",
                    getObjectProperty(object, "name"),
                    getObjectProperty(object, "path"),
                    getObjectProperty(object, "absolutePath"),
                    getObjectProperty(object, "canonicalPath"),
                    getObjectProperty(object, "parent"),
                    getObjectProperty(object, "totalSpace"),
                    getObjectProperty(object, "freeSpace"),
                    getObjectProperty(object, "usableSpace"),
                    getObjectProperty(object, "class")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dynamically call a method ***");
    }


}