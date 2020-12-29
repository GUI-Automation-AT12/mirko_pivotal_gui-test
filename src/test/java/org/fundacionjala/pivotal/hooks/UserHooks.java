package org.fundacionjala.pivotal.hooks;

import io.cucumber.java.After;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.context.UserContext;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;

import java.net.MalformedURLException;

public class UserHooks {
    private final UserContext userContext;

    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedUserContext
     */
    public UserHooks(final UserContext sharedUserContext) {
        this.userContext = sharedUserContext;
    }

    /**
     * AfterHook that restore User information.
     */
    @After(value = "@restoreUserInformation")
    public void restoreUserInformation() throws MalformedURLException {
        for (String userAlias : userContext.getEditedUsersList()) {
            WebTransporter.navigateToPage("MY PROFILE");
            ProfilePage profilePage = new ProfilePage();
            User userToRestore = userContext.getUserByAlias(userAlias);
            profilePage.getEditProfileForm().editProfileInformation(userToRestore.getEditedFields(), userToRestore);
        }
        userContext.getEditedUsersList().clear();
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
