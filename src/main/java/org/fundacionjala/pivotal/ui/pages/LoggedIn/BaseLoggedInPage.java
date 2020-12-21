package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.pivotal.ui.component.TopMenu;
import org.fundacionjala.pivotal.ui.component.UserMenu;
import org.fundacionjala.pivotal.ui.pages.BasePage;

public class BaseLoggedInPage extends BasePage {
    private TopMenu topMenu;
    private UserMenu userMenu;

    /**
     * Constructor for Dashboard class.
     */
    public BaseLoggedInPage() {
        topMenu = new TopMenu();
        userMenu = new UserMenu();
    }

    /**
     * Gets TopMenu.
     * @return topMenu
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }

    /**
     * Gets UserMenu.
     * @return userMenu
     */
    public UserMenu getUserMenu() {
        return userMenu;
    }
}
