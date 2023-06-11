package com.trendyol.ui;


import com.trendyol.ui.Pages.*;



import org.testng.annotations.Test;

import java.io.IOException;

public class LoginAndSignUpScenarios extends BaseUITest {
    private String username = "trendyolotomasyontest@test.com";
    private String password = "trendyoltest123";
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void Succesfulllogin() throws IOException, InterruptedException {
        loginPage.Succesfulllogin(username, password);
    }
    @Test
    public void failedLogin_InvalidEmail() throws IOException, InterruptedException {
        String invalidEmail = "invalid_email";
        loginPage.failedLogin_InvalidEmail(invalidEmail, "password123");
    }

    @Test
    public void failedLogin_InvalidPassword() throws IOException, InterruptedException {
        String invalidPassword = "invalid_password";

        loginPage.failedLogin_InvalidPassword("test@example.com", invalidPassword);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedLogin_EmptyPassword() throws IOException, InterruptedException {
        loginPage.failedLogin_EmptyFields(username, "");
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

        loginPage.failedLogin_InvalidCredentials("test@example.com", wrongPassword);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedLogin_ReversedFields() throws IOException, InterruptedException {
        loginPage.failedLogin_ReversedFields("password123", "test@example.com");
        // Assert error message or validate the expected behavior
    }

    @Test
    public void successfulRegistration() throws IOException, InterruptedException {
        String email = "test@example.com";
        String password = "password123";
        String name = "John";
        String surname = "Doe";

        loginPage.successfulRegistration(email, password, name, surname);
        // Assert successful registration or validate the expected behavior
    }

    @Test
    public void failedRegistration_InvalidEmail() throws IOException, InterruptedException {
        String invalidEmail = "invalid_email";
        String password = "password123";
        String name = "John";
        String surname = "Doe";

        loginPage.failedRegistration_InvalidEmail(invalidEmail, password, name, surname);
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedRegistration_WeakPassword() throws IOException, InterruptedException {
        String email = "test@example.com";
        String weakPassword = "weak";

        loginPage.failedRegistration_WeakPassword(email, weakPassword, "John", "Doe");
        // Assert error message or validate the expected behavior
    }

    @Test
    public void failedRegistration_EmptyFields() throws IOException, InterruptedException {
        loginPage.failedRegistration_EmptyFields("", "", "", "");
        // Assert error message or validate the expected behavior
    }


}
