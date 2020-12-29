package org.fundacionjala.core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

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
        WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
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

    /**
     * Searches for an specific option in a list, then clicks it.
     * @param options
     * @param selected
     */
    public static void clickOptionFromWebElementList(final List<WebElement> options, final String selected) {
        for (WebElement option : options) {
            if (option.getText().contains(selected)) {
                option.click();
                break;
            }
        }
    }

    /**
     * Searches for an specific option WebElement that contains a text.
     * @param webElementList
     * @param text
     * @return WebElement if it can find it, otherwise return null
     */
    public static WebElement searchTextInWebElementList(final List<WebElement> webElementList, final String text) {
        for (WebElement element : webElementList) {
            if (element.getText().contains(text)) {
                return element;
            }
        }
        return null;
    }
}
