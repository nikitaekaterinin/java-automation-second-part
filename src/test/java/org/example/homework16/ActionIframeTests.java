package org.example.homework16;

import org.example.ConfigFileReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ActionIframeTests {
    WebDriver driver;
    JavascriptExecutor js;
    private static final By INTERACTIONS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Interactions']");
    private static final By DROP_MENU = By.xpath("//span[@class='text' and text()='Droppable']");
    private static final By DRAGGABLE = By.id("draggable");
    private static final By DROPPABLE = By.id("droppable");
    private static final By FRAMES_CARD = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
    private static final By FRAMES_MENU = By.xpath("//span[@class='text' and text()='Nested Frames']");
    private static final By PARENT_FRAME = By.id("frame1");
    private static final By CHILD_FRAME = By.xpath("//body/iframe");
    private static final By CHILD_FRAME_TEXT = By.xpath("//body/p");

    @Test
    @DisplayName("Сheck element colour changing after drag&drop")
    void checkColourChange() {
        WebElement interactionsCard = driver.findElement(INTERACTIONS_CARD);
        js.executeScript("arguments[0].scrollIntoView(true);", interactionsCard);
        interactionsCard.click();

        WebElement dropMenuItem = driver.findElement(DROP_MENU);
        dropMenuItem.click();

        WebElement draggable = driver.findElement(DRAGGABLE);
        js.executeScript("arguments[0].scrollIntoView(true);", draggable);

        WebElement droppable = driver.findElement(DROPPABLE);

        String initialColor = droppable.getCssValue("background-color");

        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeToBe(droppable, "background-color", "rgba(70, 130, 180, 1)"));

        String newColor = droppable.getCssValue("background-color");

        assertNotEquals(initialColor, newColor);
    }

    @Test
    @DisplayName("Check text in parent and child frames")
    void checkFrames() {
        WebElement framesCard = driver.findElement(FRAMES_CARD);
        js.executeScript("arguments[0].scrollIntoView(true);", framesCard);
        framesCard.click();

        WebElement framesMenu = driver.findElement(FRAMES_MENU);
        framesMenu.click();

        WebElement parentFrame = driver.findElement(PARENT_FRAME);
        js.executeScript("arguments[0].scrollIntoView(true);", parentFrame);
        driver.switchTo().frame(parentFrame);

        String parentFrameText = driver.findElement(By.xpath("//body")).getText();

        assertEquals("Parent frame", parentFrameText);

        WebElement childFrame = driver.findElement(CHILD_FRAME);
        driver.switchTo().frame(childFrame);

        WebElement childFrameText = driver.findElement(CHILD_FRAME_TEXT);

        assertEquals("Child Iframe", childFrameText.getText());
    }

    @BeforeEach
    void setup() {
        var configs = new ConfigFileReader();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.get(configs.getBaseUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}