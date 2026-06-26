package com.hometestmobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import com.hometestmobile.base.BasePage;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "emailField")
    private WebElement emailField;

    @AndroidFindBy(accessibility = "passwordField")
    private WebElement passwordField;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginButton;

    @AndroidFindBy(accessibility = "registerButton")
    private WebElement registerButton;

    @AndroidFindBy(accessibility = "forgotPasswordButton")
    private WebElement forgotPasswordButton;

    @AndroidFindBy(id = "com.learnautomationapp:id/alertTitle")
    private WebElement errorTitle;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement errorOkButton;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public LoginPage enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public GalleryPage submitLogin() {
        loginButton.click();
        return new GalleryPage(driver);
    }

    public LoginPage submitLoginExpectingError() {
        loginButton.click();
        return this;
    }

    public boolean isErrorDisplayed() {
        return errorTitle.isDisplayed();
    }

    public String getErrorMessage() {
        return errorTitle.getText();
    }

    public LoginPage dismissError() {
        errorOkButton.click();
        return this;
    }

    public RegisterPage goToRegister() {
        registerButton.click();
        return new RegisterPage(driver);
    }
}