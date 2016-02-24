package com.company;

import org.apache.log4j.Logger;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.error("error");
        logger.debug("debug");
        logger.info("info");
        logger.trace("trace");

	// write your code here

    }
}
