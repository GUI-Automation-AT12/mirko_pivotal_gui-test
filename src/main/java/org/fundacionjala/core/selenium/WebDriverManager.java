package org.fundacionjala.core.selenium;

import org.fundacionjala.core.config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public final class WebDriverManager {

    private static WebDriverManager webDriverManager;
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
        System.setProperty("webdriver.gecko.driver", Environment.getInstance().getWebdriverGeckoDriver());
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().
                implicitlyWait(Environment.getInstance().getImplicitWaitingSeconds(), TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver,
                Environment.getInstance().getExplicitWaitingSeconds(), Environment.getInstance().getSleepingMillis());
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
}
