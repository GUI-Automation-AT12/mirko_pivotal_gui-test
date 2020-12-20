package org.fundacionjala.pivotal.ui;

import org.fundacionjala.core.config.Environment;
import org.fundacionjala.core.selenium.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class PageTransporter {

    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {

        // User Profile
        PAGE_URL.put("MY PROFILE", "profile");
        PAGE_URL.put("ACCOUNTS", "accounts");
        PAGE_URL.put("NOTIFICATION SETTINGS", "notification_settings");
        PAGE_URL.put("SECURITY", "security_settings");
    }

    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(Environment.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName.toUpperCase())));
    }

    private static void navigateToUrl(String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }
}
