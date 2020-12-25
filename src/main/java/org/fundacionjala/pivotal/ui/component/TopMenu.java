package org.fundacionjala.pivotal.ui.component;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {

    private UserMenu userMenu;

    /**
     * Constructor for TopMenu class.
     */
    public TopMenu() {
        userMenu = new UserMenu();
    }

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    /**
     * Open the Username Dropdown Menu doing click in that.
     * @return userMenu
     */
    public UserMenu openUserNameDropdownMenu() {
        GuiInteractioner.clickWebElement(userNameDropdownMenu);
        return userMenu;
    }

    /**
     * Gets the UserMenu.
     * @return userMenu.
     */
    public UserMenu getUserMenu() {
        return userMenu;
    }

    /**
     * Gets the inner UserName in the Dropdown Menu.
     * @return userName of the Dropdown Menu
     */
    public String getUserNameFromTopMenu() {
        return GuiInteractioner.getTextFromWebElement(userNameDropdownMenu);
    }
}
