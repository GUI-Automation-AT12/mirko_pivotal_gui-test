package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.ui.WebTransporter;
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
     * Adding Dependency injection to share Project Context information.
     * @param sharedContext
     */
    public ProjectSteps(final Context sharedContext) {
        this.context = sharedContext;
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
     * StepDef to verify that the name of the new project is displayed at Project Dropdown Menu.
     */
    @Then("properties of new project should be displayed at Project's Page")
    public void verifyPropertiesOfNewProjectIsDisplayedAtProjectsPage() throws InterruptedException {
        Thread.sleep(WAIT_TIME);
        String currentUrl = WebTransporter.getCurrentUrl();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(currentUrl.startsWith("https://www.pivotaltracker.com/n/projects/"));
        softAssert.assertEquals(projectPage.getTextFromProjectNameSpan(), project.getName());
        softAssert.assertEquals(projectPage.getTextFromProjectPublicPrivacySpan(), "(" + project.getPrivacy() + ")");
        softAssert.assertAll();

        //Updating Project entity's id
        project.setId(currentUrl.substring(currentUrl.lastIndexOf('/') + 1));
        context.getProjectListToDelete().add(project);
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
        assertNotNull("The project: " + project.getName() + " is not present in the Project Summary.",
                projectsSummaryPage.isProjectInSummary(project.getName()));
    }

    /**
     * StepDef to open Project's Settings Page.
     */
    @When("I open the Project's Settings Page")
    public void iOpenTheProjectSSettingsPage() {
        projectSettingsPage = projectsSummaryPage.clickSettingsLinkOfProject(project);
    }

    /**
     * StepDef to verify all Project's creation data should be present in Project's Settings Page.
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
