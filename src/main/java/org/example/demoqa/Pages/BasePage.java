package org.example.demoqa.Pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}