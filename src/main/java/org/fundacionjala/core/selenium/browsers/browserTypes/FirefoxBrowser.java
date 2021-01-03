package org.fundacionjala.core.selenium.browsers.browserTypes;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements IBrowser {

    /**
     * Initializes Firefox driver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("73.0.1").setup();
        return new FirefoxDriver();
    }
}
