package org.example.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsPage extends BasePage {

    private static final By WEB_TABLE_MENU_ITEM = By.id("item-3");
    private static final By CHECK_BOX_MENU_ITEM = By.id("item-1");
    private static final By RADIO_BUTTON_MENU_ITEM = By.id("item-2");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void clickWebTablesMenu() {
        WebElement webTablesMenu = driver.findElement(WEB_TABLE_MENU_ITEM);
        webTablesMenu.click();
    }

    public void clickCheckBoxMenu() {
        WebElement checkBoxMenu = driver.findElement(CHECK_BOX_MENU_ITEM);
        checkBoxMenu.click();
    }

    public void clickRadioButtonMenu() {
        WebElement radioButtonMenu = driver.findElement(RADIO_BUTTON_MENU_ITEM);
        radioButtonMenu.click();
    }
}