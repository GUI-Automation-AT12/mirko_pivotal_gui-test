package org.fundacionjala.core.selenium;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BrowserParser {
    private static Map<String, Browser> browserMap;
    private static final String JSON_FILE_PATH =
            "src/main/java/org/fundacionjala/core/config/JsonFiles/DriverProperties.json";

    private BrowserParser() {
    }

    private static List<Browser> getBrowsersListFromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                new File(JSON_FILE_PATH), new TypeReference<>() { });
    }

    /**
     * Get a Map of Browsers' Properties from json file.
     * @return browserList
     */
    public static Map<String, Browser> getBrowsersMap() throws IOException {
        if (browserMap == null) {
            browserMap =  new HashMap<>();
            for (Browser browser: getBrowsersListFromJson()) {
                System.out.println(browser.toString());
                browserMap.put(browser.getName(), browser);
            }
        }
        return browserMap;
    }
}
