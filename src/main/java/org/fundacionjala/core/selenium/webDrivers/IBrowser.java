package org.fundacionjala.core.selenium.webDrivers;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public interface IBrowser {

    /**
     * Initializes a new webDriver for browser.
     * @return WebDriver
     */
    WebDriver initDriver();

    /**
     * Get a Map that contains the Properties for the Driver Browser.
     * @return driverProps
     */
    Map getDriverProps();
}
