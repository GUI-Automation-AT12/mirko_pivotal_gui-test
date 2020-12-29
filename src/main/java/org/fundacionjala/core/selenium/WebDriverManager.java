package org.fundacionjala.core.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private static String browserName;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;


    /**
     * If webDriverManager object was not created before it create a new one, otherwise return the created.
     * @return webDriverManager
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    private WebDriverManager() {
        webDriver = BrowserFactory.getWebDriver(browserName);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().
                implicitlyWait(Long.parseLong(BrowserFactory.getDriverProps(browserName).
                                get("implicitWaitingSeconds").toString()), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver,
                Long.parseLong(BrowserFactory.getDriverProps(browserName).get("explicitWaitingSeconds").toString()),
                Long.parseLong(BrowserFactory.getDriverProps(browserName).get("sleepingTimeMills").toString()));
    }

    /**
     * Sets the browser to run the tests, providing its name.
     * @param browser
     */
    public static void setBrowserName(final String browser) {
        WebDriverManager.browserName = browser;
    }

    /**
     * Return the webDriver of the singleInstance.
     * @return webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Return the webDriverWait of the singleInstance.
     * @return webDriverWait
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Quits the webDriver and set webDriverManager single instance as null.
     */
    public void quit() {
        this.webDriver.quit();
        this.webDriverManager = null;
    }
}
