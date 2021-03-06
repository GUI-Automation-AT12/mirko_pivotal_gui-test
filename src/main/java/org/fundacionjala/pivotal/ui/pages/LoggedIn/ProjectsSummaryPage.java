package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.entities.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProjectsSummaryPage extends BaseLoggedInPage {

    @FindBy(css = ".projects.column a")
    private List<WebElement> listedProjects;

    /**
     * Search for a project by project's name.
     * @param projectName name of searched project
     * @return the WebElement that contains the projectName, if it does not find the project, returns null.
     */
    public WebElement isProjectInSummary(final String projectName) {
        return GuiInteractioner.searchTextInWebElementList(listedProjects, projectName);
    }

    /**
     * Click Settings link of the a project.
     * @param project of the required project
     * @return new ProjectSettingsPage
     */
    public ProjectSettingsPage clickSettingsLinkOfProject(final Project project) {
        GuiInteractioner.clickWebElement(By
                .cssSelector(".project_row.project_" + project.getId() + " .actions.column .settings.column a"));
        return new ProjectSettingsPage();
    }
}
