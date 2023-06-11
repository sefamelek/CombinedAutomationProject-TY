package com.trendyol.ui.Pages;

import com.trendyol.ui.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToBasket() throws IOException, InterruptedException {
        String newLocator = SearchPageLocators.PRODUCT_FOR_INDEX.toString();
        newLocator = newLocator.replace("By.xpath: ", "");
        newLocator = newLocator.replace("[index]", "[1]");
        By newProductLocator = By.xpath(newLocator);
        reusableMethods.click(newProductLocator);
        reusableMethods.switchToTab();
        String sefa = reusableMethods.getTextOfElement(SearchPageLocators.PRODUCT_TITLE);
        setProductTitle(sefa);
        reusableMethods.click(ProductPageLocators.ADD_TO_BASKET_BUTTON);
        reusableMethods.waitUntilElementIsVisible(ProductPageLocators.ADDED_TO_BASKET_SUCCESS_MESSAGE,10);
        Assert.assertTrue(reusableMethods.isDisplayed(ProductPageLocators.ADDED_TO_BASKET_SUCCESS_MESSAGE));
    }


}
