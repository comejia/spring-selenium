package com.comejia.springselenium.flights;

import com.comejia.springselenium.SpringBaseTestNG;
import com.comejia.springselenium.pages.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FlightTest extends SpringBaseTestNG {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest() {
        this.flightPage.goTo(this.appDetails.getUrl());

        assertTrue(this.flightPage.isAt());
        assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }
}
