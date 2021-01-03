package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectSettingsPage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectsSummaryPage;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.testng.asserts.SoftAssert;

import static org.junit.Assert.assertNotNull;
import java.util.Map;

public class ProjectSteps {

    // Pages
    private DashboardPage dashboardPage;
    private CreateProjectPopup createProjectPopup;
    private ProjectPage projectPage;
    private ProjectsSummaryPage projectsSummaryPage;
    private ProjectSettingsPage projectSettingsPage;

    // Entity
    private Project project;

    //Context
    private final Context context;

    private static final int WAIT_TIME = 5000;
    /**
     * Adds Dependency injection to share Context information.
     * @param sharedContext
     */
    public ProjectSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Opens the Create Project pop-up.
     */
    @When("I open the Create Project pop-up")
    public void openTheCreateProjectPopUp() {
        dashboardPage = new DashboardPage();
        createProjectPopup = dashboardPage.goToProjectCreation();
    }

    /**
     * Creates a new public project with the provided data.
     * @param projectInfo as Map<String, String>
     */
    @When("I create a new public Project with the following information")
    public void createNewProject(final Map<String, String> projectInfo) {
        //Updating Project entity
        project = new Project(projectInfo.get("Name"), projectInfo.get("Account"), projectInfo.get("Privacy"));

        //Creating Project from UI
        projectPage = createProjectPopup.createPublicProject(project);

        //Saving new Project in Context
        context.getProjectListToDelete().add(project);
    }

    /**
     * Verifies that the name of the new project is displayed at Project Dropdown Menu.
     */
    @Then("properties of new project should be displayed at Project's Page")
    public void verifyPropertiesOfNewProjectIsDisplayedAtProjectsPage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(projectPage.getTextFromProjectNameSpan(), project.getName());
        softAssert.assertEquals(projectPage.getTextFromProjectPublicPrivacySpan(), "(" + project.getPrivacy() + ")");
        softAssert.assertAll();
    }

    /**
     * Saves the project Id in the Project entity.
     */
    @When("I save the Project's Id")
    public void saveTheProjectId() {
        String gottenId = projectPage.getIdFromUrl();
        project.setId(gottenId);
    }

    /**
     * Opens Project Summary Page.
     */
    @When("I open the Project Summary page")
    public void openTheProjectSummaryPage() {
        projectsSummaryPage = projectPage.goToProjectsList();
    }


    /**
     * Verifies the new project is listed in the Project Summary Page.
     */
    @Then("my new project should be listed in the summary")
    public void verifyMyNewProjectIsListedInTheSummary() {
        assertNotNull("The project: " + project.getName() + " is not present in the Project Summary.",
                projectsSummaryPage.isProjectInSummary(project.getName()));
    }

    /**
     * Opens Project's Settings Page.
     */
    @When("I open the Project's Settings Page")
    public void openTheProjectSSettingsPage() {
        projectSettingsPage = projectsSummaryPage.clickSettingsLinkOfProject(project);
    }

    /**
     * Verifies all Project's creation data should be present in Project's Settings Page.
     */
    @Then("all Project's creation data should be present")
    public void verifyAllProjectsCreationDataIsPresent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(projectSettingsPage.getValueAttributeFromProjectNameTextBox(), project.getName(),
                "The Project's name is different that defined at creation step.");
        softAssert.assertTrue(projectSettingsPage.getTextProjectAccountLink().contains(project.getAccount()),
                "The Project Account Link does not contain the account defined at creation step.");
        softAssert.assertTrue(projectSettingsPage.getStatusOfProjectPrivacyCheckbox(),
                "The Project Privacy is private but was created as public.");
        softAssert.assertAll();
    }
}
