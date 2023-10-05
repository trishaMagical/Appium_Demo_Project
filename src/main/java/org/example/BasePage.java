package org.example;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BasePage {

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;

    }
    public void goBack(){
        driver.navigate().back();
    }
    // tap function
    public void tapGesture(WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();

        // center element
        Point center = getCentreOfElement(location, size);

        // Create  finger
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        org.openqa.selenium.interactions.Sequence sequence = new org.openqa.selenium.interactions.Sequence(finger1, 2)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Create a sequences
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(sequence);

        driver.perform(sequences);
    }
    public Point getCentreOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.width / 2, location.getY() + size.height / 2);
    }
    //double tap
    public void doubleTapGesture(WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();

        // center element
        Point center = getCentreOfElement(location, size);

        // Create  finger
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        //single tap
        org.openqa.selenium.interactions.Sequence sequence = new org.openqa.selenium.interactions.Sequence(finger1, 2)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                //double tap
                .addAction(new Pause(finger1, Duration.ofMillis(200)))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(100)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        // Create a sequences
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(sequence);

        driver.perform(sequences);
    }
    // long press
    public void longPressGesture(WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();

        // center element
        Point center = getCentreOfElement(location, size);

        // Create  finger
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

        org.openqa.selenium.interactions.Sequence sequence = new org.openqa.selenium.interactions.Sequence(finger1, 2)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), center))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(3)))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Create a sequences
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(sequence);

        driver.perform(sequences);
    }
}
