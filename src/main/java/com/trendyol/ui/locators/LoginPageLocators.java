package com.trendyol.ui.locators;

import org.openqa.selenium.By;

public interface LoginPageLocators {

    // Login page

    By LOGIN_PAGE_BUTTON = By.cssSelector(".login-button");//DONE
    By LOGIN_EMAIL = By.cssSelector("input#login-email");//DONE
    By LOGIN_PASSWORD = By.cssSelector("input#login-password-input");//DONE
    By LOGIN_BUTTON = By.cssSelector("button.submit");//DONE
    By INVALID_EMAIL_ERROR_MESSAGE = By.cssSelector("div#error-box-wrapper");//DONE
    By INVALID_PASSWORD_ERROR_MESSAGE = By.cssSelector("div#error-box-wrapper");//DONE
    By EMPTY_EMAIL_ERROR_MESSAGE = By.cssSelector("div#error-box-wrapper");//DONE
    By EMPTY_PASSWORD_ERROR_MESSAGE = By.cssSelector("div#error-box-wrapper");//DONE
    By INVALID_CREDENTIALS_ERROR_MESSAGE = By.cssSelector("div#error-box-wrapper");
    By SIGN_UP_PAGE_BUTTON = By.cssSelector(".signup-button");
    By REGISTER_EMAIL = By.id("register-email");
    By REGISTER_PASSWORD = By.id("register-password-input");
    By GENDER_FEMALE = By.cssSelector(".q-gray.female");
    By GENDER_MALE = By.cssSelector(".q-gray.female");
    By REGISTER_PERSONAL_DATA_CHECKBOX = By.cssSelector(".personal-checkbox .ty-checkbox.ty-checkbox");
    By REGISTER_MARKETING_CHECKBOX = By.cssSelector(".marketing-checkbox .ty-checkbox.ty-checkbox");
    By RECAPTCHA_CHECKBOX = By.cssSelector(".recaptcha-checkbox-border");

    By REGISTER_BUTTON = By.cssSelector("button.submit");//DONE

    By WEAK_PASSWORD_ERROR_MESSAGE = By.cssSelector("span.weak");//Zayıf Şifre
    By EMPTY_FIELDS_ERROR_MESSAGE = By.cssSelector("div#error-box-wrapper");//E-posta ve şifrenizi giriniz.//Şifreniz 7 ile 64 karakter arasında olmalıdır.//Bu e-posta adresi kullanılamaz. Lütfen başka bir e-posta adresi deneyiniz.
    By CAPTCHA_ERROR_MESSAGE = By.id("captcha-box-error"); //Üyelik işlemini güvenli hale getirmek için "Ben robot değilim" alanına tıklayınız.












}

