package org.fundacionjala.core.selenium;

import org.fundacionjala.core.selenium.webDrivers.ChromeBrowser;
import org.fundacionjala.core.selenium.webDrivers.EdgeBrowser;
import org.fundacionjala.core.selenium.webDrivers.FirefoxBrowser;
import org.fundacionjala.core.selenium.webDrivers.IBrowser;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public final class BrowserFactory {
    /**
     * Constructor for the BrowserFactory class.
     */
    private BrowserFactory() {
    }

    private static Map<String, IBrowser> browsersMap = new HashMap<>();
    static {
        browsersMap.put("chrome", new ChromeBrowser());
        browsersMap.put("firefox", new FirefoxBrowser());
        browsersMap.put("edge", new EdgeBrowser());
    }

    /**
     * Gets a webDriver providing its name.
     * @param browserName
     * @return a webDriver
     */
    public static WebDriver getWebDriver(final String browserName) {
        return browsersMap.get(browserName).initDriver();
    }

    /**
     * Gets a driverProps providing the browser name.
     * @param browserName
     * @return DriverProps of the browser
     */
    public static Map getDriverProps(final String browserName) {
        return browsersMap.get(browserName).getDriverProps();
    }
}