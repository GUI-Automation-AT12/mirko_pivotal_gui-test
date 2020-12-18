package org.fundacionjala.pivotal;

import org.fundacionjala.core.config.Environment;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.ui.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class LoginPivotalTest {

    final private String EXPECTED_USER_NAME = "mirkofer122020";
    //Page Objects
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private ProfilePage profilePage;

    @AfterEach
    public void tearDown() {
        profilePage.signOut();
    }

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
