package org.fundacionjala.pivotal.junit;

import org.fundacionjala.core.config.Environment;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.ui.pages.LoginStep2Page;
import org.fundacionjala.pivotal.ui.pages.HomePage;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.fundacionjala.pivotal.ui.pages.ProjectPage;
import org.fundacionjala.pivotal.ui.pages.AllProjectsPage;
import org.fundacionjala.pivotal.ui.pages.ProjectSettingsPage;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class ProjectTest {
    //Page Objects
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private CreateProjectPopup createProjectPopup;
    private ProjectPage projectPage;
    private AllProjectsPage allProjectsPage;
    private ProjectSettingsPage projectSettingsPage;

    private String firstProjectName;

    @Before
    public void setUp() {
        loginStep2Page = new LoginStep2Page();
        homePage = loginStep2Page.signIn(Environment.getInstance().getUserPassword());
    }
    @After
    public void tearDown() {
        if("ProjectTest".equals(firstProjectName)) {
            projectSettingsPage = allProjectsPage.goToFirstProjectSettings();
            projectSettingsPage.deleteProject();
        }
        WebDriverManager.getInstance().getWebDriver().quit();
    }
    @Test
    public void createProjectTest() {
        createProjectPopup = homePage.goToProjectCreation();
        projectPage = createProjectPopup.createProject("ProjectTest");
        allProjectsPage = projectPage.goToProjectsList();
        firstProjectName = allProjectsPage.getFirstListedProject();
        assertEquals("ProjectTest", firstProjectName);
    }
}
