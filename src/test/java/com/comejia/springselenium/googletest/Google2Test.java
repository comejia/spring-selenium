package com.comejia.springselenium.googletest;

import com.comejia.springselenium.SpringBaseTestNG;
import com.comejia.springselenium.pages.google.GooglePage;
import com.comejia.springselenium.utils.ScreenShotUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class Google2Test extends SpringBaseTestNG {

    @Autowired
    private WebDriver driver;

    @AfterTest
    void tearDown() {
        driver.quit();
    }

    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("selenium ");
        assertTrue(this.googlePage.getSearchResult().isAt());
        assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takeScreenshot(".png");
        //this.googlePage.close();
    }
}
