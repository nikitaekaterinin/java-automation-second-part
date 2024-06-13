package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}