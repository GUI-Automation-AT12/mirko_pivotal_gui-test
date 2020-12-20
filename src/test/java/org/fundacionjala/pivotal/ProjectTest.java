package org.fundacionjala.pivotal;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.throwables.EnvironmentReadingException;
import org.fundacionjala.pivotal.ui.InitialPage;
import org.fundacionjala.pivotal.ui.LoginStep1Page;
import org.fundacionjala.pivotal.ui.LoginStep2Page;
import org.fundacionjala.pivotal.ui.HomePage;
import org.fundacionjala.pivotal.ui.CreateProjectPage;
import org.fundacionjala.pivotal.ui.ProjectPage;
import org.fundacionjala.pivotal.ui.AllProjectsPage;
import org.fundacionjala.pivotal.ui.ProjectSettingsPage;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class ProjectTest {
    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private CreateProjectPage createProjectPage;
    private ProjectPage projectPage;
    private AllProjectsPage allProjectsPage;
    private ProjectSettingsPage projectSettingsPage;
    private String firstProjectName;

    /**
     * Hook that log the user before running a test.
     */
    @Before
    public void setUp() throws EnvironmentReadingException {
        initialPage = new InitialPage();
        initialPage.goToUrl(PivotalProperties.getInstance().getBaseUrl());
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(PivotalProperties.getInstance().getUserEmail());
        homePage = loginStep2Page.signIn(PivotalProperties.getInstance().getUserPassword());
    }

    /**
     * Hook that deletes a created project and close Firefox after running a test.
     */
    @After
    public void tearDown() {
        if ("ProjectTest".equals(firstProjectName)) {
            projectSettingsPage = allProjectsPage.goToFirstProjectSettings();
            projectSettingsPage.deleteProject();
        }
        WebDriverManager.getInstance().quit();
    }

    /**
     * Test to verify the creation of a Pivotal project.
     */
    @Test
    public void createProjectTest() {
        createProjectPage = homePage.goToProjectCreation();
        projectPage = createProjectPage.createProject("ProjectTest");
        allProjectsPage = projectPage.goToProjectsList();
        this.firstProjectName = allProjectsPage.getFirstListedProject();
        assertEquals("ProjectTest", firstProjectName);
    }
}
