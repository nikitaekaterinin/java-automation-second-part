package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ConfigFileReader {
    private static final String PROPERTY_FILE_PATH = "src/main/resources/app.properties";

    private Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getProperty(String propertyKey) {
        var propertyValue = properties.getProperty(propertyKey);
        if (propertyValue != null) {
            return propertyValue;
        }
        throw new RuntimeException(propertyKey + " is not found");
    }

    public String getBaseUrl() {
        return getProperty("base.url");
    }

    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}