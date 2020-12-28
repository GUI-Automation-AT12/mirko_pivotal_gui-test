package org.fundacionjala.core.selenium.webDrivers;

import static io.github.bonigarcia.wdm.DriverManagerType.FIREFOX;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.fundacionjala.core.utils.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Map;

public class FirefoxBrowser implements IBrowser {

    private Map driverProps;

    /**
     * Initializes Firefox driver.
     * @return A new geckodriver.
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(FIREFOX).version("73.0.1").setup();
        for (Map driverMap : JsonParser.getDriverPropsFromJsonArray()) {
            if ("firefox".equals(driverMap.get("name"))) {
                driverProps = driverMap;
                return new FirefoxDriver();
            }
        }
        return new FirefoxDriver();
    }

    /**
     * Get a Map that contains the Properties for the Firefox Driver Browser.
     * @return driverProps
     */
    @Override
    public Map getDriverProps() {
        return driverProps;
    }
}
