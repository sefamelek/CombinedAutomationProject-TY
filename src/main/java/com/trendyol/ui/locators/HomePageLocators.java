package com.trendyol.ui.locators;

import org.openqa.selenium.By;

public interface HomePageLocators {

    // Home page
    String HOME_PAGE_TITLE = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";//DONE
    By HOME_PAGE_NONLOGIN_USER_LOGIN_MENU = By.cssSelector(".user-login-container"); //DONE
    By HOME_PAGE_LOGIN_USER_LOGIN_MENU = By.cssSelector(".new-user-loggedin-container");//DONE

    By HOME_PAGE_ACCEPT_COOKIES = By.cssSelector("button#onetrust-accept-btn-handler");//DONE
    By SEARCH_BAR = By.cssSelector("input.V8wbcUhU");//DONE

    By BASKET_BUTTON = By.cssSelector(".account-basket");//DONE
    By FAVORITES_MENU_BUTTON = By.cssSelector(".account-favorites");

    By SEARCH_BUTTON = By.cssSelector(".cyrzo7gC");
    By GET_COMPONENT_LOCATOR = By.xpath("(//article[contains(@class, 'component-item')]//a[contains(@class, 'widget')])[1]");
    By GET_TAB_LOCATOR = By.cssSelector(".tab-link:nth-child(index)");



}

