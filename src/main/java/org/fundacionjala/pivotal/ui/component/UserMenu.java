package org.fundacionjala.pivotal.ui.component;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.pivotal.ui.pages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class UserMenu extends BasePage {



    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']/div/div/a[1]")
    private WebElement profileLink;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']"
            + "/div/div/form/button[contains(@data-aid,'signout')]")
    private WebElement signOutBtn;

    @FindBy(css = ".AvatarDetails__underlyingInitials")
    private WebElement underlyingInitials;

    @FindBy(css = ".AvatarDetails__personalInfoContainer .AvatarDetails__name")
    private WebElement detailsName;

    @FindBy(css = ".AvatarDetails__personalInfoContainer .AvatarDetails__username")
    private WebElement detailsUserName;

    @FindBy(css = ".AvatarDetails__personalInfoContainer .AvatarDetails__initials")
    private WebElement detailsInitials;

    private void clickProfileLink() {
        GuiInteractioner.clickWebElement(profileLink);
    }

    private void clickSignOutBtn() {
        GuiInteractioner.clickWebElement(signOutBtn);
    }

    private String getUnderlyingInitialsAsString() {
        return GuiInteractioner.getTextFromWebElement(underlyingInitials);
    }

    private String getDetailsNameAsString() {
        return GuiInteractioner.getTextFromWebElement(detailsName);
    }

    private String getDetailsUserNameAsString() {
        return GuiInteractioner.getTextFromWebElement(detailsUserName);
    }

    private String getDetailsInitialsAsString() {
        return GuiInteractioner.getTextFromWebElement(detailsInitials);
    }

    /**
     * Allows sign a user out from GUI.
     */
    public void signOut() {
        clickSignOutBtn();
    }

    /**
     * Allows user to drive to Profile Page.
     * @return ProfilePage
     */
    public ProfilePage goToProfile() {
        clickProfileLink();
        return new ProfilePage();
    }

    /**
     * Gets all user information described in the User Dropdown Menu as a Map.
     * @return a Map with user information contained
     */
    public Map<String, String> getUserInformationAsMap() {
        Map userInfoMap = new HashMap<String, String>();
        userInfoMap.put("Underlying initials", getUnderlyingInitialsAsString());
        userInfoMap.put("Details user name", getDetailsUserNameAsString());
        userInfoMap.put("Details name", getDetailsNameAsString());
        userInfoMap.put("Details initials", getDetailsInitialsAsString());
        return userInfoMap;
    }
}
