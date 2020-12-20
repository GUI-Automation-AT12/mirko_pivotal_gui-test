package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.ui.PageTransporter;

import java.net.MalformedURLException;

public class NavigationSteps {

    @When("^I navigate to (.*?) page$")
    public void navigateToPage(final String pageName) throws MalformedURLException {
        PageTransporter.navigateToPage(pageName);
    }
}
