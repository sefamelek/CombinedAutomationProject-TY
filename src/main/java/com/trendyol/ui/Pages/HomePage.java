package com.trendyol.ui.Pages;

import com.trendyol.ui.Utils.ReusableMethods;
import com.trendyol.ui.locators.HomePageLocators;
import com.trendyol.ui.locators.SearchPageLocators;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BasePage{
    private static final org.apache.log4j.Logger logger = Logger.getLogger(SearchPage.class);
    static {
        BasicConfigurator.configure();
    }
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) throws IOException, InterruptedException {
        reusableMethods.sendKeys(HomePageLocators.SEARCH_BAR, productName);
        reusableMethods.click(HomePageLocators.SEARCH_BUTTON);
        Assert.assertTrue(reusableMethods.getPageTitle().contains(productName));
    }

    public void checkProductImagesInTabs(int firstTabIndex, int lastTabIndex, int firstProductIndex, int lastProductIndex) throws IOException, InterruptedException {
        for (int i = firstTabIndex; i <= lastTabIndex; i++) {
            String newLocator = HomePageLocators.GET_TAB_LOCATOR.toString();
            newLocator = newLocator.replace("By.cssSelector: ", "");
            newLocator = newLocator.replace("(index)", "(" + i + ")");
            By newTabLocator = By.cssSelector(newLocator);
            reusableMethods.scrollIntoView(newTabLocator);
            try {
                reusableMethods.click(newTabLocator);
            } catch (Exception e) {
                reusableMethods.click(SearchPageLocators.POP_UP);
                Thread.sleep(1000);
            reusableMethods.click(newTabLocator);
            ;}

            reusableMethods.click(HomePageLocators.GET_COMPONENT_LOCATOR);
            SearchPage.checkProductsImages(firstProductIndex, lastProductIndex);
            ReusableMethods.screenShot("Tab " +  i +", ScreenShot ");
            System.out.println("Tab " +  i +", Checked ");
            logger.info("Tab " +  i +", Checked ");


        }


    }
}
