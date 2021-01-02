package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep2Page;

import java.net.MalformedURLException;

public class LoginSteps {

    //dependency injection
    private Context context;

    // Pages
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;

    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedContext
     */
    public LoginSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * StepDef to log in a user.
     * @param userAlias
     * @throws MalformedURLException
     */
    @Given("^I log in to Pivotal with (.*?) credentials$")
    public void logInToPivotal(final String userAlias) throws MalformedURLException, PropertiesReadingException {
        //Select the User Entity to get credentials
        User user = context.getUserByAlias(userAlias);

        WebTransporter.navigateToPage("SIGN IN STEP ONE");
        loginStep1Page = new LoginStep1Page();
        loginStep2Page = loginStep1Page.goToLoginStep2(user.getEmail());
        loginStep2Page.signIn(user.getPassword());
    }
}
