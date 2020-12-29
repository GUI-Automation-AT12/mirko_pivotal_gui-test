package org.fundacionjala.pivotal.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.context.ProjectContext;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectSettingsPage;

import java.net.MalformedURLException;

public class ProjectHooks {

    private final ProjectContext projectContext;

    /**
     * Adding Dependency injection to share Project Context information.
     * @param sharedProjectContext
     */
    public ProjectHooks(final ProjectContext sharedProjectContext) {
        this.projectContext = sharedProjectContext;
    }

    /**
     * AfterHook that deletes created Project.
     */
    @After(value = "@deleteProject")
    public void deleteProject() throws MalformedURLException {
        for (String id : projectContext.getProjectsIdsToDelete()) {
            WebTransporter.navigateToPath("projects/" + id + "/settings");
            ProjectSettingsPage projectSettingsPage = new ProjectSettingsPage();
            projectSettingsPage.deleteProject();
            WebDriverManager.getInstance().quit();
        }
    }
}
