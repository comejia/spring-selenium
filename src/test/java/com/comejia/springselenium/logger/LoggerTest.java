package com.comejia.springselenium.logger;

import com.comejia.springselenium.SpringBaseTestNG;
import com.comejia.springselenium.visa.UserVisaTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoggerTest extends SpringBaseTestNG {

    private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

    @Test
    public void loggerTest() {
        logger.error("Request");
        logger.warn("Request");
        logger.info("Request");
        logger.debug("Request");
        logger.trace("Request");
    }
}
