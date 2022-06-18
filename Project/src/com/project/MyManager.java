package com.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
 
public class MyManager {
 
    private static final LogManager logManager = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger("confLogger");
    static{
        try {
            logManager.readConfiguration(new FileInputStream("./project.properties"));
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error in loading configuration",exception);
        }
    }
    public static void main(String[] args) {
        LOGGER.fine("Message logged");
    }
}