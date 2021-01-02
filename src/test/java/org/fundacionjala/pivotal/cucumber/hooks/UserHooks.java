package org.fundacionjala.pivotal.cucumber.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;

import java.net.MalformedURLException;

public class UserHooks {
    private final Context context;

    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedContext
     */
    public UserHooks(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * AfterHook that restore User information.
     */
    @After(value = "@restoreUserInformation")
    public void restoreUserInformation() throws MalformedURLException {
        for (String userAlias : context.getEditedUsersList()) {
            WebTransporter.navigateToPage("MY PROFILE");
            ProfilePage profilePage = new ProfilePage();
            User userToRestore = context.getUserByAlias(userAlias);
            profilePage.getEditProfileForm().editProfileInformation(userToRestore.getEditedFields(), userToRestore);
        }
        context.getEditedUsersList().clear();
        WebDriverManager.getInstance().quit();
    }
}
