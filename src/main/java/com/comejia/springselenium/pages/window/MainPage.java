package com.comejia.springselenium.pages.window;

import com.comejia.springselenium.kelvin.annotation.Page;
import com.comejia.springselenium.pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Page
public class MainPage extends Base {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void launchAllWindows() {
        for (int i = 0; i < links.size(); i++) { // workaround for firefox
        //for (WebElement link : links) {
            links.get(i).click();
            this.wait.until(ExpectedConditions.numberOfWindowsToBe(i + 2));
        }
        //links.forEach(WebElement::click);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> !this.links.isEmpty());
    }
}
