package com.trendyol.ui.Pages;

import com.trendyol.ui.locators.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class FavoritesPage extends BasePage{
    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public void addFavoriteProductToBasket(int productIndex) throws IOException, InterruptedException {
        //reusableMethods.click(ProductPageLocators.ADD_TO_BASKET_BUTTON);
        reusableMethods.click(HomePageLocators.FAVORITES_MENU_BUTTON);
        String newLocator = FavoritesPageLocators.FAVORITES_PRODUCT_ADD_BASKET_FOR_INDEX.toString();
        newLocator = newLocator.replace("By.cssSelector: ", "");
        newLocator = newLocator.replace("(index)", "("+productIndex+")");
        By newProductLocator = By.cssSelector(newLocator);
        System.out.println(newProductLocator);
        reusableMethods.click(newProductLocator);
        reusableMethods.waitUntilElementIsVisible(ProductPageLocators.ADDED_TO_BASKET_SUCCESS_MESSAGE_IN_FAVORITES, 5);
        Assert.assertTrue(reusableMethods.isDisplayed(ProductPageLocators.ADDED_TO_BASKET_SUCCESS_MESSAGE_IN_FAVORITES));

    }
}
