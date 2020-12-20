package org.fundacionjala.pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjectsPage extends BasePage {

    @FindBy(xpath = "//div[@class='projects column'][1]/a")
    private WebElement firstListedProject;

    @FindBy(xpath = "//div[@class='settings column'][1]/a")
    private WebElement firstProjectSettingsLink;

    private void clickFirstProjectSettingsLink() {
        this.firstProjectSettingsLink.click();
    }

    /**
     * Method that searches for the first element of the list of projects and return its name.
     * @return the text of firstListedProject.
     */
    public String getFirstListedProject() {
        return this.firstListedProject.getText();
    }

    /**
     * Method to click the settings link of the first listed project.
     * @return a new ProjectSettingsPage.
     */
    public ProjectSettingsPage goToFirstProjectSettings() {
        clickFirstProjectSettingsLink();
        return new ProjectSettingsPage();
    }
}
