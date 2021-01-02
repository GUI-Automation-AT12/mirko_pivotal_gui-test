package org.fundacionjala.core.selenium.browsers.browserTypes;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements IBrowser {

    /**
     * Initializes Chrome driver.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        return new ChromeDriver();
    }
}
