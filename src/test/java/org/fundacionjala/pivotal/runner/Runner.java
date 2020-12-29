package org.fundacionjala.pivotal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.core.config.EnvironmentProperties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/"},
        glue = {"org.fundacionjala.pivotal.cucumber"}
)

public final class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Sets dataproviderthreadcount property before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() {
        System.setProperty("dataproviderthreadcount", EnvironmentProperties.getInstance().getCucumberThreadCount());
    }
}
