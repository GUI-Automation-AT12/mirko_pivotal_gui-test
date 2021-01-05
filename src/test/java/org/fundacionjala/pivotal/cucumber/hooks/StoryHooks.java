package org.fundacionjala.pivotal.cucumber.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.api.client.RequestManager;
import org.fundacionjala.pivotal.api.utils.EndpointProcessor;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.Story;

import java.net.MalformedURLException;

public class StoryHooks {
    private final Context context;

    /**
     * Adding Dependency injection to share Project Context information.
     * @param sharedContext
     */
    public StoryHooks(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * AfterHook that deletes created Story.
     */
    @After(value = "@deleteStory")
    public void deleteProject() throws MalformedURLException, PropertiesReadingException {
        for(Story story : context.getStoryToDelete()) {
            String resultEndpoint = EndpointProcessor.processEndpoint("2483434/stories/{storyId}", story.getId());
            RequestManager.delete(resultEndpoint);
        }
        WebDriverManager.getInstance().quit();
    }
}
