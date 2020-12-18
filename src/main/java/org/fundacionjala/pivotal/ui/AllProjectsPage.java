package org.fundacionjala.pivotal.ui;

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

    public String getFirstListedProject () {
        return this.firstListedProject.getText();
    }

    public ProjectSettingsPage goToFirstProjectSettings() {
        clickFirstProjectSettingsLink();
        return new ProjectSettingsPage();
    }
}
