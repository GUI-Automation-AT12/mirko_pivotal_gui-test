package org.fundacionjala.pivotal.ui;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    protected BasePage() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Get webDriver of the BasePage.
     * @return webDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * It allows to go to a new Url from any page.
     * @param url
     */
    public void goToUrl(final String url) {
        this.webDriver.get(url);
    }
}
