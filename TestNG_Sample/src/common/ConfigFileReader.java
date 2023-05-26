package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        InputStream inputStream = null;

        try {
            // Load the configuration file
            inputStream = new FileInputStream("configs/configuration.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
    public String getSecondValue() {
        return properties.getProperty("username");
    }
}
