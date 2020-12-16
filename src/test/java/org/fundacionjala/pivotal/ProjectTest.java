package org.fundacionjala.pivotal;

import org.fundacionjala.pivotal.ui.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProjectTest {
    //Page Objects
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private CreateProjectPage createProjectPage;
    private ProjectPage projectPage;
    private AllProjectsPage allProjectsPage;
    private ProjectSettingsPage projectSettingsPage;

    private String firstProjectName;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        this.webDriver = new FirefoxDriver();
        webDriver.get("https://www.pivotaltracker.com/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 40, 500);
        initialPage = new InitialPage(webDriver, webDriverWait);
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2("mirkofer.122020@gmail.com");
        homePage = loginStep2Page.signIn("622Mirko###");
    }
    @AfterEach
    public void tearDown() {
        webDriver.get("https://www.pivotaltracker.com/projects");
        if("ProjectTest".equals(firstProjectName)) {
            projectSettingsPage = allProjectsPage.goToFirstProjectSettings();
            projectSettingsPage.deleteProject();
        }
        webDriver.quit();
    }
    @Test
    public void createProjectTest() {
        createProjectPage = homePage.goToProjectCreation();
        projectPage = createProjectPage.createProject("ProjectTest");
        allProjectsPage = projectPage.goToProjectsList();
        firstProjectName = allProjectsPage.getFirstListedProject();
        assertEquals("ProjectTest", firstProjectName);
    }
}
