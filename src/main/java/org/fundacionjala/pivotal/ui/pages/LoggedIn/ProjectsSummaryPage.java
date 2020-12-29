package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsSummaryPage extends BaseLoggedInPage {

    @FindBy(xpath = "//div[@class='projects column']/a")
    private List<WebElement> listedProjects;

    @FindBy(xpath = "//div[@class='settings column'][1]/a")
    private WebElement firstProjectSettingsLink;

    private void clickFirstProjectSettingsLink() {
        GuiInteractioner.clickWebElement(firstProjectSettingsLink);
    }

    /**
     * Search for a project by project's name.
     * @return true if the project was found, otherwise return false
     */
    public boolean searchProjectInSummary(final String projectName) {
        return GuiInteractioner.searchTextInWebElementList(listedProjects ,projectName);
    }

    /**
     * Allow to drives the user to Project Settings Page.
     * @return ProjectSettingsPage
     */
    public ProjectSettingsPage goToFirstProjectSettings() {
        clickFirstProjectSettingsLink();
        return new ProjectSettingsPage();
    }
}
