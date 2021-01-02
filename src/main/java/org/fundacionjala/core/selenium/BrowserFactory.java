package org.fundacionjala.core.selenium;

import org.fundacionjala.core.selenium.browsers.Browser;
import org.fundacionjala.core.selenium.browsers.BrowserParser;
import org.fundacionjala.core.selenium.browsers.browserTypes.ChromeBrowser;
import org.fundacionjala.core.selenium.browsers.browserTypes.EdgeBrowser;
import org.fundacionjala.core.selenium.browsers.browserTypes.FirefoxBrowser;
import org.fundacionjala.core.selenium.browsers.browserTypes.IBrowser;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
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
     * @param browserName name of the browser
     * @return a webDriver
     */
    public static WebDriver getWebDriver(final String browserName) {
        return browsersMap.get(browserName).initDriver();
    }

    /**
     * Gets a driverProps providing the browser name.
     * @param browserName name of the browser
     * @return Driver Properties of the browser
     * @thows IOException
     */
    public static Browser getDriverProps(final String browserName) throws IOException {
        return BrowserParser.getBrowsersMap().get(browserName);
    }
}
