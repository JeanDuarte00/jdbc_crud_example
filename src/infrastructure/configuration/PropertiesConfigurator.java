package infrastructure.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfigurator {
    private static Properties properties;
    private final static String filePath = "resources/app.properties";
    public static String getProperty(String propertyName) {
        if(properties == null) {
            try (InputStream input = new FileInputStream(filePath)) {

                properties = new Properties();
                properties.load(input);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return properties.getProperty(propertyName);
    }

}
