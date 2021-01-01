package org.fundacionjala.core.config;

import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.core.utils.PropertiesFileReader;

public final class TestExecutionProperties {

    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static TestExecutionProperties singleInstance;
    private static PropertiesFileReader propertiesFileReader;

    /**
     * If singleInstance was not instanced before it creates a new one, otherwise returns the created.
     * @return singleInstance
     */
    public static TestExecutionProperties getInstance() {
        if (singleInstance == null) {
            try {
                singleInstance = new TestExecutionProperties();
            } catch (PropertiesReadingException e) {
                e.printStackTrace();
            }
        }
        return singleInstance;
    }

    private TestExecutionProperties() throws PropertiesReadingException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }

    /**
     * Gets the cucumberThreadCount from the properties file.
     * @return cucumberThreadCount value
     */
    public String getCucumberThreadCount() {
        return propertiesFileReader.getProperty("cucumberThreadCount");
    }

    /**
     * Gets the filterTags from the properties file.
     * @return filterTags value
     */
    public String getFilterTags() {
        return propertiesFileReader.getProperty("filterTags");
    }

    /**
     * Gets the testBrowser from the properties file.
     * @return testBrowser value
     */
    public String getTestBrowser() {
        return propertiesFileReader.getProperty("testBrowser");
    }
}
