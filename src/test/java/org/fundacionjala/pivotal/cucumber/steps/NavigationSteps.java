package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.ui.WebTransporter;
import java.net.MalformedURLException;

public class NavigationSteps {

    /**
     * Define the browser to start running the test scenario.
     * @param browserName
     */
    @Given("^I open (.*?) web browser$")
    public void openTheWebBrowser(final String browserName) {
        WebDriverManager.setBrowserName(browserName.toLowerCase());
    }

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
