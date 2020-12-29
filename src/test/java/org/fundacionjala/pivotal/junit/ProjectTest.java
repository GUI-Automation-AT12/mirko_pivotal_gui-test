package org.fundacionjala.pivotal.junit;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LogedOut.InitialPage;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep2Page;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectsSummaryPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectSettingsPage;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProjectTest {

    //dependency injection
    private Context context;

    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private DashboardPage dashboardPage;
    private CreateProjectPopup createProjectPopup;
    private ProjectPage projectPage;
    private ProjectsSummaryPage projectsSummaryPage;
    private ProjectSettingsPage projectSettingsPage;

    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedContext
     */
    public ProjectTest(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Hook that log the user before running a test.
     */
    @Before
    public void setUp() throws MalformedURLException {
        User user = context.getUserByAlias("Editable User");
        WebDriverManager.setBrowserName("EdgE");
        WebTransporter.navigateToPage();
        initialPage = new InitialPage();
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(user.getEmail());
        dashboardPage = loginStep2Page.signIn(user.getPassword());
    }

    /**
     * Hook that deletes a created project and close Firefox after running a test.
     */
    @After
    public void tearDown() {
        if ("ProjectTest".equals("ProjectTest")) {
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
        projectPage = createProjectPopup.createPublicProject("ProjectTest", "Account1");
        projectsSummaryPage = projectPage.goToProjectsList();
        assertTrue(projectsSummaryPage.searchProjectInSummary("ProjectTest"));
    }
}
