package com.comejia.springselenium.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeniorEng {

    @Autowired
    private Salary2 salary;

    public Salary2 getSalary() {
        return salary;
    }

    public void setAmount(int amount) {
        this.salary.setAmount(amount);
    }
}
