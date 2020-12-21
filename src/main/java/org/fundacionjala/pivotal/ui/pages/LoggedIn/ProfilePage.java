package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BaseLoggedInPage {

    @FindBy(css = "#general.card ul.rows.read li div")
    private WebElement profileUserName;

    /**
     * Find the User Name from the Profile Page as String.
     *
     * @return User name as String.
     */
    public String getProfileUserNameAsString() {
        return GuiInteractioner.getTextFromWebElement(profileUserName);
    }

}
