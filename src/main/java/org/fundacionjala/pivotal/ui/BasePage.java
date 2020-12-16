package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    protected BasePage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.webDriver, this);
    }
}
