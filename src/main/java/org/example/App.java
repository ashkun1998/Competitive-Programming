package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 */
public class App {
    static Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Hello World!");
    }
}
