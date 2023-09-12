package com.pm.testtasks.task.fibonacci;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger("com.pm.testtasks.task.fibonacci");
    public static void main(String[] args) {
        logger.info("Fibonacci Numbers");
        for (var count : new int[]{10, 20}) {
            var array = FibonacciNumbers.calculate(count);
            logger.info(String.format(String.format("%d => %s", count, Arrays.toString(array))));
        }
        logger.info("Fibonacci Numbers finished *****");
    }
}