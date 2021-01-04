package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.api.client.RequestManager;
import org.fundacionjala.pivotal.api.utils.EndpointProcessor;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.entities.Story;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class StorySteps {

    private ProjectPage projectPage;
    private Response response;

    //Entity
    private Story story;
    private Project project;

    //Context
    private final Context context;

    /**
     * Adds Dependency injection to share Context information.
     * @param sharedContext
     */
    public StorySteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Drives to a Project's Page providing its name.
     * @param projectName of the project
     * @throws MalformedURLException
     * @throws PropertiesReadingException
     */
    @When("^I go to Project Page of (.*?)$")
    public void goToProjectPageOfAProject(final String projectName) throws MalformedURLException, PropertiesReadingException {
        project = context.getProjectByName(projectName);
        WebTransporter.navigateToPath("n/projects/".concat(project.getId()));
        projectPage = new ProjectPage();
    }

    /**
     * Creates a New Story from UI and updates Story Entity data.
     * @param storyInfo
     */
    @When("I create a new Story in Backlog with the following info")
    public void createANewStoryInBacklogWithTheFollowingInfo(final Map<String, String> storyInfo) {
        //Updating Entity
        story = new Story(storyInfo.get("Name"));

        //Creating Story from UI
        projectPage.createNewStoryInBacklog(story, project);

        //Updating Story Entity's Id
        story.setId(projectPage.getStoryIdFromBacklogPanel(story.getName(), project.getId()));
    }

    /**
     * Sends a Get request by API to a defined endpoint.
     * @param endpoint to send request
     */
    @When("I send a GET API request to {string}")
    public void useTheAPIToGetTheStoriesInBacklog(final String endpoint) {
        String resultEndpoint = EndpointProcessor.processEndpoint(endpoint, project.getId());
        response = RequestManager.get(resultEndpoint);
    }

    /**
     * Verify that the Story is contained in the API response.
     */
    @Then("the Story should be in {string} list in the response")
    public void verifyStoryIsInTheResponse(final String listName) {
        String listedStories = response.jsonPath().getString(listName + ".story_id");
        System.out.println(story.getId());
        assertTrue("The story is not contained in the response.", listedStories.contains(story.getId()));
    }

    /**
     * Drags a Story from the Backlog and drops to Icebox.
     */
    @When("I do a drag and drop of the Story from Backlog to Icebox")
    public void doADragAndDropOfTheStoryFromBacklogToIcebox() {
        projectPage.dragAndDropAStoryFromBacklogToIcebox(story.getId());
    }

    /**
     * Verify that the Story is not contained in the API response.
     */
    @Then("the Story should not be in {string} list in the response")
    public void verifyStoryIsNotInTheResponse(final String listName) {
        String listedStories = response.jsonPath().getString(listName + ".story_id");
        assertFalse("The story is not contained in the response.", listedStories.contains(story.getId()));
    }
}
