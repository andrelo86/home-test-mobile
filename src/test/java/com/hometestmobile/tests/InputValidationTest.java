package com.hometestmobile.tests;

import com.hometestmobile.base.BaseTest;
import com.hometestmobile.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputValidationTest extends BaseTest {

    @Test(groups = "auth", description = "Scenario 2 - Empty fields should show validation error")
    public void shouldShowErrorOnEmptyFields() {
        LoginPage loginPage = new LoginPage(driver)
                .enterEmail("")
                .enterPassword("")
                .submitLoginExpectingError();

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error dialog should be visible when submitting empty fields");
        Assert.assertEquals(loginPage.getErrorMessage(), "Please complete both fields",
                "Error message should indicate both fields are required");
    }

    @Test(groups = "auth", description = "Scenario 2 - Invalid credentials should block access")
    public void shouldShowErrorOnInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver)
                .enterEmail("invalid@email.com")
                .enterPassword("wrongpassword")
                .submitLoginExpectingError();

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error dialog should be visible when submitting invalid credentials");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user or password",
                "Error message should indicate credentials are invalid");
    }
}
