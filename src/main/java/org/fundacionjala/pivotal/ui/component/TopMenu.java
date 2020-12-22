package org.fundacionjala.pivotal.ui.component;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {

    private UserMenu userMenu;

    public TopMenu() {
        userMenu = new UserMenu();
    }

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    public UserMenu openUserNameDropdownMenu() {
        GuiInteractioner.clickWebElement(userNameDropdownMenu);
        return userMenu;
    }

    public UserMenu getUserMenu() {
        return userMenu;
    }

    public String getUserNameFromTopMenu() {
        return GuiInteractioner.getTextFromWebElement(userNameDropdownMenu);
    }
}
