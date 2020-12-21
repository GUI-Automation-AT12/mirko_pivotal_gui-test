package org.fundacionjala.pivotal.ui.component;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.pivotal.ui.pages.BasePage;

public class UserMenu extends BasePage {

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']/div/div/a[1]")
    private WebElement profileLink;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']"
            + "/div/div/form/button[contains(@data-aid,'signout')]")
    private WebElement signOutBtn;

    private void clickUserNameDropdownMenu() {
        GuiInteractioner.clickWebElement(userNameDropdownMenu);
    }

    private void clickProfileLink() {
        GuiInteractioner.clickWebElement(profileLink);
    }

    private void clickSignOutBtn() {
        GuiInteractioner.clickWebElement(signOutBtn);
    }
    /**
     * Allows sign a user out from GUI.
     */
    public void signOut() {
        clickUserNameDropdownMenu();
        clickSignOutBtn();
    }

    /**
     * Allows user to drive to Profile Page.
     * @return ProfilePage
     */
    public ProfilePage goToProfile() {
        clickUserNameDropdownMenu();
        clickProfileLink();
        return new ProfilePage();
    }
}
