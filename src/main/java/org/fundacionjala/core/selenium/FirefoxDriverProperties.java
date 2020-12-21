package org.fundacionjala.core.selenium;

import org.fundacionjala.core.config.PropertiesFileReader;
import org.fundacionjala.core.throwables.EnvironmentReadingException;

public final class FirefoxDriverProperties {

    private static final String PROPERTIES_FILE_PATH = "firefox.driver.properties";
    private static FirefoxDriverProperties singleInstance;
    private static PropertiesFileReader propertiesFileReader;

    /**
     * If singleInstance was not instanced before it create a new one, otherwise return the created.
     * @return singleInstance
     */
    public static FirefoxDriverProperties getInstance() {
        if (singleInstance == null) {
            try {
                singleInstance = new FirefoxDriverProperties();
            } catch (EnvironmentReadingException e) {
                e.printStackTrace();
            }
        }
        return singleInstance;
    }

    private FirefoxDriverProperties() throws EnvironmentReadingException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }
    /**
     * get the webdriver.gecko.driver from the properties file.
     *
     * @return webdriver.gecko.driver value.
     */
    public String getWebdriverGeckoDriver() {
        return propertiesFileReader.getProperty("webdriver.gecko.driver");
    }

    /**
     * get the implicitWaitingSeconds from the properties file.
     *
     * @return implicitWaitingSeconds value.
     */
    public int getImplicitWaitingSeconds() {
        return Integer.parseInt(propertiesFileReader.getProperty("implicitWaitingSeconds"));
    }

    /**
     * get the sleepingMillis from the properties file.
     *
     * @return sleepingMillis value.
     */
    public int getSleepingMillis() {
        return Integer.parseInt(propertiesFileReader.getProperty("sleepingMillis"));
    }

    /**
     * get the explicitWaitingSeconds from the properties file.
     *
     * @return explicitWaitingSeconds value.
     */
    public int getExplicitWaitingSeconds() {
        return Integer.parseInt(propertiesFileReader.getProperty("explicitWaitingSeconds"));
    }
}
