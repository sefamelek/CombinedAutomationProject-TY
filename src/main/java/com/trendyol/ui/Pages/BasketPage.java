package com.trendyol.ui.Pages;

import com.trendyol.ui.locators.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void checkProductTıtle() throws IOException, InterruptedException {
        reusableMethods.click(HomePageLocators.BASKET_BUTTON);
        Assert.assertTrue(reusableMethods.isDisplayed(FavoritesPageLocators.BASKET_PAGE_PRODUCT));
    }

    public void deleteProducts() throws IOException, InterruptedException {
        reusableMethods.isClickable(BasketPageLocators.BASKET_PRODUCT_DELETE);
    }
}
