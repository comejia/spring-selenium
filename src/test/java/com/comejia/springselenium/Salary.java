package com.comejia.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Salary {
    private final int amount;

    @Value("${price:500}")
    private int price;

    private int iva;


    public Salary() {
        this.amount = 1000;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getPrice() {
        return this.price;
    }

    @Value("${iva:18}")
    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getIva() {
        return iva;
    }
}
