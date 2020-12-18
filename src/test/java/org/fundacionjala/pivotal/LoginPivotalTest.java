package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.ui.InitialPage;
import org.fundacionjala.pivotal.ui.LoginStep1Page;
import org.fundacionjala.pivotal.ui.LoginStep2Page;
import org.fundacionjala.pivotal.ui.HomePage;
import org.fundacionjala.pivotal.ui.ProfilePage;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class LoginPivotalTest {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private ProfilePage profilePage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        this.webDriver = new FirefoxDriver();
        webDriver.get("https://www.pivotaltracker.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 40, 500);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void loginPivotalTest() {
        initialPage = new InitialPage(webDriver, webDriverWait);
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2("mirkofer.122020@gmail.com");
        homePage = loginStep2Page.signIn("622Mirko###");
        profilePage = homePage.goToProfile();
        String actual = profilePage.getProfileUserNameAsString();
        assertEquals(actual, "mirkofer122020");
    }
}
