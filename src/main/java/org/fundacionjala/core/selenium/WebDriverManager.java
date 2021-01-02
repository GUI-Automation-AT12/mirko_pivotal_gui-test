package org.fundacionjala.core.selenium;

import org.fundacionjala.core.selenium.browsers.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
    private static String browserName;
    private WebDriver webDriver = null;
    private WebDriverWait webDriverWait = null;


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
        try {
            Browser browser = BrowserFactory.getDriverProps(browserName);
            webDriver = BrowserFactory.getWebDriver(browserName);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().
                    implicitlyWait(Long.parseLong(browser.getImplicitWaitingSeconds()), TimeUnit.SECONDS);
            webDriverWait = new WebDriverWait(webDriver, Long.parseLong(browser.getExplicitWaitingSeconds()),
                            Long.parseLong(browser.getSleepingTimeMills()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the browser to run the tests, providing its name.
     * @param browser name of the browser
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
        webDriverManager = null;
    }
}
