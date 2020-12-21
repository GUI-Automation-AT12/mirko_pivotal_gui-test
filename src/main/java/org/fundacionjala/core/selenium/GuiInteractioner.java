package org.fundacionjala.core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class GuiInteractioner {

    private GuiInteractioner() {
    }

    private static WebElement getWebElementFormBy(final By by) {
        return WebDriverManager.getInstance().getWebDriver().findElement(by);
    }

    /**
     * Clears the previous text in a WebElement and fills a new text into it.
     * @param webElement
     * @param text
     */
    public static void fillWebElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Provide fillWebElement method to support By objects.
     * @param by
     * @param text
     */
    public static void fillWebElement(final By by, final String text) {
        fillWebElement(getWebElementFormBy(by), text);
    }

    /**
     * Waits for a WebElement to be clickable and clicks it.
     * @param webElement
     */
    public static void clickWebElement(final WebElement webElement) {
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Provide clickWebElement method to support By objects.
     * @param by
     */
    public static void clickWebElement(final By by) {
        clickWebElement(getWebElementFormBy(by));
    }

    /**
     * Searches for a WebElement and get the inner text.
     * @param webElement
     * @return String text from the WebElement.
     */
    public static String getTextFromWebElement(final WebElement webElement) {
        return webElement.getText();
    }

    /**
     * Provide getTextFromWebElement method to support By objects.
     * @param by
     * @return String text from the By.
     */
    public static String getTextFromWebElement(final By by) {
        return getTextFromWebElement(getWebElementFormBy(by));
    }
}
