package com.comejia.springselenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.comejia.springselenium.configuration", "com.comejia.springselenium.stepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
