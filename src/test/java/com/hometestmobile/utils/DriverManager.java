package com.hometestmobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.URI;
import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<AndroidDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {}

    public static AndroidDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void initDriver() {
        if (driverThreadLocal.get() == null) {
            driverThreadLocal.set(createDriver());
        }
    }

    public static void quitDriver() {
        AndroidDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    private static AndroidDriver createDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp(new File("app-home-test-app.apk").getAbsolutePath());
        options.setAppPackage("com.learnautomationapp");
        options.setAppActivity("com.learnautomationapp.MainActivity");
        options.setNoReset(false);
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        try {
            return new AndroidDriver(URI.create("http://127.0.0.1:4723").toURL(), options);
        } catch (java.net.MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }
}
