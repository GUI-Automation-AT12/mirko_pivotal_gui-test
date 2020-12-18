package org.fundacionjala.core.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class Environment {

    private static final Logger LOGGER = LogManager.getLogger(Environment.class);
    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static Environment singleInstance;
    private Properties property;
    private FileReader reader;

    /**
     * If singleInstance was not instanced before it create a new one, otherwise return the created.
     * @return singleInstance
     */
    public static Environment getInstance() {
        if (singleInstance == null) {
            singleInstance = new Environment(PROPERTIES_FILE_PATH);
        }
        return singleInstance;
    }

    /**
     * Initializes an instance of properties files.
     * @param propertiesPath
     */
    private Environment(final String propertiesPath) {
        try {
            reader = new FileReader(propertiesPath);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error("Error when reading file");
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error("Error getting properties");
            LOGGER.error(e.getMessage());
        } finally {
            closeReader();
        }
    }

    /**
     * get the BaseUrl from the properties file.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return getEnvProperty("baseUrl");
    }

    /**
     * get the user's email from the properties file.
     *
     * @return userEmail value.
     */
    public String getUserEmail() {
        return getEnvProperty("userEmail");
    }

    /**
     * get the user's password from the properties file.
     *
     * @return userPassword value.
     */
    public String getUserPassword() {
        return getEnvProperty("userPassword");
    }

    /**
     * get the webdriver.gecko.driver from the properties file.
     *
     * @return webdriver.gecko.driver value.
     */
    public String getWebdriverGeckoDriver() {
        return getEnvProperty("webdriver.gecko.driver");
    }

    /**
     * get the implicitWaitingSeconds from the properties file.
     *
     * @return implicitWaitingSeconds value.
     */
    public int getImplicitWaitingSeconds() {
        return Integer.parseInt(getEnvProperty("implicitWaitingSeconds"));
    }

    /**
     * get the sleepingMillis from the properties file.
     *
     * @return sleepingMillis value.
     */
    public int getSleepingMillis() {
        return Integer.parseInt(getEnvProperty("sleepingMillis"));
    }

    /**
     * get the explicitWaitingSeconds from the properties file.
     *
     * @return explicitWaitingSeconds value.
     */
    public int getExplicitWaitingSeconds() {
        return Integer.parseInt(getEnvProperty("explicitWaitingSeconds"));
    }

    /**
     * get the cucumberThreadCount from the properties file.
     *
     * @return cucumberThreadCount value.
     */
    public String getCucumberThreadCount() {
        return getEnvProperty("cucumberThreadCount");
    }

    /**
     * Gets environment property.
     * @param env
     * @return property value.
     */
    private String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Cannot close File Reader.");
        }
    }
}
