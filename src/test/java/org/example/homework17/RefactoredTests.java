package org.example.homework17;

import org.example.demoqa.Pages.BasePage;
import org.example.ConfigFileReader;
import org.example.demoqa.Pages.MainPage;
import org.example.demoqa.Pages.ElementsPage;
import org.example.demoqa.Pages.WebTablesPage;
import org.example.demoqa.Pages.CheckBoxPage;
import org.example.demoqa.Pages.RadioButtonsPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefactoredTests {

    private WebDriver driver;
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private WebTablesPage webTablesPage;
    private CheckBoxPage checkBoxPage;
    private RadioButtonsPage radioButtonsPage;
    private ConfigFileReader WebDriverConfig;

    @Test
    @DisplayName("Checks removing of all data in demo table")
    void checkTableDataRemoving() {
        mainPage.clickElementsCard();

        elementsPage.clickWebTablesMenu();

        webTablesPage.deleteFirstRow();
        webTablesPage.deleteSecondRow();
        webTablesPage.deleteThirdRow();

        assertTrue(webTablesPage.isNoTableDataBannerDisplayed());
    }

    @Test
    @DisplayName("Checks Excel File selection from drop-down")
    void checkExcelFileSelection() {
        mainPage.clickElementsCard();
        elementsPage.clickCheckBoxMenu();

        checkBoxPage.toggleHome();
        checkBoxPage.toggleDownloads();
        checkBoxPage.selectExcelFile();

        assertEquals("excelFile", checkBoxPage.getResultText());
    }

    @Test
    @DisplayName("Checks radio buttons interaction")
    void checkRadioButtons() {
        mainPage.clickElementsCard();
        elementsPage.clickRadioButtonMenu();

        radioButtonsPage.selectYes();
        assertEquals("Yes", radioButtonsPage.getResultText());

        radioButtonsPage.selectImpressive();
        assertEquals("Impressive", radioButtonsPage.getResultText());
    }

    @BeforeEach
    void setup() {
        WebDriverConfig = new ConfigFileReader();
        driver = BasePage.getDriver();
        driver.get(WebDriverConfig.getBaseUrl());

        mainPage = new MainPage(driver);
        elementsPage = new ElementsPage(driver);
        webTablesPage = new WebTablesPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
        radioButtonsPage = new RadioButtonsPage(driver);
    }

    @AfterEach
    void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }
}