package com.comejia.springselenium;

import org.springframework.stereotype.Component;

@Component
public class Salary {
    private final int amount;

    public Salary() {
        this.amount = 1000;
    }

    public int getAmount() {
        return this.amount;
    }
}
