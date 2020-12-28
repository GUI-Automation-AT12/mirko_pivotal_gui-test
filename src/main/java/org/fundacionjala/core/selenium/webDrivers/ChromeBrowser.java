package org.fundacionjala.core.selenium.webDrivers;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.fundacionjala.core.utils.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class ChromeBrowser implements IBrowser {

    private Map driverProps;

    /**
     * Initializes Chrome driver.
     * @return A new edgeDriver.
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("87.0.4280.88").setup();
        for (Map driverMap : JsonParser.getDriverPropsFromJsonArray()) {
            if ("chrome".equals(driverMap.get("name"))) {
                driverProps = driverMap;
                return new ChromeDriver();
            }
        }
        return new ChromeDriver();
    }

    /**
     * Get a Map that contains the Properties for the Chrome Driver Browser.
     * @return driverProps
     */
    @Override
    public Map getDriverProps() {
        return driverProps;
    }
}
