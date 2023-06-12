package com.trendyol.ui.locators;

import org.openqa.selenium.By;

public interface SearchPageLocators {

    By PRODUCT_TITLE = By.cssSelector("h1.pr-new-br span");//DONE
    By BRAND_FILTER = By.cssSelector("input.fltr-srch-inpt");//DONE
    By GET_BRAND_OPTION_LOCATOR = By.xpath("(//div[@class='chckbox'])[1]");//DONE
    By PRICE_FILTER = By.xpath("(//div[@class='fltr-cntnr-ttl-area'][contains(.,'Fiyat')])[1]");//DONE
    By MIN_PRICE_INPUT = By.cssSelector(".fltr-srch-prc-rng-input.min");//DONE
    By MAX_PRICE_INPUT = By.cssSelector(".fltr-srch-prc-rng-input.max");//DONE
    By PRICE_FILTER_APPLY_BUTTON = By.cssSelector(".fltr-srch-prc-rng-srch");//DONE
    By ADD_TO_FAVORITES_BUTTON = By.xpath("(//div[@class='fvrt-btn-wrppr'])[index]");//DONE
    By ADDED_TO_FAVORITES_SUCCESS_MESSAGE = By.xpath("(//i[@class='fvrt-btn fvred'])[1]");//DONE
    By PRODUCT_FOR_INDEX_ALTERNATIVE = By.xpath("(//div[@class='product-image-wrapper '])[index]");//DONE
    By PRODUCT_FOR_INDEX = By.xpath("//div[contains(@class, 'p-card-wrppr')][index]");//DONE


    By POP_UP = By.cssSelector(".overlay");//DONE


}

