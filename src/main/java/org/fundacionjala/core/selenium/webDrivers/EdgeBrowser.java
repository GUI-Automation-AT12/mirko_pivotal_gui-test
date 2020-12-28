package org.fundacionjala.core.selenium.webDrivers;

import static io.github.bonigarcia.wdm.DriverManagerType.EDGE;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.fundacionjala.core.utils.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Map;

public class EdgeBrowser implements IBrowser {

    private Map driverProps;

    /**
     * Initializes Edge driver.
     * @return A new edgeDriver.
     */
    @Override
    public WebDriver initDriver() {
        EdgeDriverManager.getInstance(EDGE).version("87.0.664.66").setup();
        for (Map driverMap : JsonParser.getDriverPropsFromJsonArray()) {
            if ("edge".equals(driverMap.get("name"))) {
                driverProps = driverMap;
                return new EdgeDriver();
            }
        }
        return new EdgeDriver();
    }

    /**
     * Get a Map that contains the Properties for the Edge Driver Browser.
     * @return driverProps
     */
    @Override
    public Map getDriverProps() {
        return driverProps;
    }
}
