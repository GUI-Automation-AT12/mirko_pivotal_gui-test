package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllProjectsPage extends BasePage {

    @FindBy(xpath = "//div[@class='projects column'][1]/a")
    private WebElement firstListedProject;

    @FindBy(xpath = "//div[@class='settings column'][1]/a")
    private WebElement firstProjectSettingsLink;

    protected AllProjectsPage (final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    private void clickFirstProjectSettingsLink() {
        this.firstProjectSettingsLink.click();

    }

    public String getFirstListedProject () {
        return this.firstListedProject.getText();
    }

    public ProjectSettingsPage goToFirstProjectSettings() {
        clickFirstProjectSettingsLink();
        return new ProjectSettingsPage(super.webDriver, super.webDriverWait);
    }
}
