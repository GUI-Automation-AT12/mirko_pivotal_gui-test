package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(css = "#general.card ul.rows.read li div")
    private WebElement profileUserName;

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']"
            + "/div/div/form/button[contains(@data-aid,'signout')]")
    private WebElement signOutBtn;

    private void clickUserNameDropdownMenu() {
        this.userNameDropdownMenu.click();
    }

    private void clickSignOutBtn() {
        this.signOutBtn.click();
    }

    /**
     * Find the User Name from the Profile Page as String.
     * @return User name as String.
     */
    public String getProfileUserNameAsString() {
        return this.profileUserName.getText();
    }

    /**
     * Allows sign a user out from GUI.
     */
    public void signOut() {
        clickUserNameDropdownMenu();
        clickSignOutBtn();
    }
}
