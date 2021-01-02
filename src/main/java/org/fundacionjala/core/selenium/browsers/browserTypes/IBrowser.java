package org.fundacionjala.core.selenium.browsers.browserTypes;

import org.openqa.selenium.WebDriver;

public interface IBrowser {

    /**
     * Initializes a new webDriver for browser.
     * @return WebDriver
     */
    WebDriver initDriver();
}
