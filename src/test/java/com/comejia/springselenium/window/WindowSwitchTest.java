package com.comejia.springselenium.window;

import com.comejia.springselenium.SpringBaseTestNG;
import com.comejia.springselenium.kelvin.service.WindowSwitchService;
import com.comejia.springselenium.pages.window.MainPage;
import com.comejia.springselenium.pages.window.PageA;
import com.comejia.springselenium.pages.window.PageB;
import com.comejia.springselenium.pages.window.PageC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@TestPropertySource(properties = "browser=chrome")
public class WindowSwitchTest extends SpringBaseTestNG {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private PageA pageA;
    @Autowired
    private PageB pageB;
    @Autowired
    private PageC pageC;

    //@Autowired
    //private WindowSwitchService switchService;

    @BeforeClass
    public void setup() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.launchAllWindows();
    }

    @Test(dataProvider = "getData")
    public void switchTest(int index) {
        //this.switchService.switchByTitle("Page A");
        //this.pageA.addToArea("Hi page A");
        //this.switchService.switchByIndex(2);
        //this.pageB.addToArea("Hello page B");
        this.pageA.addToArea(index + "\n");
        this.pageB.addToArea(index * 2 + "\n");
        this.pageC.addToArea(index * 3 + "\n");
    }

    @DataProvider
    public Object[] getData() {
        return new Object[] {
                3,
                4,
                1,
                5,
                6,
                2
        };
    }
}
