package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectsSummaryPage;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.testng.asserts.SoftAssert;

import static org.junit.Assert.assertTrue;

import java.util.Map;
public class ProjectSteps {

    // Pages
    private DashboardPage dashboardPage;
    private CreateProjectPopup createProjectPopup;
    private ProjectPage projectPage;
    private ProjectsSummaryPage projectsSummaryPage;

    /**
     * StepDef to open the Create Project pop-up
     */
    @When("I open the Create Project pop-up")
    public void openTheCreateProjectPopUp() {
        dashboardPage = new DashboardPage();
        createProjectPopup = dashboardPage.goToProjectCreation();
    }

    /**
     * StepDef to create a new public project with the provided data.
     * @param projectInfo
     */
    @When("I create a new public Project with the following information")
    public void createNewProject(final Map<String, String> projectInfo) {
        projectPage = createProjectPopup.createPublicProject(projectInfo.get("Name"), projectInfo.get("Account"));
    }

    /**
     * StepDef to check that I was driven to recently created Project Page.
     */
    @Then("I am driven to recently created Project Page")
    public void verifyIAmDrivenToProjectPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            String actual = WebDriverManager.getInstance().getCurrentUrl();
            assertTrue(actual.startsWith("https://www.pivotaltracker.com/n/projects/"));
        }
    }


    @Then("the name of my new project should be displayed at Project Dropdown Menu")
    public void verifyTheNameOfMyNewProjectIsDisplayedAtProjectDropdownMenu() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(projectPage.getTextFromProjectNameSpan(), "New Public Project");
        softAssert.assertEquals(projectPage.getTextFromProjectPublicPrivacySpan(), "(Public)");
        softAssert.assertAll();
    }

    @When("I open the Project Summary page")
    public void openTheProjectSummaryPage() {
        projectsSummaryPage = projectPage.goToProjectsList();
    }


    @Then("my new project should be listed in the summary")
    public void verifyMyNewProjectIsListedInTheSummary() {
        assertTrue(projectsSummaryPage.searchProjectInSummary("New Public Project"));
    }
}
