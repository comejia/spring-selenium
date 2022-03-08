package com.comejia.springselenium.config;

import com.comejia.springselenium.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
