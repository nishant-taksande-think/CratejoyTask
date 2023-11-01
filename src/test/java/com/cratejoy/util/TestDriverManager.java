package com.cratejoy.util;

import com.cratejoy.util.TestConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestDriverManager {
   // static WebDriver driver;

    public static WebDriver getDriver() {
        WebDriver driver=null;








       String browserName = TestConfigReader.read("browser.name");

        try {


            switch (browserName.toLowerCase()) {
                case "firefox":
                    driver= new FirefoxDriver();
                    break;
                case "chrome":
                default:
                   driver = new ChromeDriver();
                    driver.manage().window().maximize();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
    }

