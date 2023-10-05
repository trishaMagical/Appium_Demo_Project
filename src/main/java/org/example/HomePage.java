package org.example;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final By personalIdButton = By.id("com.madgical.kidstimes:id/menu_item");
    private final By viewMoreButton = By.id("com.madgical.kidstimes:id/idRLViewMoreButton");
    public HomePage(AppiumDriver driver) {
        super(driver);

    }
    public void clickPersonalIdButton() {
        driver.findElement(personalIdButton).click();
    }
    public void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int centerX = size.width / 2;
        System.out.println("Start Y: " + startY);
        System.out.println("End Y: " + endY);
        System.out.println("Center X: " + centerX);

        TouchAction<?> touchAction = new TouchAction<>((PerformsTouchActions) driver);
        touchAction
                .longPress(PointOption.point(centerX, startY))
                .moveTo(PointOption.point(centerX, endY))
                .release()
                .perform();
    }
    public void goBackToHomePage(){
        goBack();
    }
    public void clickOnViewMoreButton(){
        driver.findElement(viewMoreButton).click();
    }
  public  void tapOnElement(){
        tapGesture((WebElement) personalIdButton);
  }
  public void doubleTapOnElement(){
        doubleTapGesture((WebElement) personalIdButton);
  }
  public void longPressOnElement(){
        longPressGesture(((WebElement) personalIdButton));

  }

}



