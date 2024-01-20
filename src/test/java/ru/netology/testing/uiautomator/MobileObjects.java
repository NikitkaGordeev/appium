package ru.netology.testing.uiautomator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MobileObjects {
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/userInput")
    MobileElement userInput;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonChange")
    MobileElement buttonChange;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/textToBeChanged")
    MobileElement textToBeChanged;
    @AndroidFindBy(id = "ru.netology.testing.uiautomator:id/buttonActivity")
    MobileElement buttonActivity;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"ru.netology.testing.uiautomator:id/text\"]")
    MobileElement textActivity;
    public AndroidDriver driver;

    public MobileObjects(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3000)),this);
    }

}