package com.comejia.springselenium.scope;

import com.comejia.springselenium.SpringBaseTestNG;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class JuniorSeniorTest extends SpringBaseTestNG {

    @Autowired
    private JuniorEng junior;

    @Autowired
    private SeniorEng senior;

    @Test
    public void scopeTest() {
        this.junior.setAmount(100);
        System.out.println("Junior :: " + this.junior.getSalary().getAmount());
        this.senior.setAmount(200);
        System.out.println("Senior :: " + this.senior.getSalary().getAmount());
        System.out.println("Junior :: " + this.junior.getSalary().getAmount());
    }
}
