package org.fundacionjala.pivotal.ui;

import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.core.throwables.PropertiesReadingException;
import org.fundacionjala.pivotal.config.PivotalProperties;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class WebTransporter {

    private WebTransporter() {
    }

    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        PAGE_URL.put("MY PROFILE", "profile");
        PAGE_URL.put("ACCOUNTS", "accounts");
        PAGE_URL.put("NOTIFICATION SETTINGS", "notification_settings");
        PAGE_URL.put("SECURITY", "security_settings");
        PAGE_URL.put("SIGN IN STEP ONE", "signin");
    }

    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }

    /**
     * Navigates to a feature from the base URL of Pivotal referencing the name of a specific feature.
     * @param pageName
     * @throws MalformedURLException
     */
    public static void navigateToPage(final String pageName) throws MalformedURLException, PropertiesReadingException {
        navigateToUrl(PivotalProperties.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName.toUpperCase())));
    }

    /**
     * Navigates to initial page of Pivotal Tracker website.
     * @throws MalformedURLException
     */
    public static void navigateToPage() throws MalformedURLException, PropertiesReadingException {
        navigateToUrl(PivotalProperties.getInstance().getBaseUrl());
    }

    /**
     * Navigates to a specific path from Base Url of pivotal.
     * @param path
     * @throws MalformedURLException
     */
    public static void navigateToPath(final String path) throws MalformedURLException, PropertiesReadingException {
        navigateToUrl((PivotalProperties.getInstance().getBaseUrl().concat(path)));
    }

    /**
     * Allows to reload the actual page.
     */
    public static void reloadPage() {
        WebDriverManager.getInstance().getWebDriver().navigate().refresh();
    }

    /**
     * Get the current Url of the webDriver.
     * @return Current Url
     */
    public static String getCurrentUrl() {
        return WebDriverManager.getInstance().getWebDriver().getCurrentUrl();
    }
}
