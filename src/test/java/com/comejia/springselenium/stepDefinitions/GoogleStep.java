package com.comejia.springselenium.stepDefinitions;

import com.comejia.springselenium.kelvin.annotation.LazyAutowired;
import com.comejia.springselenium.pages.google.GooglePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;

import static org.testng.Assert.assertTrue;

@SpringBootTest
public class GoogleStep {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void launchSite() {
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() {
        assertTrue(this.googlePage.getSearchResult().isAt());
        
    }

    @And("I should see at least {int} results")
    public void iShouldSeeAtLeastCountResults(int count) {
        assertTrue(this.googlePage.getSearchResult().getCount() >= count);
    }

}
