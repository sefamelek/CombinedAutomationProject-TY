package com.trendyol.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.trendyol.ui.locators.*;
import org.testng.log4testng.Logger;

import java.io.IOException;

public class SearchPage extends BasePage {
    private static final Logger logger = Logger.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        super(driver);
    }



    public void filterByBrand(String brandName) throws IOException, InterruptedException {
        reusableMethods.sendKeys(SearchPageLocators.BRAND_FILTER,brandName);
        reusableMethods.click(SearchPageLocators.GET_BRAND_OPTION_LOCATOR);
    }
    public void filterByPrice(int minPrice, int maxPrice) throws IOException, InterruptedException {
        reusableMethods.waitUntilElementIsVisible(SearchPageLocators.PRICE_FILTER,5);
        reusableMethods.click(SearchPageLocators.PRICE_FILTER);
        reusableMethods.sendKeys(SearchPageLocators.MIN_PRICE_INPUT, String.valueOf(minPrice));
        reusableMethods.sendKeys(SearchPageLocators.MAX_PRICE_INPUT, String.valueOf(maxPrice));
        reusableMethods.click(SearchPageLocators.PRICE_FILTER_APPLY_BUTTON);
    }



    public void addProductToFavorites(int productIndex) throws IOException, InterruptedException {
        String newProductLocators = SearchPageLocators.PRODUCT_FOR_INDEX.toString();
        newProductLocators = newProductLocators.replace("By.xpath: ", "");
        newProductLocators = newProductLocators.replace("[index]", "["+productIndex+"]");
        By newProductLocator = By.xpath(newProductLocators);
        reusableMethods.hover(newProductLocator);
        String newLocators = SearchPageLocators.ADD_TO_FAVORITES_BUTTON.toString();
        newLocators = newLocators.replace("By.xpath: ", "");
        newLocators = newLocators.replace("[index]", "["+productIndex+"]");
        By newLocator = By.xpath(newLocators);
        reusableMethods.hover(newLocator);
        try {
            // ...
            reusableMethods.click(newLocator);

        } catch (Exception e) {
            reusableMethods.click(SearchPageLocators.POP_UP);
            Thread.sleep(2000);
            reusableMethods.click(newLocator);

            e.printStackTrace();
        }
        Assert.assertTrue(reusableMethods.isDisplayed(SearchPageLocators.ADDED_TO_FAVORITES_SUCCESS_MESSAGE));
    }

    static void checkProductsImages(int first, int last) throws IOException, InterruptedException {
        for (int i = first; i <= last; i++) {
            String newLocator = SearchPageLocators.PRODUCT_FOR_INDEX.toString();
            newLocator = newLocator.replace("By.xpath: ", "");
            newLocator = newLocator.replace("[index]", "["+i+"]");
            By newProductLocator = By.xpath(newLocator);
            reusableMethods.click(newProductLocator);
            reusableMethods.waitUntilElementIsVisible(newProductLocator,10);
            String productName = reusableMethods.getTextOfElement(newProductLocator);
            boolean isImageDisplayed = reusableMethods.waitUntilElementIsVisible(newProductLocator,10);
            logger.info("Product: " + productName + ", Image Displayed: " + isImageDisplayed);

        }
    }

}
