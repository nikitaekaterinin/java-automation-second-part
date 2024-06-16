package org.example.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonsPage extends BasePage {

    private static final By YES_BUTTON = By.id("yesRadio");
    private static final By IMPRESSIVE_BUTTON = By.id("impressiveRadio");
    private static final By RESULT_TEXT = By.className("text-success");

    public RadioButtonsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectYes() {
        WebElement yesOption = driver.findElement(YES_BUTTON);
        Actions actions = new Actions(driver);
        actions.moveToElement(yesOption).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesOption);
    }

    public void selectImpressive() {
        WebElement impressiveOption = driver.findElement(IMPRESSIVE_BUTTON);
        Actions actions = new Actions(driver);
        actions.moveToElement(impressiveOption).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", impressiveOption);
    }

    public String getResultText() {
        WebElement resultText = driver.findElement(RESULT_TEXT);
        return resultText.getText();
    }
}