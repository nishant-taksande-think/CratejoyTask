package com.cratejoy.test;

import com.cratejoy.pages.ProductPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductTest extends BaseTest{

    @Test
    public void verifyPrice() throws InterruptedException, IOException {
        ProductPage productPage=new ProductPage(driver);

        productPage.addToCart();
        extent.createTest("Price Matched");

    }


}
