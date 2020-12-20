package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.pivotal.ui.pages.AllProjectsPage;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projectDropdownList;

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement allProjectsLink;

    private void sleepToShowPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickProjectDropdownList() {
        this.projectDropdownList.click();
    }

    private void clickAllProjectsLink() {
        this.allProjectsLink.click();
    }

    public AllProjectsPage goToProjectsList() {
        sleepToShowPage();
        clickProjectDropdownList();
        clickAllProjectsLink();
        return new AllProjectsPage();
    }
}
