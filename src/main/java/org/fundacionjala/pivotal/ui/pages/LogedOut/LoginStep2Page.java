package org.fundacionjala.pivotal.ui.pages.LogedOut;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep2Page extends BasePage {
    @FindBy(id = "credentials_password")
    private WebElement passwordTextBox;

    @FindBy(name = "action")
    private WebElement signInBtn;

    private void fillPassword(final String password) {
        GuiInteractioner.setInputText(passwordTextBox, password);
    }

    private void clickSignInBtn() {
        GuiInteractioner.clickWebElement(signInBtn);
    }

    /**
     * Fills the password and log a user in Pivotal Tracker.
     * @param password password of the user
     * @return a new DashboardPage.
     */
    public DashboardPage signIn(final String password) {
        fillPassword(password);
        clickSignInBtn();
        return new DashboardPage();
    }
}
