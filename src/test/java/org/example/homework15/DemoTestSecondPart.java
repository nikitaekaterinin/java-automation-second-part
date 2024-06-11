package org.example.homework15;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class DemoTestSecondPart {
    WebDriver driver;
    JavascriptExecutor js;
    private static final By ALERTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']");
    private static final By ALERTS_MENU = By.xpath("//span[@class='text' and text()='Alerts']");
    private static final By TIMER_ALERT_BUTTON = By.id("timerAlertButton");
    private static final String POPUP_MESSAGE = "This alert appeared after 5 seconds";
    private static final By CONFIRM_BUTTON = By.id("confirmButton");
    private static final By RESULT_TEXT = By.className("text-success");
    private static final String RESULT_MESSAGE = "You selected Cancel";
    private static final String POPUP_INPUT = "TestValue";
    private static final By PROMPT_BUTTON = By.id("promtButton");
    private static final By RESULT_PROMPT = By.id("promptResult");

    @Test
    @DisplayName("Сheck that pop-up appears in 5 seconds")
    void checkPopUpAppearTime() {
        Instant startTime = Instant.now();

        WebElement timerAlertButton = driver.findElement(TIMER_ALERT_BUTTON);
        js.executeScript("arguments[0].click();", timerAlertButton);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(alertIsPresent());

        Instant endTime = Instant.now();
        long durationSeconds = Duration.between(startTime, endTime).getSeconds();
        assertEquals(5, durationSeconds);

        Alert alert = driver.switchTo().alert();
        String popupText = alert.getText();
        assertTrue(popupText.contains(POPUP_MESSAGE));
    }

    @Test
    @DisplayName("Check popup closing")
    void checkPopupClosing() {
        js.executeScript(
                "window.alert = function() {}; " +
                        "window.confirm = function() { return false; }; "
        );

        WebElement button = driver.findElement(CONFIRM_BUTTON);
        button.click();

        WebElement resultText = driver.findElement(RESULT_TEXT);
        assertTrue(resultText.getText().contains(RESULT_MESSAGE));
    }

    @Test
    @DisplayName("Check entering text on popup")
    void checkEnterTextOnPopup() {
        js.executeScript(
                "window.alert = function() {}; " +
                        "window.confirm = function() { return true; }; " +
                        "window.prompt = function() { var userInput = '" + POPUP_INPUT + "'; return userInput; };"
        );

        WebElement buttonPrompt = driver.findElement(PROMPT_BUTTON);
        js.executeScript("arguments[0].click();", buttonPrompt);

        WebElement resultText = driver.findElement(RESULT_PROMPT);
        System.out.println(resultText.getText());
        assertTrue(resultText.getText().contains("You entered " + POPUP_INPUT));
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement alertsCard = driver.findElement(ALERTS_CARD);
        js.executeScript("arguments[0].scrollIntoView(true);", alertsCard);
        js.executeScript("arguments[0].click();", alertsCard);

        WebElement alertsMenu = driver.findElement(ALERTS_MENU);
        js.executeScript("arguments[0].click();", alertsMenu);
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}