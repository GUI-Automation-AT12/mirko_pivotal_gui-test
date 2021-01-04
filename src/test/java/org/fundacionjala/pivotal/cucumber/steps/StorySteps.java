package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.When;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.entities.Story;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;

import java.net.MalformedURLException;
import java.util.Map;

public class StorySteps {

    private ProjectPage projectPage;

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
        WebTransporter.navigateToPath("/n/projects/".concat(project.getId()));
        projectPage = new ProjectPage();
    }

    @When("I create a new Story in Backlog with the following info")
    public void createANewStoryInBacklogWithTheFollowingInfo(final Map<String, String> storyInfo) {
        //Updating Entity
        story = new Story(storyInfo.get("Name"));
        projectPage.createNewStoryInBacklog(story, project);
    }
}
