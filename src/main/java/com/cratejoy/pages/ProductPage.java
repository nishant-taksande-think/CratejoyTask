package com.cratejoy.pages;

import com.cratejoy.util.TestConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ProductPage extends BasePage{
    @FindBy(xpath = "(//div[@class='app--listing-card relative'])[1]")
    WebElement selectProduct;

    @FindBy(xpath = "(//label/h6)[1]")
    WebElement subscriptionOption;

    @FindBy(xpath = "//button[@id='add-to-cart']")
    WebElement addToCart;

    @FindBy(xpath = "//span[@class='text-sm font-semibold ml-auto']")
    WebElement priceListed;

    @FindBy(xpath = "//*[@id=\"cart\"]/div[3]/div/strong[2]")
    WebElement cartPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void addToCart() throws  IOException {

        TakesScreenshot screenshot1 = (TakesScreenshot) driver;
        File sourceFile1 = screenshot1.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(sourceFile1, new File("HomePage.png"));


        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        actions.sendKeys(Keys.ESCAPE).build().perform();


        selectProduct.click();


        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File sourceFile2 = screenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(sourceFile2, new File("ProductPage.png"));


        subscriptionOption.click();

        addToCart.click();

        String productPrice=priceListed.getText();
        String cartValue= cartPrice.getText();

        TakesScreenshot screenshot3 = (TakesScreenshot) driver;
        File sourceFile3 = screenshot3.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(sourceFile3, new File("CartPage.png"));



        Assert.assertEquals(productPrice,cartValue); // Verifying product price and cart price



    }
}
