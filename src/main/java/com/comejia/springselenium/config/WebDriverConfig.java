package com.comejia.springselenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:20}")
    private int timeout;

    @Bean
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().driverVersion("97.0.4692.71").setup();
        return new ChromeDriver();
    }

    @Bean
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
}
