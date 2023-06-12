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
        try {
            // ...
            reusableMethods.click(HomePageLocators.BASKET_BUTTON);

        } catch (Exception e) {
            reusableMethods.click(BasketPageLocators.POP_UP_BASKET);
            Thread.sleep(2000);
            reusableMethods.click(HomePageLocators.BASKET_BUTTON);

            e.printStackTrace();
        }
        Thread.sleep(1000);
        reusableMethods.click(BasketPageLocators.BASKET_PRODUCT_DELETE);
        Thread.sleep(1000);

    }
}
