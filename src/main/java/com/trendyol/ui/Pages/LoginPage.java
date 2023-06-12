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
        String test=reusableMethods.getTextOfElement(LoginPageLocators.INVALID_CREDENTIALS_ERROR_MESSAGE);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_CREDENTIALS_ERROR_MESSAGE), "E-posta adresiniz ve/veya şifreniz hatalı.");
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
    public void successfulRegistration(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.REGISTER_MARKETING_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_PERSONAL_DATA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.GENDER_MALE);
        reusableMethods.CaptchaSwitchFrame(LoginPageLocators.RECAPTCHA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertTrue(reusableMethods.isDisplayed(LoginPageLocators.EMAIL_VERIFY_POP_UP));
    }
    public void failedRegistration_InvalidEmail(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.REGISTER_MARKETING_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_PERSONAL_DATA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.GENDER_MALE);
        reusableMethods.CaptchaSwitchFrame(LoginPageLocators.RECAPTCHA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.INVALID_EMAIL_ERROR_MESSAGE), "Lütfen geçerli bir e-posta adresi giriniz.");
    }
    public void failedRegistration_WeakPassword(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.REGISTER_MARKETING_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_PERSONAL_DATA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.GENDER_MALE);
        reusableMethods.CaptchaSwitchFrame(LoginPageLocators.RECAPTCHA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.WEAK_PASSWORD_ERROR_MESSAGE), "Zayıf Şifre");
    }
    public void failedRegistration_EmptyFields(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.REGISTER_PERSONAL_DATA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_MARKETING_CHECKBOX);
        reusableMethods.click(LoginPageLocators.GENDER_MALE);
        reusableMethods.CaptchaSwitchFrame(LoginPageLocators.RECAPTCHA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        if (email=="") {
            Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.EMPTY_FIELDS_ERROR_MESSAGE), "E-posta ve şifrenizi giriniz.");

        }
        else {
            Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.EMPTY_FIELDS_ERROR_MESSAGE), "Şifreniz 7 ile 64 karakter arasında olmalıdır.");

        }


    }


    public void registerScenario_EmptyCaptchaVerification(String email, String password) throws IOException, InterruptedException {
        Assert.assertEquals(reusableMethods.getPageTitle(), HomePageLocators.HOME_PAGE_TITLE);
        reusableMethods.click(HomePageLocators.HOME_PAGE_ACCEPT_COOKIES);
        reusableMethods.hover(HomePageLocators.HOME_PAGE_NONLOGIN_USER_LOGIN_MENU);
        reusableMethods.click(LoginPageLocators.SIGN_UP_PAGE_BUTTON);
        ReusableMethods.screenShot("Trendyol Sign Up Page");
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_EMAIL, email);
        reusableMethods.sendKeys(LoginPageLocators.REGISTER_PASSWORD, password);
        reusableMethods.click(LoginPageLocators.REGISTER_PERSONAL_DATA_CHECKBOX);
        reusableMethods.click(LoginPageLocators.REGISTER_MARKETING_CHECKBOX);
        reusableMethods.click(LoginPageLocators.GENDER_MALE);
        reusableMethods.click(LoginPageLocators.REGISTER_BUTTON);
        Assert.assertEquals(reusableMethods.getTextOfElement(LoginPageLocators.CAPTCHA_ERROR_MESSAGE),"Üyelik işlemini güvenli hale getirmek için \"Ben robot değilim\" alanına tıklayınız.");
    }
}

