package com.trendyol.ui.Pages;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.trendyol.ui.locators.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;

public class SearchPage extends BasePage {
    private static final Logger logger = Logger.getLogger(SearchPage.class);
    static {
        BasicConfigurator.configure();
    }

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

        try {
            reusableMethods.click(SearchPageLocators.COUPON_CLOSE);
        } catch (Exception e) {
        }

        try {
            reusableMethods.click(newLocator);

        } catch (Exception e) {
            reusableMethods.click(SearchPageLocators.POP_UP);
            Thread.sleep(2000);
            reusableMethods.click(newLocator);
        }
        Assert.assertTrue(reusableMethods.isDisplayed(SearchPageLocators.ADDED_TO_FAVORITES_SUCCESS_MESSAGE));
    }

    static void checkProductsImages(int first, int last) throws IOException, InterruptedException {
        for (int i = first; i <= last; i++) {
            String newLocator = SearchPageLocators.PRODUCT_FOR_INDEX.toString();
            newLocator = newLocator.replace("By.xpath: ", "");
            newLocator = newLocator.replace("[index]", "["+i+"]");
            By newProductLocator = By.xpath(newLocator);
            String productName;
            String newLocatorAlt = SearchPageLocators.PRODUCT_FOR_INDEX_ALTERNATIVE.toString();
            newLocatorAlt = newLocatorAlt.replace("By.xpath: ", "");
            newLocatorAlt = newLocatorAlt.replace("[index]", "["+i+"]");
            By newProductLocatorAlt = By.xpath(newLocatorAlt);
            String newLocatorGet = SearchPageLocators.PRODUCT_FOR_INDEX_GET_TEXT.toString();
            newLocatorGet = newLocatorGet.replace("By.xpath: ", "");
            newLocatorGet = newLocatorGet.replace("[index]", "["+i+"]");
            By newProductLocatorGet = By.xpath(newLocatorGet);
            String newLocatorAltGets = SearchPageLocators.PRODUCT_FOR_INDEX_ALTERNATIVE_GET_TEXT.toString();
            newLocatorAltGets = newLocatorAltGets.replace("By.xpath: ", "");
            newLocatorAltGets = newLocatorAltGets.replace("[index]", "["+i+"]");
            By newProductLocatorAltGet = By.xpath(newLocatorAltGets);
            boolean isImageDisplayed=false;
            try {
                productName = reusableMethods.getTextOfElement(newProductLocatorGet);
                reusableMethods.scrollIntoView(newProductLocator);
                isImageDisplayed = reusableMethods.isDisplayed(newProductLocator);

            } catch (Exception e) {
                try {
                    productName = reusableMethods.getTextOfElement(newProductLocatorAltGet);
                    reusableMethods.scrollIntoView(newProductLocatorAlt);
                    isImageDisplayed = reusableMethods.isDisplayed(newProductLocatorAlt);

                    // ...
                } catch (Exception exception) {
                    reusableMethods.click(SearchPageLocators.POP_UP);
                    Thread.sleep(1000);
                    try {
                        productName = reusableMethods.getTextOfElement(newProductLocatorGet);
                        reusableMethods.scrollIntoView(newProductLocator);
                        isImageDisplayed = reusableMethods.isDisplayed(newProductLocator);


                        // ...
                    } catch (Exception exceptions) {
                        productName = reusableMethods.getTextOfElement(newProductLocatorAltGet);
                        reusableMethods.scrollIntoView(newProductLocatorAlt);
                        isImageDisplayed = reusableMethods.isDisplayed(newProductLocatorAlt);

                    }
                    }
                }
            logger.info("Product: " + productName + ", Image Displayed: " + isImageDisplayed);

            System.out.println("Product: " + productName + ", Image Displayed: " + isImageDisplayed);

        }
    }

}
