package org.fundacionjala.pivotal.junit;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.config.PivotalProperties;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LogedOut.InitialPage;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep2Page;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectsSummaryPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectSettingsPage;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class ProjectTest {
    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private DashboardPage dashboardPage;
    private CreateProjectPopup createProjectPopup;
    private ProjectPage projectPage;
    private ProjectsSummaryPage projectsSummaryPage;
    private ProjectSettingsPage projectSettingsPage;
    private String firstProjectName;

    /**
     * Hook that log the user before running a test.
     */
    @Before
    public void setUp() throws MalformedURLException {
        WebTransporter.navigateToPage();
        initialPage = new InitialPage();
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(PivotalProperties.getInstance().getUserEmail());
        dashboardPage = loginStep2Page.signIn(PivotalProperties.getInstance().getUserPassword());
    }

    /**
     * Hook that deletes a created project and close Firefox after running a test.
     */
    @After
    public void tearDown() {
        if ("ProjectTest".equals(firstProjectName)) {
            projectSettingsPage = projectsSummaryPage.goToFirstProjectSettings();
            projectSettingsPage.deleteProject();
        }
        WebDriverManager.getInstance().quit();
    }

    /**
     * Test to verify the creation of a Pivotal project.
     */
    @Test
    public void createProjectTest() {
        createProjectPopup = dashboardPage.goToProjectCreation();
        projectPage = createProjectPopup.createProject("ProjectTest");
        projectsSummaryPage = projectPage.goToProjectsList();
        this.firstProjectName = projectsSummaryPage.getFirstListedProject();
        assertEquals("ProjectTest", firstProjectName);
    }
}
