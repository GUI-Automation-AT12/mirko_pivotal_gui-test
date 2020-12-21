package org.fundacionjala.pivotal.junit;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.throwables.EnvironmentReadingException;
import org.fundacionjala.pivotal.config.PivotalProperties;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LogedOut.InitialPage;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep2Page;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;
import org.junit.Test;
import org.junit.After;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

public class LoginPivotalTest {

    private static final String EXPECTED_USER_NAME = "mirkofer122020";
    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private DashboardPage dashboardPage;
    private ProfilePage profilePage;

    /**
     * Hook that signs out a logged in user After running a test..
     */
    @After
    public void tearDown() {
        WebDriverManager.getInstance().quit();
    }

    /**
     * Test for Log In a user to Pivotal Tracker from GUI.
     */
    @Test
    public void loginPivotalTest() throws EnvironmentReadingException, MalformedURLException {
        WebTransporter.navigateToPage();
        initialPage = new InitialPage();
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(PivotalProperties.getInstance().getUserEmail());
        dashboardPage = loginStep2Page.signIn(PivotalProperties.getInstance().getUserPassword());
        profilePage = dashboardPage.getUserMenu().goToProfile();
        String actual = profilePage.getProfileUserNameAsString();
        assertEquals(actual, EXPECTED_USER_NAME);
    }
}
