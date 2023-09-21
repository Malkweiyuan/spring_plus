package com.example.springplus.tool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerUtils {

    private LoggerUtils() {
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
