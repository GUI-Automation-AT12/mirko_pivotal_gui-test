package org.fundacionjala.core.selenium.webDrivers;

import org.openqa.selenium.WebDriver;

public interface IBrowser {

    /**
     * Initializes a new webDriver for browser.
     * @return WebDriver
     */
    WebDriver initDriver();
}
