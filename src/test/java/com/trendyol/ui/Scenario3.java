package com.trendyol.ui;

import com.trendyol.ui.Pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class Scenario3 extends BaseUITest{
    private String username = "testuser";
    private String password = "testpassword";
    LoginPage loginPage = new LoginPage(driver);
    BasePage basePage = new BasePage(driver);
    BasketPage basketPage = new BasketPage(driver);
    FavoritesPage favoritesPage = new FavoritesPage(driver);
    HomePage homePage = new HomePage(driver);
    ProductPage productPage = new ProductPage(driver);
    SearchPage searchPage = new SearchPage(driver);

    @Test
    public void MonsterSearch() throws IOException, InterruptedException, IOException {
        loginPage.Succesfulllogin("test@example.com", "password123");
        homePage.checkProductImagesInTabs(1,8,1,4);

    }
}
