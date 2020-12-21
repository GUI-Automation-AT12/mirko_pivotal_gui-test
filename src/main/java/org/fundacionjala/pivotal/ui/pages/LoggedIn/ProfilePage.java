package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.component.EditProfileForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BaseLoggedInPage {

    EditProfileForm editProfileForm;

    public ProfilePage() {
        editProfileForm = new EditProfileForm();
    }

    @FindBy(css = "#general.card ul.rows.read li div")
    private WebElement profileUserName;

    @FindBy(css = ".edit_button.header.button")
    private WebElement editProfileBtn;

    @FindBy(id = "general_flash")
    private WebElement changesNotification;

    /**
     * Find the User Name from the Profile Page as String.
     * @return User name as String
     */
    public String getProfileUserNameAsString() {
        return GuiInteractioner.getTextFromWebElement(profileUserName);
    }

    private void clickEditProfileButton() {
        GuiInteractioner.clickWebElement(editProfileBtn);
    }

    /**
     * Returns the EditProfileForm clicking at EditProfileBtn
     * @return editProfileForm
     */
    public EditProfileForm getEditProfileForm() {
        clickEditProfileButton();
        return editProfileForm;
    }

    public String getTextFromChangesNotification() {
        return GuiInteractioner.getTextFromWebElement(changesNotification);
    }
}
