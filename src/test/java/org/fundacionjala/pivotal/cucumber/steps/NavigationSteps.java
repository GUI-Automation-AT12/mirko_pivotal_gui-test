package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.ui.WebTransporter;
import java.net.MalformedURLException;

public class NavigationSteps {

    /**
     * StepDef to navigate towards any URL.
     * @param pageName
     * @throws MalformedURLException
     */
    @When("^I navigate to (.*?) page$")
    public void navigateToPage(final String pageName) throws MalformedURLException {
        WebTransporter.navigateToPage(pageName);
    }

    /**
     * StepDef to reload the browser.
     */
    @When("I reload the page")
    public void reloadPage() {
        WebTransporter.reloadPage();
    }
}
