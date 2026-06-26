package com.hometestmobile.tests;

import com.hometestmobile.base.BaseTest;
import com.hometestmobile.pages.GalleryPage;
import com.hometestmobile.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = "auth", description = "Scenario 1 - Happy path login with valid credentials")
    public void shouldLoginSuccessfully() {
        GalleryPage gallery = new LoginPage(driver)
                .enterEmail("johndoe@email.com")
                .enterPassword("123")
                .submitLogin();

        Assert.assertTrue(gallery.isGalleryDisplayed(),
                "Gallery feed should be visible after successful login");
    }
}
