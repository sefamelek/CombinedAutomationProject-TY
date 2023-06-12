package com.trendyol.ui;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.trendyol.api.Utils.ExtentReportManager;
import com.trendyol.ui.Pages.*;
import com.trendyol.ui.Utils.BrowserUtils;
import com.trendyol.ui.Utils.ReusableMethods;
import com.trendyol.ui.locators.BasketPageLocators;
import com.trendyol.ui.locators.FavoritesPageLocators;
import com.trendyol.ui.locators.HomePageLocators;
import com.trendyol.ui.locators.SearchPageLocators;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static com.trendyol.ui.Pages.BasePage.reusableMethods;


public class BaseUITest {
    protected WebDriver driver;
    ExtentReports extent = ExtentReportManager.getInstance();
    public static Logger logger;


    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) throws IOException {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = BrowserUtils.getDriver("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = BrowserUtils.getDriver("firefox");
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = BrowserUtils.getDriver("safari");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com/");
        ReusableMethods.setDriver(driver);
        ReusableMethods.screenShot("Trendyol Main Page");

        logger= Logger.getLogger("Automation");//added Logger
        logger.setLevel(Level.DEBUG);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

        driver.quit();


    }

    @AfterSuite
    public void tearDown() {

        extent.flush();

    }
    }


