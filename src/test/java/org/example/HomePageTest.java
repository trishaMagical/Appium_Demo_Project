package org.example;


import io.appium.java_client.AppiumDriver;

        import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HomePageTest {

    private AppiumDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.madgical.kidstimes");
        caps.setCapability("appActivity", ".view.HomePage");
        //caps.setCapability(System.getProperty("user.dir") + "/apps/Saarthi_Math_quiz.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

        homePage = new HomePage(driver);
    }

    @Test
    public void testForHomePage() {
        homePage.scrollDown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickPersonalIdButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.goBackToHomePage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnViewMoreButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.tapOnElement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.goBackToHomePage();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.doubleTapOnElement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.longPressOnElement();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
