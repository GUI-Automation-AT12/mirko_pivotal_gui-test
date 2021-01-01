package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.context.ProjectContext;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.ui.WebTransporter;
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

    // Entity
    private Project project;

    //Context
    private final ProjectContext projectContext;

    private static final int WAIT_TIME = 3000;
    /**
     * Adding Dependency injection to share Project Context information.
     * @param sharedProjectContext
     */
    public ProjectSteps(final ProjectContext sharedProjectContext) {
        this.projectContext = sharedProjectContext;
    }

    /**
     * StepDef to open the Create Project pop-up.
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
        //Updating Project entity
        project = new Project();
        project.setName(projectInfo.get("Name"));
        project.setAccount(projectInfo.get("Account"));
        project.setPrivacy(projectInfo.get("Privacy"));

        //Creating Project from UI
        projectPage = createProjectPopup.createPublicProject(projectInfo.get("Name"), projectInfo.get("Account"));
    }

    /**
     * StepDef to check that I was driven to recently created Project Page.
     */
    @Then("I am driven to recently created Project Page")
    public void verifyIAmDrivenToProjectPage() {
        try {
            Thread.sleep(WAIT_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            String currentUrl = WebTransporter.getCurrentUrl();
            assertTrue(currentUrl.startsWith("https://www.pivotaltracker.com/n/projects/"));

            //Updating Project entity's id
            project.setId(currentUrl.substring(currentUrl.lastIndexOf('/') + 1));
            projectContext.getProjectsIdsToDelete().add(project.getId());
        }
    }

    /**
     * StepDef to verify that the name of the new project is displayed at Project Dropdown Menu.
     */
    @Then("the name of my new project should be displayed at Project Dropdown Menu")
    public void verifyTheNameOfMyNewProjectIsDisplayedAtProjectDropdownMenu() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(projectPage.getTextFromProjectNameSpan(), project.getName());
        softAssert.assertEquals(projectPage.getTextFromProjectPublicPrivacySpan(), "(" + project.getPrivacy() + ")");
        softAssert.assertAll();
    }

    /**
     * StepDef to open Project Summary Page.
     */
    @When("I open the Project Summary page")
    public void openTheProjectSummaryPage() {
        projectsSummaryPage = projectPage.goToProjectsList();
    }


    /**
     * StepDef to verify the new project is listed in the Project Summary Page.
     */
    @Then("my new project should be listed in the summary")
    public void verifyMyNewProjectIsListedInTheSummary() {
        assertTrue(projectsSummaryPage.searchProjectInSummary(project.getName()));
    }
}
