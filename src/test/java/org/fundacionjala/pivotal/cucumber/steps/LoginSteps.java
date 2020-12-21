package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.pivotal.config.PivotalProperties;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.DashboardPage;
import org.fundacionjala.pivotal.ui.pages.LogedOut.InitialPage;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LogedOut.LoginStep2Page;

import java.net.MalformedURLException;

public class LoginSteps {

    // Pages
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;

    /**
     * StepDef to log in a user.
     * @param userAlias
     * @throws MalformedURLException
     */
    @Given("^I log in to Pivotal with (.*?) credentials$")
    public void logInToPivotal(final String userAlias) throws MalformedURLException {
        initialPage = new InitialPage();
        WebTransporter.navigateToPage();
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(PivotalProperties.getInstance().getUserEmail());
        loginStep2Page.signIn(PivotalProperties.getInstance().getUserPassword());
    }
}
