package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.When;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.ui.WebTransporter;
import java.net.MalformedURLException;

public class NavigationSteps {

    /**
     * Navigates towards any URL.
     * @param pageName
     * @throws MalformedURLException
     */
    @When("^I navigate to (.*?) page$")
    public void navigateToPage(final String pageName) throws MalformedURLException, PropertiesReadingException {
        WebTransporter.navigateToPage(pageName);
    }

    /**
     * Reloads the browser.
     */
    @When("I reload the page")
    public void reloadPage() {
        WebTransporter.reloadPage();
    }
}
