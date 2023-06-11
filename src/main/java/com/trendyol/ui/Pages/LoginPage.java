package com.trendyol.ui.Pages;
import com.trendyol.ui.Utils.ReusableMethods;
import com.trendyol.ui.locators.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import java.io.IOException;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
            super(driver);
        }
    private static final Logger logger = Logger.getLogger(LoginPage.class);

        public void Succesfulllogin(String email, String password) throws IOException, InterruptedException {
            Assert.assertEquals(reusableMethods.getPageTitle(),HomePageLocators.HOME_PAGE_TITLE);
            reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
            reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
            reusableMethods.click(LoginPageLocators.LOGIN_PAGE_BUTTON);
            ReusableMethods.screenShot("Trendyol Login Page");
            reusableMethods.sendKeys(LoginPageLocators.LOGIN_EMAIL, email);
            reusableMethods.sendKeys(LoginPageLocators.LOGIN_PASSWORD, password);
            reusableMethods.click(LoginPageLocators.LOGIN_BUTTON);
            reusableMethods.waitUntilElementIsActive(HomePageLocators.HOME_PAGE_LOGIN_USER_LOGIN_MENU,5);
            Assert.assertEquals(reusableMethods.getTextOfElement(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU),"Hesabım");
            logger.info("Login Succesfull");
        }


    public void failedLogin_InvalidEmail(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.LOGIN_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Login Page");
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.LOGIN_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_EMAIL_ERROR_MESSAGE), "Lütfen geçerli bir e-posta adresi giriniz.");
    }

    public void failedLogin_InvalidPassword(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.LOGIN_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Login Page");
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.LOGIN_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_PASSWORD_ERROR_MESSAGE), "E-posta adresiniz ve/veya şifreniz hatalı.");
    }
    public void failedLogin_EmptyFields(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.LOGIN_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Login Page");
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.LOGIN_BUTTON);
        if (email=="") {
            Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.EMPTY_EMAIL_ERROR_MESSAGE), "Lütfen geçerli bir e-posta adresi giriniz.");
        }
        else {
            Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.EMPTY_PASSWORD_ERROR_MESSAGE), "Lütfen şifrenizi giriniz.");
        }
        }

    public void failedLogin_InvalidCredentials(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.LOGIN_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Login Page");
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.LOGIN_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_CREDENTIALS_ERROR_MESSAGE), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
    public void failedLogin_ReversedFields(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.LOGIN_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Login Page");
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_EMAIL, password);
        reusableMethods.sendKeys(LoginPageLocators.LOGIN_PASSWORD, email);
        reusableMethods.click(LoginPageLocators.LOGIN_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_CREDENTIALS_ERROR_MESSAGE), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
    public void successfulRegistration(String email, String password, String name, String surname) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        //reusableMethods.sendKeys(LoginPageLocators.REGISTER_NAME, name);
        //reusableMethods.sendKeys(LoginPageLocators.REGISTER_SURNAME, surname);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(HomePageLocators.HOME_PAGE_LOGIN_USER_LOGIN_MENU), "Hesabım");
    }
    public void failedRegistration_InvalidEmail(String email, String password, String name, String surname) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        //reusableMethods.sendKeys(LoginPageLocators.REGISTER_NAME, name);
        //reusableMethods.sendKeys(LoginPageLocators.REGISTER_SURNAME, surname);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_EMAIL_ERROR_MESSAGE), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
    public void failedRegistration_WeakPassword(String email, String password, String name, String surname) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
       // reusableMethods.sendKeys(LoginPageLocators.REGISTER_NAME, name);
       // reusableMethods.sendKeys(LoginPageLocators.REGISTER_SURNAME, surname);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.WEAK_PASSWORD_ERROR_MESSAGE), "Zayıf şifre");
    }
    public void failedRegistration_EmptyFields(String email, String password, String name, String surname) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        //reusableMethods.sendKeys(LoginPageLocators.REGISTER_NAME, name);
       // reusableMethods.sendKeys(LoginPageLocators.REGISTER_SURNAME, surname);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.EMPTY_FIELDS_ERROR_MESSAGE), "Lütfen boş alanları doldurunuz");
    }

}

