package com.comejia.springselenium.condition;

import com.comejia.springselenium.SpringBaseTestNG;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CarTest extends SpringBaseTestNG {

    @Qualifier("civic")
    @Autowired
    private Car car;

    @Test
    public void carTest() {
        this.car.run();
    }
}
