package com.comejia.springselenium;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSeleniumApplicationTests {

    @Autowired
    private User user;
    @Autowired
    private User2 user2;
    @Autowired
    private User3 user3;

	@Test
    @DisplayName("Dependency injection whitout Spring")
	void injectionWhitoutSpring() {
        Address address = new Address();
        Salary salary = new Salary();

        User commonUser = new User(address, salary);
        commonUser.printDetails();
	}

    @Test
    @DisplayName("Dependency injection using class constructor")
    void constructorInjection() {
        user.printDetails();
    }

    @Test
    @DisplayName("Dependency injection using setter methods")
    void methodInjection() {
        user2.printDetails();
    }

    @Test
    @DisplayName("Dependency injection using fields")
    void fieldInjection() {
        user3.printDetails();
    }

}
