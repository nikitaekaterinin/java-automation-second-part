package org.example.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BasePage {

    private static final By RAW_DELETE_1_BUTTON = By.id("delete-record-1");
    private static final By RAW_DELETE_2_BUTTON = By.id("delete-record-2");
    private static final By RAW_DELETE_3_BUTTON = By.id("delete-record-3");
    private static final By NO_TABLE_DATA_ITEM = By.className("rt-noData");

    public WebTablesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void deleteFirstRow() {
        WebElement deleteButton = driver.findElement(RAW_DELETE_1_BUTTON);
        deleteButton.click();
    }

    public void deleteSecondRow() {
        WebElement deleteButton = driver.findElement(RAW_DELETE_2_BUTTON);
        deleteButton.click();
    }

    public void deleteThirdRow() {
        WebElement deleteButton = driver.findElement(RAW_DELETE_3_BUTTON);
        deleteButton.click();
    }

    public boolean isNoTableDataBannerDisplayed() {
        WebElement noTableDataBanner = driver.findElement(NO_TABLE_DATA_ITEM);
        return noTableDataBanner.isDisplayed() && "No rows found".equals(noTableDataBanner.getText());
    }
}