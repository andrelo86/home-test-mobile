package com.hometestmobile.tests;

import com.hometestmobile.base.BaseTest;
import com.hometestmobile.pages.GalleryPage;
import com.hometestmobile.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest {

    @Test(groups = "catalog", description = "Scenario 3 - Scroll gallery and locate 'Twilight Glow'")
    public void shouldFindTwilightGlowInCatalog() {
        GalleryPage gallery = new LoginPage(driver)
                .enterEmail("johndoe@email.com")
                .enterPassword("123")
                .submitLogin();

        WebElement item = gallery.scrollToItem("Twilight Glow");

        Assert.assertTrue(item.isDisplayed(),
                "'Twilight Glow' should be visible in the gallery after scrolling");
    }
}
