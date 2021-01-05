package org.fundacionjala.pivotal.config;

import org.fundacionjala.core.utils.PropertiesFileReader;
import org.fundacionjala.core.throwables.PropertiesReadingException;

public final class PivotalProperties {
    private static final String PROPERTIES_FILE_PATH = "pivotal.properties";
    private static PivotalProperties singleInstance;
    private static PropertiesFileReader propertiesFileReader;

    /**
     * If singleInstance was not instanced before it create a new one, otherwise return the created.
     * @return singleInstance
     */
    public static PivotalProperties getInstance() throws PropertiesReadingException {
        if (singleInstance == null) {
            singleInstance = new PivotalProperties();
        }
        return singleInstance;
    }

    private PivotalProperties() throws PropertiesReadingException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }


    /**
     * Gets the BaseUrl from the properties file.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return propertiesFileReader.getProperty("baseUrl");
    }

    /**
     * Gets the BaseApiUrl from the properties file.
     *
     * @return base API Url
     */
    public String getBaseApiUrl() {
        return propertiesFileReader.getProperty("baseApiUrl");
    }
}
