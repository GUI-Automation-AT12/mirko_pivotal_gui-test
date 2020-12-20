package org.fundacionjala.pivotal.ui;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.config.PivotalProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class WebTransporter {

    private static final HashMap<String, String> PAGE_URL = new HashMap<>();

    private WebTransporter() {
    }

    static {
        PAGE_URL.put("MY PROFILE", "profile");
        PAGE_URL.put("ACCOUNTS", "accounts");
        PAGE_URL.put("NOTIFICATION SETTINGS", "notification_settings");
        PAGE_URL.put("SECURITY", "security_settings");
    }

    /**
     * Navigates to a feature from the base URL of Pivotal referencing the name of a specific feature.
     * @param pageName
     * @throws MalformedURLException
     */
    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(PivotalProperties.getInstance().getBaseUrl().concat("/" + PAGE_URL.get(pageName.toUpperCase())));
    }

    /**
     * Navigates to initial page of Pivotal Tracker website.
     * @throws MalformedURLException
     */
    public static void navigateToPage() throws MalformedURLException {
        navigateToUrl(PivotalProperties.getInstance().getBaseUrl());
    }

    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }
}
