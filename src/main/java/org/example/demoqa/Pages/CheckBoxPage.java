package org.example.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BasePage {

    private static final By HOME_TOGGLE = By.className("rct-collapse");
    private static final By DOWNLOADS_TOGGLE = By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button");
    private static final By EXCEL_CHECKBOX = By.xpath("//label[@for='tree-node-excelFile']");
    private static final By RESULT_TEXT = By.className("text-success");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void toggleHome() {
        WebElement homeToggle = driver.findElement(HOME_TOGGLE);
        homeToggle.click();
    }

    public void toggleDownloads() {
        WebElement downloadsToggle = driver.findElement(DOWNLOADS_TOGGLE);
        downloadsToggle.click();
    }

    public void selectExcelFile() {
        WebElement excelCheckbox = driver.findElement(EXCEL_CHECKBOX);
        excelCheckbox.click();
    }

    public String getResultText() {
        WebElement resultText = driver.findElement(RESULT_TEXT);
        return resultText.getText();
    }
}