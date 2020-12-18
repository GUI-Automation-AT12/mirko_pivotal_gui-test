package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep2Page extends BasePage {
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

    /**
     * Fills the password and log a user in Pivotal Tracker.
     * @param password
     * @return a new HomePage.
     */
    public HomePage signIn(final String password) {
        fillPassword(password);
        clickSignInBtn();
        return new HomePage();
    }
}
