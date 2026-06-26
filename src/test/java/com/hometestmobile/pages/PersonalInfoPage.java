package com.hometestmobile.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import com.hometestmobile.base.BasePage;

public class PersonalInfoPage extends BasePage {

    @AndroidFindBy(accessibility = "addressInput")
    private WebElement addressField;

    @AndroidFindBy(accessibility = "cityInput")
    private WebElement cityField;

    @AndroidFindBy(accessibility = "zipInput")
    private WebElement zipField;

    @AndroidFindBy(accessibility = "openDatePicker")
    private WebElement birthDatePicker;

    @AndroidFindBy(accessibility = "termConditions")
    private WebElement termsCheckbox;

    @AndroidFindBy(accessibility = "Signup!")
    private WebElement signupButton;

    public PersonalInfoPage(AndroidDriver driver) {
        super(driver);
    }

    public PersonalInfoPage enterAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public PersonalInfoPage enterCity(String city) {
        cityField.sendKeys(city);
        return this;
    }

    public PersonalInfoPage enterZip(String zip) {
        zipField.sendKeys(zip);
        return this;
    }

    public PersonalInfoPage selectBirthDate() {
        birthDatePicker.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator("new UiSelector().text(\"Confirm\")")))
            .click();
        return this;
    }

    public PersonalInfoPage acceptTerms() {
        termsCheckbox.click();
        return this;
    }

    public RegistrationSuccessPage signup() {
        signupButton.click();
        return new RegistrationSuccessPage(driver);
    }
}
