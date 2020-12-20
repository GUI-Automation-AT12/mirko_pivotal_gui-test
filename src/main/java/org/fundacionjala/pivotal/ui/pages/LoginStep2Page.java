package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep2Page extends BasePage {
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(name = "action")
    private WebElement signInBtn;

    private void fillPassword(final String password) {
        GuiInteractioner.fillWebElement(passwordTextBox, password);
    }

    private void clickSignInBtn() {
        GuiInteractioner.clickWebElement(signInBtn);
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
