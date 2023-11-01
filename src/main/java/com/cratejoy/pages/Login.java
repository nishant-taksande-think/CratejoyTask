package com.cratejoy.pages;

import com.cratejoy.util.TestConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Login {

    protected final WebDriver driver;

    public Login(WebDriver driver)  {
        this.driver = driver;
        driver.get(TestConfigReader.read("app.url"));
        PageFactory.initElements(driver, this);
    }

}
