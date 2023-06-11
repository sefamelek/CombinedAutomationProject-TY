package com.trendyol.ui.Pages;

import com.trendyol.ui.Utils.ReusableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class BasePage {
    protected WebDriver driver;
    protected static ReusableMethods reusableMethods;
    String ProductTitle;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        reusableMethods = new ReusableMethods(driver);
    }

    public String getProductTitle() {
        return ProductTitle;
    }

    public void setProductTitle(String productTitle) {

        ProductTitle = productTitle;
    }


}
