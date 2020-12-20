package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {

    private static final int SLEEPING_TIME = 5000;

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projectDropdownList;

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement allProjectsLink;

    private void sleepToShowPage() {
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickProjectDropdownList() {
        GuiInteractioner.clickWebElement(projectDropdownList);
    }

    private void clickAllProjectsLink() {
        GuiInteractioner.clickWebElement(allProjectsLink);
    }

    /**
     * Drives to a Page of All Projects.
     * @return a new AllProjectsPage.
     */
    public AllProjectsPage goToProjectsList() {
        sleepToShowPage();
        clickProjectDropdownList();
        clickAllProjectsLink();
        return new AllProjectsPage();
    }
}
