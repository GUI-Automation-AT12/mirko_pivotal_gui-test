package org.fundacionjala.core.selenium.browsers.browserTypes;

import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser implements IBrowser {

    /**
     * Initializes Edge driver.
     */
    @Override
    public WebDriver initDriver() {
        EdgeDriverManager.getInstance(EDGE).version("87.0.664.66").setup();
        return new EdgeDriver();
    }
}
