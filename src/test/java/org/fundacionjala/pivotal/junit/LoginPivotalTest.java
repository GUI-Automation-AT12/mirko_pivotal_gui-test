package org.fundacionjala.pivotal.junit;

import org.fundacionjala.core.config.Environment;
import org.fundacionjala.pivotal.ui.pages.InitialPage;
import org.fundacionjala.pivotal.ui.pages.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LoginStep2Page;
import org.fundacionjala.pivotal.ui.pages.HomePage;
import org.fundacionjala.pivotal.ui.component.UserMenu;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class LoginPivotalTest {

    final private String EXPECTED_USER_NAME = "mirkofer122020";
    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private UserMenu userMenu;

    @After
    public void tearDown() {
        userMenu.signOut();
    }

    @Test
    public void loginPivotalTest() {
        initialPage = new InitialPage();
        initialPage.goToUrl(Environment.getInstance().getBaseUrl());
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(Environment.getInstance().getUserEmail());
        homePage = loginStep2Page.signIn(Environment.getInstance().getUserPassword());
        userMenu = homePage.goToProfile();
        String actual = userMenu.getProfileUserNameAsString();
        assertEquals(actual, EXPECTED_USER_NAME);
    }
}
