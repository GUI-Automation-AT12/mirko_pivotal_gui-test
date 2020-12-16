package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialPage extends BasePage {
    @FindBy(linkText = "Log in")
    private WebElement LogInLink;

    public InitialPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    private void clickLogInLink() {
        this.LogInLink.click();
    }

    public LoginStep1Page goToLoginStep1() {
        clickLogInLink();
        return new LoginStep1Page(super.webDriver, super.webDriverWait);
    }

}
