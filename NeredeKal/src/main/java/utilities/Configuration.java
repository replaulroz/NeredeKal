package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Properties properties;

    static  {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/base.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error: Failed to load properties from src/main/resources/base.properties");
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
