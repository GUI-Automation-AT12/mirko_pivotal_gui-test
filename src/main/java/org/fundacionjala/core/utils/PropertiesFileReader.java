package org.fundacionjala.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.core.config.TestExecutionProperties;
import org.fundacionjala.core.throwables.PropertiesReadingException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    private static final Logger LOGGER = LogManager.getLogger(TestExecutionProperties.class);
    private final Properties property;
    private final FileReader reader;

    /**
     * Initializes an instance of properties files.
     * @param propertiesPath path of the properties fiel
     */
    public PropertiesFileReader(final String propertiesPath) throws PropertiesReadingException {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error("Error when reading file");
            LOGGER.error(e.getMessage());
            throw new PropertiesReadingException("Error when reading properties file");
        } catch (IOException e) {
            LOGGER.error("Error getting properties");
            LOGGER.error(e.getMessage());
            throw new PropertiesReadingException("Error getting properties");
        } finally {
            closeReader();
        }
    }

    /**
     * Gets environment property.
     * @param propertyName name of the property
     * @return property value.
     */
    public String getProperty(final String propertyName) {
        String localProperty = System.getProperty(propertyName);
        if (localProperty == null) {
            return this.property.getProperty(propertyName);
        }
        return localProperty;
    }

    private void closeReader() throws PropertiesReadingException {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close file Reader.");
            throw new PropertiesReadingException("Cannot close File Reader.");
        }
    }
}
