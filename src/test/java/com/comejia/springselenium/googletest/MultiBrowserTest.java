package com.comejia.springselenium.googletest;

import com.comejia.springselenium.SpringBaseTestNG;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

/**
 * NOTE: For run this test you need comment in WebDriverConfig class this lines:
 * - ConditionalOnProperty(name = "browser", havingValue = "firefox")
 * - ConditionalOnMissingBean
 */
public class MultiBrowserTest extends SpringBaseTestNG {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest() {
        this.ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com");
        this.ctx.getBean("firefoxDriver", WebDriver.class).get("https://www.yahoo.com");
    }
}
