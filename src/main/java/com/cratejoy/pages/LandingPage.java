package com.cratejoy.pages;

import com.cratejoy.pages.BasePage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
@Log4j2
public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);


    }


    public ProductPage navigateToProductPage() {

        return new ProductPage(driver);
    }
}
