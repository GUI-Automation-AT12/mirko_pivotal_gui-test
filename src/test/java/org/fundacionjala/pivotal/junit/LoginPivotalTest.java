package org.fundacionjala.pivotal.junit;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.User;
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

    //dependency injection
    private Context context;

    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private DashboardPage dashboardPage;
    private ProfilePage profilePage;

    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedContext
     */
    public LoginPivotalTest(final Context sharedContext) {
        this.context = sharedContext;
    }

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
    public void loginPivotalTest() throws MalformedURLException {
        User user = context.getUserByAlias("Editable User");
        WebDriverManager.setBrowserName("chrome");
        WebTransporter.navigateToPage();
        initialPage = new InitialPage();
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(user.getEmail());
        dashboardPage = loginStep2Page.signIn(user.getPassword());
        profilePage = dashboardPage.getTopMenu().openUserNameDropdownMenu().goToProfile();
        String actual = profilePage.getProfileEmailAsString();
        assertEquals(actual, user.getPassword());
    }
}
