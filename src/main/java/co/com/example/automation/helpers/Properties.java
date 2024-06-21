package co.com.example.automation.helpers;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
    static String PATH_PROPERTIES_FILE = "src/main/resources/properties/utilities.properties";

    /**
     * Retrieves the value of a property from the properties file.
     * <p>
     * This method reads the properties from the file and returns the value of the property
     * specified by the given key. If the key is not found in the properties file, it returns null.
     *
     * @param key The key of the property to retrieve.
     * @return The value of the property, or null if the key is not found.
     */

    public static String getProperty(String key) {
        return readPropertiesFile().getProperty(key);
    }

    /**
     * Reads the properties from a file and returns them as a Properties object.
     * <p>
     * This method reads the properties from the file specified by the PATH_PROPERTIES_FILE constant
     * and returns them as a Properties object. If an IOException occurs during the reading process,
     * it is wrapped in a RuntimeException and re-thrown.
     *
     * @return A Properties object containing the properties read from the file.
     */
    public static java.util.Properties readPropertiesFile() {
        java.util.Properties properties = new java.util.Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_PROPERTIES_FILE)) {
            properties.load(fileInputStream);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
