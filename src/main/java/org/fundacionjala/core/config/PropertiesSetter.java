package org.fundacionjala.core.config;

import org.fundacionjala.core.selenium.WebDriverManager;

public final class PropertiesSetter {

    private PropertiesSetter() {
    }

    /**
     * Sets dataproviderthreadcount property.
     * @param threadCount
     */
    public static void setDataProviderThreadCountProp(final String threadCount) {
        System.setProperty("dataproviderthreadcount", threadCount);
    }

    /**
     * Sets the Test Browser to run test Scenarios.
     * @param browserName
     */
    public static void setTestBrowser(final String browserName) {
        WebDriverManager.setBrowserName(browserName);
    }
}
