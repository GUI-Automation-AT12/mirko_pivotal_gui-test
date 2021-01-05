package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.core.config.PropertiesSetter;
import org.fundacionjala.core.config.TestExecutionProperties;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.api.client.RequestManager;
import org.fundacionjala.pivotal.api.utils.ApiAuthentication;
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
     * Adds Dependency injection to share Context information.
     * @param sharedContext
     */
    public LoginSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Logs a user in Pivotal Tracker.
     * @param userAlias
     * @throws MalformedURLException
     */
    @Given("^I log in to Pivotal with (.*?) credentials$")
    public void logInToPivotal(final String userAlias) throws MalformedURLException, PropertiesReadingException {

        PropertiesSetter.setDataProviderThreadCountProp(TestExecutionProperties.getInstance().getCucumberThreadCount());
        PropertiesSetter.setTestBrowser(TestExecutionProperties.getInstance().getTestBrowser());

        //Select the User Entity to get credentials
        User user = context.getUserByAlias(userAlias);

        //Set User Authentication to use Pivotal API in the next steps
        RequestManager.setRequestSpec(ApiAuthentication.getLoggedReqSpec(user));

        WebTransporter.navigateToPage("SIGN IN STEP ONE");
        loginStep1Page = new LoginStep1Page();
        loginStep2Page = loginStep1Page.goToLoginStep2(user.getEmail());
        loginStep2Page.signIn(user.getPassword());
    }
}
