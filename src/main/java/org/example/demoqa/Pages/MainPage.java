package org.example.demoqa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickElementsCard() {
        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elementsCard);
        elementsCard.click();
    }
}