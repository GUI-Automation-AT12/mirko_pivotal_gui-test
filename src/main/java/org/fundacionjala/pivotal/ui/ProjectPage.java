package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends BasePage {

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projectDropdownList;

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement allProjectsLink;

    protected ProjectPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
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
        clickProjectDropdownList();
        clickAllProjectsLink();
        return new AllProjectsPage(super.webDriver, super.webDriverWait);
    }
}
