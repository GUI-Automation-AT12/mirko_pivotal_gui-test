package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.fundacionjala.pivotal.entities.Project;
import org.fundacionjala.pivotal.entities.Story;
import org.fundacionjala.pivotal.ui.WebTransporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProjectPage extends BaseLoggedInPage {

    @FindBy(css = ".tc_projects_dropdown_link.tc_context_name")
    private WebElement projectDropdownList;

    @FindBy(css = ".tc_projects_menu_show_all")
    private WebElement projectsSummaryLink;

     @FindBy(css = ".raw_context_name.public")
     private WebElement projectNameSpan;

     @FindBy(css = ".public_project_label")
     private WebElement projectPublicPrivacySpan;

     @FindBy(css = ".autosaves.id.text_value")
     private WebElement storyIdTextBox;

     @FindBy(css = ".autosaves.button.std.close")
     private WebElement storyCollapseBtn;

     @FindBy(css = "#panel_icebox_2483434 section")
     private WebElement iceboxPanel;

     private By backlogAddStoryBtn;

     private By backlogNewStoryNameTextBox;

     private By backlogSaveNewStoryBtn;

     private List<WebElement> backlogStoriesList;

     private By selectedStory;

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

    private void clickProjectDropdownList() {
        GuiInteractioner.clickWebElement(projectDropdownList);
    }

    private void clickProjectsSummaryLink() {
        GuiInteractioner.clickWebElement(projectsSummaryLink);
    }

    /**
     * Drives to a Page of All Projects.
     * @return a new ProjectsSummaryPage.
     */
    public ProjectsSummaryPage goToProjectsList() {
        clickProjectDropdownList();
        clickProjectsSummaryLink();
        return new ProjectsSummaryPage();
    }

    /**
     * Gets the Project Id from the Url of the Project Page.
     * @return id extract from the Url
     */
    public String getIdFromUrl() {
        String url = WebTransporter.getCurrentUrl();
        return url.substring(url.lastIndexOf('/') + 1);
    }

    private void clickBacklogAddStoryBtn(final String projectId) {
        backlogAddStoryBtn = By
                .cssSelector("div#panel_backlog_" + projectId +" div header div button span.MuiButton-label.jss9");
        GuiInteractioner.clickWebElement(backlogAddStoryBtn);
    }

    private void fillBacklogNewStoryNameTextBox(final String storyName, final String projectId) {
        backlogNewStoryNameTextBox = By
                .cssSelector("div#panel_backlog_" + projectId + " div div div div section.edit section fieldset textarea.AutosizeTextarea__textarea___1LL2IPEy.NameEdit___2W_xAa_R");
        GuiInteractioner.setInputText(backlogNewStoryNameTextBox, storyName);
    }

    private void clickBacklogSaveNewStoryBtn(final String projectId) {
        backlogSaveNewStoryBtn = By
                .cssSelector("div#panel_backlog_" + projectId + " div section div div div div div section form aside div nav section div button.autosaves.button.std.save");
        GuiInteractioner.clickWebElement(backlogSaveNewStoryBtn);
    }

    /**
     * Creates a new Story in Backlog panel from UI.
     * @param story story to create
     * @param project project that will contains the new story
     */
    public void createNewStoryInBacklog(final Story story, final Project project) {
        clickBacklogAddStoryBtn(project.getId());
        fillBacklogNewStoryNameTextBox(story.getName(), project.getId());
        clickBacklogSaveNewStoryBtn(project.getId());
    }

    private WebElement searchStoryInBacklogStoriesList(final String storyName, final String projectId) {
        backlogStoriesList = WebDriverManager.getInstance().getWebDriver().findElements(By
                .cssSelector("div#panel_backlog_" + projectId + " div section div div header span span span.tracker_markup"));
        return GuiInteractioner.searchTextInWebElementList(backlogStoriesList, storyName);
    }

    private void clickStoryInBacklogStoryList(final String storyName, final String projectId) {
        WebElement selectedStory = searchStoryInBacklogStoriesList(storyName, projectId);
        GuiInteractioner.clickWebElement(selectedStory);
    }

    private void clickStoryCollapseBtn() {
        GuiInteractioner.clickWebElement(storyCollapseBtn);
    }

    /**
     * Gets a story Id from Story Id Text Box.
     * @param storyName name of the story
     * @param projectId id of the project that contains the story
     * @return storyId
     */
    public String getStoryIdFromBacklogPanel(final String storyName, final String projectId) {
        clickStoryInBacklogStoryList(storyName, projectId);
        String storyId = GuiInteractioner.getAttributeOfWebElement(storyIdTextBox, "value");
        storyId = storyId.substring(1);
        clickStoryCollapseBtn();
        return storyId;
    }

    /**
     * Drags a Story in Backlog panel and drops it to Icebox panel.
     * @param storyId
     */
    public void dragAndDropAStoryFromBacklogToIcebox(final String storyId) {
        selectedStory = By.cssSelector("div[data-id='" + storyId + "']");
        GuiInteractioner.dragElementAndDropTo(selectedStory, iceboxPanel);
    }
}