package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.component.EditProfileForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class ProfilePage extends BaseLoggedInPage {

    private EditProfileForm editProfileForm;

    /**
     * Constructor for ProfilePage.
     */
    public ProfilePage() {
        editProfileForm = new EditProfileForm();
    }

    @FindBy(css = "#general.card ul.rows.read li:nth-child(1) div")
    private WebElement profileUserName;

    @FindBy(css = "#general.card ul.rows.read li:nth-child(2) div")
    private WebElement profileName;

    @FindBy(css = "#general.card ul.rows.read li:nth-child(3) div")
    private WebElement profileInitials;

    @FindBy(css = "#email_and_password ul li:nth-child(1) div")
    private WebElement profileEmail;

    @FindBy(css = ".edit_button.header_button")
    private WebElement editProfileBtn;

    @FindBy(css = "#general_flash span")
    private WebElement changesNotifier;

    @FindBy(css = ".user_management_header div:nth-child(1)")
    private WebElement userManagementMenuTitle;

    private String getProfileInformationAsString(final WebElement webElement) {
        return GuiInteractioner.getTextFromWebElement(webElement);
    }

    /**
     * Find the User Name from the Profile Page as String.
     * @return User name as String
     */
    public String getProfileUserNameAsString() {
        return getProfileInformationAsString(profileUserName);
    }

    /**
     * Find the Email from the Profile Page as String.
     * @return User name as String
     */
    public String getProfileEmailAsString() {
        return getProfileInformationAsString(profileEmail);
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
     * Returns the EditProfileForm clicking at EditProfileBtn.
     * @return editProfileForm
     */
    public EditProfileForm getEditProfileForm() {
        clickEditProfileButton();
        return editProfileForm;
    }

    /**
     * Gets the inner text on changes notifier.
     * @return text from changes notifier
     */
    public String getTextFromChangesNotifier() {
        return GuiInteractioner.getTextFromWebElement(changesNotifier);
    }

    /**
     * Gets edited user information described in the Profile Page as a Map.
     * @return a Map with user information present in the Profile Page
     */
    public Map<String, String> getUserInformationAsMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put("User name", getProfileUserNameAsString());
        userInfoMap.put("Name", getProfileNameAsString());
        userInfoMap.put("Initials", getProfileInitialsAsString());
        return userInfoMap;
    }

    /**
     * Gets the User Management Menu Title.
     * @return User Management Menu Title as String
     */
    public String getUserManagementMenuTitleAsString() {
        return GuiInteractioner.getTextFromWebElement(userManagementMenuTitle);
    }
}
