package com.comejia.springselenium;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringSeleniumApplicationTests {

    @Autowired
    private User user;
    @Autowired
    private User2 user2;
    @Autowired
    private User3 user3;

    @Value("${PATH}")
    private String path;
    @Value("${fruits}")
    private List<String> fruits;
    @Value("${timeout}")
    private int timeout;
    @Value("${username}")
    private String username;
    @Value("${TEST_URL:https://www.google.com}")
    private String url;

    @Autowired
    private Faker faker;

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

    @Test
    @DisplayName("Simple value injection")
    void valueInjection() {
        System.out.println(this.path);
        System.out.println(this.fruits);
        System.out.println(this.timeout);
        System.out.println(this.username);
        System.out.println(this.url);
    }

    @Test
    @DisplayName("Default value injection")
    void defaultValueInjection() {
        System.out.println(this.url);
        user.printDefaultValues();
    }

    @Test
    @DisplayName("Injection to external object")
    void injectionToOtherObject() {
        //Faker faker = new Faker();
        System.out.println(faker.name().firstName());
    }

}
