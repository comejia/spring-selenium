package com.comejia.springselenium.kelvin.config;

import com.comejia.springselenium.kelvin.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
