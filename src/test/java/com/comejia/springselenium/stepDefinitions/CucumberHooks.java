package com.comejia.springselenium.stepDefinitions;

import com.comejia.springselenium.kelvin.annotation.LazyAutowired;
import com.comejia.springselenium.kelvin.service.ScreenShotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenShotService screenShotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenShotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario() {
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
