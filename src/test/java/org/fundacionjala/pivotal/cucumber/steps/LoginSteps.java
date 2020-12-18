package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Given;
import org.fundacionjala.core.config.Environment;
import org.fundacionjala.pivotal.ui.pages.HomePage;
import org.fundacionjala.pivotal.ui.pages.InitialPage;
import org.fundacionjala.pivotal.ui.pages.LoginStep1Page;
import org.fundacionjala.pivotal.ui.pages.LoginStep2Page;

public class LoginSteps {

    // Pages
    private InitialPage initialPage;
    private LoginStep1Page loginStep1Page;
    private LoginStep2Page loginStep2Page;
    private HomePage homePage;

    @Given("^I log in to Pivotal with (.*?) credentials$")
    public void logInToPivotal(final String userAlias) {
        initialPage = new InitialPage();
        initialPage.goToUrl(Environment.getInstance().getBaseUrl());
        loginStep1Page = initialPage.goToLoginStep1();
        loginStep2Page = loginStep1Page.goToLoginStep2(Environment.getInstance().getUserEmail());
        homePage = loginStep2Page.signIn(Environment.getInstance().getUserPassword());
    }
}
