package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsSummaryPage extends BaseLoggedInPage {

    @FindBy(xpath = "//div[@class='projects column'][1]/a")
    private WebElement firstListedProject;

    @FindBy(xpath = "//div[@class='settings column'][1]/a")
    private WebElement firstProjectSettingsLink;

    private void clickFirstProjectSettingsLink() {
        GuiInteractioner.clickWebElement(firstProjectSettingsLink);
    }

    /**
     * First project listed in the All Projects Page.
     * @return first listed project's name.
     */
    public String getFirstListedProject() {
        return GuiInteractioner.getTextFromWebElement(firstListedProject);
    }

    /**
     * Allow to drives the user to Project Settings Page.
     * @return ProjectSettingsPage
     */
    public ProjectSettingsPage goToFirstProjectSettings() {
        clickFirstProjectSettingsLink();
        return new ProjectSettingsPage();
    }
}
