package com.hometestmobile.tests;

import com.hometestmobile.base.BaseTest;
import com.hometestmobile.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test(groups = "registration", description = "Scenario 4 (Bonus) - Complete registration flow")
    public void shouldCompleteRegistrationSuccessfully() {
        var result = new LoginPage(driver)
                .goToRegister()
                .enterFirstName("Test")
                .enterLastName("User")
                .enterEmail("testuser@email.com")
                .enterPassword("Test1234")
                .submit()
                .enterAddress("123 Main St")
                .enterCity("Springfield")
                .enterZip("12345")
                .selectBirthDate()
                .acceptTerms()
                .signup();

        Assert.assertTrue(result.isSuccessDisplayed(),
                "Congratulations screen should be visible after successful registration");
    }
}
