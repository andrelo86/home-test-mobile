# home-test-mobile

Android UI test automation using Appium 2 and Java 21 (TestNG).

---

## Prerequisites

Make sure you have the following installed before running anything:

- **Java 21** — [Temurin JDK](https://adoptium.net/)
- **Maven 3.x** — [maven.apache.org](https://maven.apache.org/download.cgi)
- **Node.js 18+** — [nodejs.org](https://nodejs.org/)
- **Android Studio** — needed for the emulator and SDK tools

After installing Android Studio, open the SDK Manager (`Tools → SDK Manager`) and make sure these are installed:
- Android SDK Platform 34 (Android 14)
- Android Emulator
- Android SDK Platform-Tools

Then add `ANDROID_HOME` to your environment variables pointing to the SDK folder (usually `C:\Users\<you>\AppData\Local\Android\Sdk`), and add `%ANDROID_HOME%\platform-tools` to your `PATH`.

---

## Install Appium

```
npm install -g appium
appium driver install uiautomator2
```

---

## Create an emulator

Open Android Studio → Device Manager → Create Device. Pick **Pixel 4**, then select **API 34** as the system image. Finish the setup and the device will appear in the list.

---

## Get the APK

The APK is not included in the repository. Download `app-home-test-app.apk` from the [release page](https://github.com/automationapptest/home-test-mobile/releases/tag/v1.0.0) and place it in the project root:

```
home-test-mobile/
└── app-home-test-app.apk   ← here
```

The path is already configured in `DriverManager.java` to look for the file at that location. If you place it somewhere else, update this line accordingly:

```java
options.setApp(new File("app-home-test-app.apk").getAbsolutePath());
```

---

## Running the tests

**1.** Start the emulator from Android Studio — hit the Play button next to the Pixel 4 in Device Manager.

**2.** Once the emulator is booted, open a terminal and start Appium:

```
appium
```

**3.** In a separate terminal, from the project root:

```
mvn test
```

To run a single test class:

```
mvn test -Dtest=LoginTest
```

To run tests by group:

```
mvn test -Dgroups=auth
```

---

## Test credentials

| Email             | Password |
|-------------------|----------|
| johndoe@email.com | 123      |
