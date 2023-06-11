package com.trendyol.ui.Pages;

import com.trendyol.ui.locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.io.IOException;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private static final Logger logger = Logger.getLogger(HomePage.class);

    public void searchProduct(String productName) throws IOException, InterruptedException {
        reusableMethods.sendKeys(HomePageLocators.SEARCH_BAR, productName);
        reusableMethods.click(HomePageLocators.SEARCH_BUTTON);
        Assert.assertTrue(reusableMethods.getPageTitle().contains(productName));
    }

    public void checkProductImagesInTabs(int firstTabIndex, int lastTabIndex, int firstProductIndex, int lastProductIndex) throws IOException, InterruptedException {
        for (int i = firstTabIndex; i <= lastTabIndex; i++) {
            String newLocator = HomePageLocators.GET_COMPONENT_LOCATOR.toString();
            newLocator = newLocator.replace("[index]", "[" + i + "]");
            By newComponentLocator = By.xpath(newLocator);
            reusableMethods.click(newComponentLocator);
            SearchPage.checkProductsImages(firstProductIndex, lastProductIndex);
            logger.info("Tab " +  firstTabIndex +", Checked ");

        }


    }
}
