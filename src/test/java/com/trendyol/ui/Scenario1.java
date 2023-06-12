package com.trendyol.ui;


import com.trendyol.ui.Pages.*;



import org.testng.annotations.Test;

import java.io.IOException;

public class Scenario1 extends BaseUITest {
    private String email = "trendyolotomasyontest@test.com";
    private String password = "trendyoltest123";
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void Succesfulllogin() throws IOException, InterruptedException {
        loginPage.Succesfulllogin(email, password);
    }
    @Test
    public void failedLogin_InvalidEmail() throws IOException, InterruptedException {
        String invalidEmail = "invalid_email";
        loginPage.failedLogin_InvalidEmail(invalidEmail, password);
    }

    @Test
    public void failedLogin_InvalidPassword() throws IOException, InterruptedException {
        String invalidPassword = "invalid_password";

        loginPage.failedLogin_InvalidPassword(email, invalidPassword);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedLogin_EmptyPassword() throws IOException, InterruptedException {
        loginPage.failedLogin_EmptyFields(email, "");
        // Assert error message or validate the expected behavior
    }
    @Test
    public void failedLogin_EmptyEmail() throws IOException, InterruptedException {
        loginPage.failedLogin_EmptyFields("", password);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedLogin_InvalidCredentials() throws IOException, InterruptedException {
        String wrongPassword = "wrong_password";

        loginPage.failedLogin_InvalidCredentials(email, wrongPassword);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedLogin_ReversedFields() throws IOException, InterruptedException {
        loginPage.failedLogin_ReversedFields(email,password);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void successfulRegistration() throws IOException, InterruptedException {


        loginPage.successfulRegistration(email, password);
        // Assert successful registration or validate the expected behavior
    }

    @Test
    public void failedRegistration_InvalidEmail() throws IOException, InterruptedException {
        String invalidEmail = "invalid_email";

        loginPage.failedRegistration_InvalidEmail(invalidEmail, password);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedRegistration_WeakPassword() throws IOException, InterruptedException {
        String weakPassword = "weak";

        loginPage.failedRegistration_WeakPassword(email, weakPassword);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void registerScenario_EmptyCaptchaVerification() throws IOException, InterruptedException {
        loginPage.failedRegistration_EmptyFields(email, password);
        // Assert error message or validate the expected behavior
    }
    @Test
    public void failedRegistration_EmptyFields() throws IOException, InterruptedException {
        loginPage.failedRegistration_EmptyFields("", "");
        // Assert error message or validate the expected behavior
    }


}
