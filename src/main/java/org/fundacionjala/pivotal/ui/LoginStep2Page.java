package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStep2Page extends BasePage{
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(name = "action")
    private WebElement signInBtn;

    public LoginStep2Page(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    private void fillPassword(final String password) {
        this.passwordTextBox.clear();
        this.passwordTextBox.sendKeys(password);
    }

    private void clickSignInBtn() {
        this.signInBtn.click();
    }

    public HomePage signIn(final String password) {
        fillPassword(password);
        clickSignInBtn();
        return new HomePage(super.webDriver, super.webDriverWait);
    }
}
