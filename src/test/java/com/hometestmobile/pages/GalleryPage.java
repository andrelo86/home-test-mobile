package com.hometestmobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.hometestmobile.base.BasePage;

public class GalleryPage extends BasePage {

    @AndroidFindBy(accessibility = "itemsList")
    private WebElement galleryFeed;

    public GalleryPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isGalleryDisplayed() {
        return galleryFeed.isDisplayed();
    }

    public WebElement scrollToItem(String itemName) {
        return driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"" + itemName + "\"))"
        ));
    }
}
