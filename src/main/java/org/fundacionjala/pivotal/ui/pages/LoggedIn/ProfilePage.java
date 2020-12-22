package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.component.EditProfileForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ProfilePage extends BaseLoggedInPage {

    EditProfileForm editProfileForm;

    public ProfilePage() {
        editProfileForm = new EditProfileForm();
    }

    @FindBy(css = "#general.card ul.rows.read li:nth-child(1) div")
    private WebElement profileUserName;

    @FindBy(css = "#general.card ul.rows.read li:nth-child(2) div")
    private WebElement profileName;

    @FindBy(css = "#general.card ul.rows.read li:nth-child(3) div")
    private WebElement profileInitials;

    @FindBy(css = ".edit_button.header_button")
    private WebElement editProfileBtn;

    @FindBy(css = "#general_flash span")
    private WebElement changesNotification;

    @FindBy(css = ".user_management_header div:nth-child(1)")
    private WebElement userManagementMenuTitle;

    private String getProfileInformationAsString(WebElement webElement) {
        return GuiInteractioner.getTextFromWebElement(webElement);
    }

    /**
     * Find the User Name from the Profile Page as String.
     * @return User name as String
     */
    public String getProfileUserNameAsString() {
        return getProfileInformationAsString(profileUserName);
    }

    private String getProfileNameAsString() {
        return getProfileInformationAsString(profileName);
    }

    private String getProfileInitialsAsString() {
        return getProfileInformationAsString(profileInitials);
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

    public Map<String, String> getUserInformationAsMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put("User name", getProfileUserNameAsString());
        userInfoMap.put("Name", getProfileNameAsString());
        userInfoMap.put("Initials", getProfileInitialsAsString());
        return userInfoMap;
    }

    public String getUserManagementMenuTitleAsString() {
        return GuiInteractioner.getTextFromWebElement(userManagementMenuTitle);
    }
}
