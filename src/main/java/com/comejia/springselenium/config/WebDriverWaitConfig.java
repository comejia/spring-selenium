package com.comejia.springselenium.config;

import com.comejia.springselenium.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:20}")
    private int timeout;

    @Bean
    public WebDriverWait webdriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
}
