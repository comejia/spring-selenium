package com.comejia.springselenium.googletest;

import com.comejia.springselenium.SpringBaseTestNG;
import com.comejia.springselenium.pages.google.GooglePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleTest extends SpringBaseTestNG {

    @Autowired
    private GooglePage googlePage;

    @Test
    public void googleTest() {
        this.googlePage.goTo();
        assertTrue(this.googlePage.isAt());

        this.googlePage.getSearchComponent().search("spring boot");
        assertTrue(this.googlePage.getSearchResult().isAt());
        assertTrue(this.googlePage.getSearchResult().getCount() > 2);
    }
}
