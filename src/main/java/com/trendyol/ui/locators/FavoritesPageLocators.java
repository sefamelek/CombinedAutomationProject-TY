package com.trendyol.ui.locators;

import org.openqa.selenium.By;

public interface FavoritesPageLocators {

    // Favorites page

    By BASKET_PAGE_PRODUCT = By.xpath("(//p[@class='pb-item'])[1]");//DONE

    By FAVORITES_PRODUCT_ADD_BASKET_FOR_INDEX = By.cssSelector(".p-card-wrppr:nth-child(index) .basket-button");
    By FAVORITES_PRODUCT_DELETE = By.cssSelector(".p-card-wrppr:nth-child(1) .ufvrt-btn-wrppr");

}

