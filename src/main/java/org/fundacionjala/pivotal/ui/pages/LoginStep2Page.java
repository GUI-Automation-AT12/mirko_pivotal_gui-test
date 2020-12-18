package org.fundacionjala.pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep2Page extends BasePage{
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(name = "action")
    private WebElement signInBtn;

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
        return new HomePage();
    }
}