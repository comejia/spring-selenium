package com.comejia.springselenium.basic_injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

    private String street;

    @Value("${address}")
    private String address;

    public Address() {
        this.street = "123 non main st";
    }

    public String getStreet() {
        return this.street;
    }

    public String getAddress() {
        return address;
    }
}
