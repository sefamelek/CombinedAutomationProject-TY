package com.trendyol.ui;

import com.trendyol.ui.Pages.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class Scenario2v1 extends BaseUITest {
        private String username = "trendyolotomasyontest@test.com";
        private String password = "trendyoltest123";
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        BasketPage basketPage = new BasketPage(driver);
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        SearchPage searchPage = new SearchPage(driver);

        @Test
        public void MonsterSearch() throws IOException, InterruptedException {
                loginPage.Succesfulllogin(username, password);
                homePage.searchProduct("Oyuncu Bilgisayarı");
                searchPage.filterByBrand("Monster");
                searchPage.filterByPrice(3000,10000);
                productPage.addProductToBasket();
                basketPage.checkProductTıtle();
                basketPage.deleteProducts();

        }

}
