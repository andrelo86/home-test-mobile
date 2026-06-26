package com.hometestmobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.hometestmobile.base.BasePage;

public class RegistrationSuccessPage extends BasePage {

    @AndroidFindBy(accessibility = "title")
    private WebElement successTitle;

    public RegistrationSuccessPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isSuccessDisplayed() {
        return successTitle.isDisplayed();
    }
}
