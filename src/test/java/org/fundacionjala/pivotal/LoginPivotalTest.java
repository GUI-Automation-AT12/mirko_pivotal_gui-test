package org.fundacionjala.pivotal;

import org.fundacionjala.core.config.Environment;
import org.fundacionjala.pivotal.ui.InitialPage;
import org.fundacionjala.pivotal.ui.LoginStep1Page;
import org.fundacionjala.pivotal.ui.LoginStep2Page;
import org.fundacionjala.pivotal.ui.HomePage;
import org.fundacionjala.pivotal.ui.ProfilePage;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class LoginPivotalTest {

    private static final String EXPECTED_USER_NAME = "mirkofer122020";
    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private ProfilePage profilePage;

    /**
     * Hook that signs out a logged in user After running a test..
     */
    @After
    public void tearDown() {
        profilePage.signOut();
    }

    /**
     * Test for Log In a user to Pivotal Tracker from GUI.
     */
    @Test
    public void loginPivotalTest() {
        initialPage = new InitialPage();
        initialPage.goToUrl(Environment.getInstance().getBaseUrl());
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(Environment.getInstance().getUserEmail());
        homePage = loginStep2Page.signIn(Environment.getInstance().getUserPassword());
        profilePage = homePage.goToProfile();
        String actual = profilePage.getProfileUserNameAsString();
        assertEquals(actual, EXPECTED_USER_NAME);
    }
}
