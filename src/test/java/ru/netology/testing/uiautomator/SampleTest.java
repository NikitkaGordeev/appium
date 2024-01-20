package ru.netology.testing.uiautomator;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SampleTest {

    private AndroidDriver driver;
    private MobileObjects mobileObjects;
    private String textToSet = "Netology";
    private String nullText = "";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        desiredCapabilities.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void testNullText() {
        mobileObjects.textToBeChanged.isDisplayed();
        String initialText = mobileObjects.textToBeChanged.getText();

        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(nullText);

        mobileObjects.buttonChange.isDisplayed();
        mobileObjects.buttonChange.click();

        mobileObjects.textToBeChanged.isDisplayed();
        Assertions.assertEquals(mobileObjects.textToBeChanged.getText(), initialText);
    }

    @Test
    public void testTextActivity() {
        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(textToSet);

        mobileObjects.buttonActivity.isDisplayed();
        mobileObjects.buttonActivity.click();

        mobileObjects.textActivity.isDisplayed();
        Assertions.assertEquals(mobileObjects.textActivity.getText(), "Netology");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}