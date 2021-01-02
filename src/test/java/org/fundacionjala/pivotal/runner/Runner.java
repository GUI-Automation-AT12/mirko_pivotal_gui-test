package org.fundacionjala.pivotal.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.core.config.PropertiesSetter;
import org.fundacionjala.core.config.TestExecutionProperties;
import org.fundacionjala.core.throwables.PropertiesReadingException;
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
     * Run code before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() throws PropertiesReadingException {
        PropertiesSetter.setDataProviderThreadCountProp(TestExecutionProperties.getInstance().getCucumberThreadCount());
        PropertiesSetter.setTestBrowser(TestExecutionProperties.getInstance().getTestBrowser());
    }
}
