package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BaseLoggedInPage {

    private static final int SLEEPING_TIME = 5000;

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projectDropdownList;

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement projectsSummaryLink;

     @FindBy(css = ".raw_context_name.public")
     private WebElement projectNameSpan;

     @FindBy(css = ".public_project_label")
     private WebElement projectPublicPrivacySpan;

    private void sleepToShowPage() {
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clickProjectDropdownList() {
        GuiInteractioner.clickWebElement(projectDropdownList);
    }

    private void clickProjectsSummaryLink() {
        GuiInteractioner.clickWebElement(projectsSummaryLink);
    }

    /**
     * Get inner text from Project Name Span.
     * @return text from Project Name Span
     */
    public String getTextFromProjectNameSpan() {
        return GuiInteractioner.getTextFromWebElement(projectNameSpan);
    }

    /**
     * Get inner text from Project Public Privacy Span.
     * @return text from Project Public Privacy Span
     */
    public String getTextFromProjectPublicPrivacySpan() {
        return GuiInteractioner.getTextFromWebElement(projectPublicPrivacySpan);
    }

    /**
     * Drives to a Page of All Projects.
     * @return a new ProjectsSummaryPage.
     */
    public ProjectsSummaryPage goToProjectsList() {
        sleepToShowPage();
        clickProjectDropdownList();
        clickProjectsSummaryLink();
        return new ProjectsSummaryPage();
    }
}
