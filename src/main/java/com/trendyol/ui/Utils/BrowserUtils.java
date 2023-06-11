package com.trendyol.ui.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtils {
        public static WebDriver getDriver(String browser) {
            WebDriver driver;

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("--headless"); // Headless modu on
                    options.addArguments("--disable-notifications");
                    driver = new ChromeDriver(options);
                    break;
                case "firefox":
                    FirefoxOptions optionsf = new FirefoxOptions();
                    optionsf.addPreference("dom.webnotifications.enabled", false);
                     driver = new FirefoxDriver(optionsf);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }

            return driver;
        }
    }


