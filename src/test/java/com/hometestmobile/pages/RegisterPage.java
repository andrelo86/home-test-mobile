package com.hometestmobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.hometestmobile.base.BasePage;

public class RegisterPage extends BasePage {

    @AndroidFindBy(accessibility = "firstNameField")
    private WebElement firstNameField;

    @AndroidFindBy(accessibility = "lastNameField")
    private WebElement lastNameField;

    @AndroidFindBy(accessibility = "emailField")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "passwordField")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Continue")
    private WebElement submitButton;

    public RegisterPage(AndroidDriver driver) {
        super(driver);
    }

    public RegisterPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public RegisterPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public RegisterPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public RegisterPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public PersonalInfoPage submit() {
        submitButton.click();
        return new PersonalInfoPage(driver);
    }
}
