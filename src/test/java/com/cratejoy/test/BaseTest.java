package com.cratejoy.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cratejoy.pages.LandingPage;
import com.cratejoy.pages.Login;
import com.cratejoy.util.TestDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
@Log4j2
public class BaseTest extends TestDriverManager {

    protected LandingPage landingPage=null;

    protected WebDriver driver;
    static  ExtentReports extent;

    @BeforeSuite
    public void initReporting(){
        extent = new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter("./reports/index.html");
        extent.attachReporter(spark);
    }

    @AfterSuite
    public void flushReports(){
        extent.flush();
    }


    @BeforeMethod
    public void initTest(Method method) throws InterruptedException {
        log.info("======= starting execution of test Method" + method.getName() + "===========");
        driver=TestDriverManager.getDriver();
        Login login=new Login(driver);

    }

    @AfterMethod
    public void tearDown(Method method){
        driver.quit();
        log.info("======= completing execution of test Method" + method.getName()+"===========");

    }
}
