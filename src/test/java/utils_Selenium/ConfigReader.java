package utils_Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader_TDD {
    public static String readProperty(String key) {
        File file = new File("configuration.properties");
        Properties properties = new Properties();
        //this properties object will read the property file
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }
}
