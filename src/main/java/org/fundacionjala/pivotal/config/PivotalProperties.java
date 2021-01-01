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
    public static PivotalProperties getInstance() {
        if (singleInstance == null) {
            try {
                singleInstance = new PivotalProperties();
            } catch (PropertiesReadingException e) {
                e.printStackTrace();
            }
        }
        return singleInstance;
    }

    private PivotalProperties() throws PropertiesReadingException {
        propertiesFileReader = new PropertiesFileReader(PROPERTIES_FILE_PATH);
    }


    /**
     * get the BaseUrl from the properties file.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return propertiesFileReader.getProperty("baseUrl");
    }
}
