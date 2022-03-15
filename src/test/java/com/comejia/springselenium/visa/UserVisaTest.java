package com.comejia.springselenium.visa;

import com.comejia.springselenium.SpringBaseTestNG;
import com.comejia.springselenium.entity.User;
import com.comejia.springselenium.pages.visa.VisaRegistrationPage;
import com.comejia.springselenium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserVisaTest extends SpringBaseTestNG {

    @Autowired
    private UserRepository repository;

    @Autowired
    private VisaRegistrationPage registrationPage;

    @Test
    public void repositoryTest() {
        System.out.println(this.repository.findAll().size());

        this.repository.findById(85)
                .ifPresent(u -> System.out.println(u.getFirstName()));
    }

    @Test
    @Ignore
    public void visaRegistrationTest() {
        List<User> users = this.repository.findAll()
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        users.forEach(u -> {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();
            System.out.println(this.registrationPage.getConfirmationNumber());
        });
    }

    @Test
    @Ignore
    public void visaRegistrationFindByFirstNameTest() {
        List<User> users = this.repository.findByFirstNameStartingWith("Mi")
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        users.forEach(u -> {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();
            System.out.println(this.registrationPage.getConfirmationNumber());
        });
    }


    @Test
    @Ignore
    public void visaRegistrationFindByDobTest() {
        List<User> users = this.repository.findByDobBetween(Date.valueOf("1995-01-01"), Date.valueOf("1999-01-01"))
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        users.forEach(u -> {
            this.registrationPage.goTo();
            this.registrationPage.setNames(u.getFirstName(), u.getLastName());
            this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
            this.registrationPage.setBirthDate(u.getDob().toLocalDate());
            this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
            this.registrationPage.setComments(u.getComments());
            this.registrationPage.submit();
            System.out.println(this.registrationPage.getConfirmationNumber());
        });
    }

    @Test(dataProvider = "getData")
    public void visaRegistrationDataProviderTest(User u) {
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();
        System.out.println(this.registrationPage.getConfirmationNumber());
    }

    @DataProvider
    public Object[] getData(ITestContext context) {
        return this.repository.findByDobBetween(
                    //Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
                    //Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
                    Date.valueOf("1995-01-01"),
                    Date.valueOf("1999-01-01")
                )
                .stream()
                .limit(3)
                .toArray();
    }
}
