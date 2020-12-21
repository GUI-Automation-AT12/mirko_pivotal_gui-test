package org.fundacionjala.core.config;

import org.fundacionjala.core.throwables.EnvironmentReadingException;

public final class EnvironmentProperties {

    private static final String PROPERTIES_FILE_PATH = "gradle.properties";
    private static EnvironmentProperties singleInstance;
    private static PropertiesFileReader propertiesFileReader;

    /**
     * If singleInstance was not instanced before it create a new one, otherwise return the created.
     * @return singleInstance
     */
    public static EnvironmentProperties getInstance() {
        if (singleInstance == null) {
            try {
                singleInstance = new EnvironmentProperties();
            } catch (EnvironmentReadingException e) {
                e.printStackTrace();
            }
        }
        return singleInstance;
    }

    private EnvironmentProperties() throws EnvironmentReadingException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }

    /**
     * get the cucumberThreadCount from the properties file.
     *
     * @return cucumberThreadCount value.
     */
    public String getCucumberThreadCount() {
        return propertiesFileReader.getProperty("cucumberThreadCount");
    }

    /**
     * get the filterTags from the properties file.
     *
     * @return filterTags value.
     */
    public String filterTags() {
        return propertiesFileReader.getProperty("filterTags");
    }
}
