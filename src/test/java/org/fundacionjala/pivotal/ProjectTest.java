package org.fundacionjala.pivotal;

import org.fundacionjala.core.config.Environment;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.ui.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.Assert.*;

public class ProjectTest {
    //Page Objects
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;
    private CreateProjectPage createProjectPage;
    private ProjectPage projectPage;
    private AllProjectsPage allProjectsPage;
    private ProjectSettingsPage projectSettingsPage;

    private String firstProjectName;

    @BeforeEach
    public void setUp() {
        loginStep2Page = new LoginStep2Page();
        homePage = loginStep2Page.signIn(Environment.getInstance().getUserPassword());
    }
    @AfterEach
    public void tearDown() {
        if("ProjectTest".equals(firstProjectName)) {
            projectSettingsPage = allProjectsPage.goToFirstProjectSettings();
            projectSettingsPage.deleteProject();
        }
        WebDriverManager.getInstance().getWebDriver().quit();
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
