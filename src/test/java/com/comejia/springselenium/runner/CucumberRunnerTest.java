package com.comejia.springselenium.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.comejia.springselenium.configuration", "com.comejia.springselenium.stepDefinitions"},
        tags = "@visa",
        plugin = {
                "pretty",
                "html:target/cucumber/index.html",
                "json:target/cucumber/cucumber.json",
                "junit:target/cucumber/cucumber.xml"
        }
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
