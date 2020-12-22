package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.pivotal.ui.component.TopMenu;
import org.fundacionjala.pivotal.ui.pages.BasePage;

public class BaseLoggedInPage extends BasePage {
    private TopMenu topMenu;

    /**
     * Constructor for Dashboard class.
     */
    public BaseLoggedInPage() {
        topMenu = new TopMenu();
    }

    /**
     * Gets TopMenu.
     * @return topMenu
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }
}
