package org.example.homework14;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTests {
    WebDriver driver;
    private static final By ELEMENTS_CARD = By.xpath("//div[@class='card-body']/h5[text()='Elements']");
    private static final By WEB_TABLE_MENU_ITEM = By.id("item-3");
    private static final By RAW_DELETE_1_BUTTON = By.id("delete-record-1");
    private static final By RAW_DELETE_2_BUTTON = By.id("delete-record-2");
    private static final By RAW_DELETE_3_BUTTON = By.id("delete-record-3");
    private static final By NO_TABLE_DATA_ITEM = By.className("rt-noData");
    private static final By CHECK_BOX_MENU_ITEM = By.id("item-1");
    private static final By HOME_TOGGLE = By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button");
    private static final By DOWNLOADS_TOGGLE = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button");
    private static final By EXCEL_CHECKBOX = By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[2]/span/label/span[1]");
    private static final By RESULT_TEXT = By.className("text-success");
    private static final By LINKS_MENU_ITEM = By.id("item-5");
    private static final By RADIO_BUTTON_MENU_ITEM = By.id("item-2");
    private static final By HOME_LINK = By.id("simpleLink");
    private static final By YES_BUTTON = By.id("yesRadio");
    private static final By IMPRESSIVE_BUTTON = By.id("impressiveRadio");
    private static final By ADD_DATA_BUTTON = By.id("addNewRecordButton");
    private static final By FIRST_NAME_FIELD = By.id("firstName");
    private static final By LAST_NAME_FIELD = By.id("lastName");
    private static final By EMAIL_FIELD = By.id("userEmail");
    private static final By AGE_FIELD = By.id("age");
    private static final By SALARY_FIELD = By.id("salary");
    private static final By DEPARTMENT_FIELD = By.id("department");
    private static final By SUBMIT_BUTTON = By.id("submit");
    private static final String FIRST_NAME = "TestName";
    private static final String LAST_NAME = "Test";
    private static final String EMAIL = "example@test.com";
    private static final String AGE = "25";
    private static final String SALARY = "5000";
    private static final String DEPARTMENT = "QA";
    private static final By NAME_RAW = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[1]");
    private static final By SURNAME_RAW = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[2]");
    private static final By EMAIL_RAW = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[4]");
    private static final By AGE_RAW = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[3]");
    private static final By SALARY_RAW = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[5]");
    private static final By DEPARTAMENT_RAW = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[4]/div/div[6]");

    @Test
    @DisplayName("Checks removing of all data in demo table")
    void checkTableDataRemoving() {
        WebElement webTablesMenu = driver.findElement(WEB_TABLE_MENU_ITEM);
        webTablesMenu.click();

        WebElement deleteButton1 = driver.findElement(RAW_DELETE_1_BUTTON);
        deleteButton1.click();

        WebElement deleteButton2 = driver.findElement(RAW_DELETE_2_BUTTON);
        deleteButton2.click();

        WebElement deleteButton3 = driver.findElement(RAW_DELETE_3_BUTTON);
        deleteButton3.click();

        WebElement noTableDataBanner = driver.findElement(NO_TABLE_DATA_ITEM);

        assertTrue(noTableDataBanner.isDisplayed());
        assertEquals("No rows found", noTableDataBanner.getText());
    }

    @Test
    @DisplayName("Checks adding record to demo table")
    void checkAddTableData() {
        WebElement webTablesMenu = driver.findElement(WEB_TABLE_MENU_ITEM);
        webTablesMenu.click();

        WebElement addDataButton = driver.findElement(ADD_DATA_BUTTON);
        addDataButton.click();

        WebElement firstNameField = driver.findElement(FIRST_NAME_FIELD);
        firstNameField.sendKeys(FIRST_NAME);

        WebElement lastNameField = driver.findElement(LAST_NAME_FIELD);
        lastNameField.sendKeys(LAST_NAME);

        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(EMAIL);

        WebElement ageField = driver.findElement(AGE_FIELD);
        ageField.sendKeys(AGE);

        WebElement salaryField = driver.findElement(SALARY_FIELD);
        salaryField.sendKeys(SALARY);

        WebElement departmentField = driver.findElement(DEPARTMENT_FIELD);
        departmentField.sendKeys(DEPARTMENT);

        WebElement submitButton = driver.findElement(SUBMIT_BUTTON);
        submitButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement firstNameRaw = driver.findElement(NAME_RAW);
        assertTrue(firstNameRaw.getText().contains(FIRST_NAME));

        WebElement lastnameRaw = driver.findElement(SURNAME_RAW);
        assertTrue(lastnameRaw.getText().contains(LAST_NAME));

        WebElement ageRaw = driver.findElement(AGE_RAW);
        assertTrue(ageRaw.getText().contains(AGE));

        WebElement salaryRaw = driver.findElement(SALARY_RAW);
        assertTrue(salaryRaw.getText().contains(SALARY));

        WebElement departamentRaw = driver.findElement(DEPARTAMENT_RAW);
        assertTrue(departamentRaw.getText().contains(DEPARTMENT));
    }

    @Test
    @DisplayName("Checks Excel File selection from drop-down")
    void checkExelFileSelection() {
        WebElement checkBoxMenu = driver.findElement(CHECK_BOX_MENU_ITEM);
        checkBoxMenu.click();

        WebElement homeToggle = driver.findElement(HOME_TOGGLE);
        homeToggle.click();

        WebElement downloadsToggle = driver.findElement(DOWNLOADS_TOGGLE);
        downloadsToggle.click();

        WebElement excelCheckbox = driver.findElement(EXCEL_CHECKBOX);
        excelCheckbox.click();

        WebElement resultText = driver.findElement(RESULT_TEXT);

        assertEquals("excelFile", resultText.getText());
    }

    @Test
    @DisplayName("Checks user redirect by link")
    void checkRedirect() {
        WebElement linksMenu = driver.findElement(LINKS_MENU_ITEM);
        linksMenu.click();

        WebElement redirectLink = driver.findElement(HOME_LINK);
        redirectLink.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlMatches("https://demoqa.com/"));

        String currentUrl = driver.getCurrentUrl();

        assertEquals(currentUrl, "https://demoqa.com/");
    }

    @Test
    @DisplayName("Checks radio buttons interaction")
    void checkRadioButtons() {
        WebElement radioButtonsMenu = driver.findElement(RADIO_BUTTON_MENU_ITEM);
        radioButtonsMenu.click();

        WebElement yesOption = driver.findElement(YES_BUTTON);
        Actions actions = new Actions(driver);
        actions.moveToElement(yesOption).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesOption);

        WebElement resultText = driver.findElement(RESULT_TEXT);
        assertEquals("Yes", resultText.getText());

        WebElement impressiveOption = driver.findElement(IMPRESSIVE_BUTTON);
        actions.moveToElement(impressiveOption).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", impressiveOption);
        assertEquals("Impressive", resultText.getText());
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement elementsCard = driver.findElement(ELEMENTS_CARD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementsCard);
        elementsCard.click();
    }

    @AfterEach
    void cleanup() {
        driver.quit();
    }
}