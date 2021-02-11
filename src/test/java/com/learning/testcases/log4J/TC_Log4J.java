package com.learning.testcases.log4J;

import org.apache.log4j.Logger;

public class TC_Log4J {

	/* Get actual class name to be printed on */
	public static Logger log = Logger.getLogger(TC_Log4J.class.getName());
	// public static Logger log = LogManager.getLogger(TC_Log4J.class.getName());

	public static void main(String[] args) {

		// DOMConfigurator.configure("./src/test/resources/log4j.xml");
		log.debug("This is Debug message");
		log.info("This is Info message");
		log.warn("This is Warn message");
		log.error("This is Error message");
		log.fatal("This is Fatal message");
		log.trace("This is Trace message");

	}
}
