package com.example.vector.loggers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainLogger {
    private static final Logger logger = LoggerFactory.getLogger(MainLogger.class);
    public static void info(String message){
        logger.info(message);
    }
    public static void warn(String message){
        logger.warn(message);
    }
    public static void error(String message){
        logger.error(message);
    }
}