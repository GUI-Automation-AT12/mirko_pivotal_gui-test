package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends BaseLoggedInPage {

    @FindBy(id = "delete_link")
    private WebElement deleteProjectLink;

    @FindBy(id = "confirm_delete")
    private WebElement deleteProjectBtn;

    @FindBy(css = "#project_name")
    private WebElement projectNameTextBox;

    @FindBy(css = "#project_account b a")
    private WebElement projectAccountLink;

    @FindBy(id = "project_public")
    private WebElement projectPrivacyCheckbox;

    private void scrollDownToFindDeleteProjectLink() {
        GuiInteractioner.scrollDownToFindElement(deleteProjectLink);
    }

    private void clickDeleteLink() {
        GuiInteractioner.clickWebElement(deleteProjectLink);
    }

    private void clickDeleteBtn() {
        GuiInteractioner.clickWebElement(deleteProjectBtn);
    }

    /**
     * Allows the user to delete a project from GUI.
     */
    public void deleteProject() {
        scrollDownToFindDeleteProjectLink();
        clickDeleteLink();
        clickDeleteBtn();
    }

    private String getTextFrom(final WebElement webElement) {
        return GuiInteractioner.getTextFromWebElement(webElement);
    }

    /**
     * Gets inner text of Project Name Text Box.
     * @return the value of 'value' attribute from Project Name Text Box
     */
    public String getValueAttributeFromProjectNameTextBox() {
        return GuiInteractioner.getAttributeOfWebElement(projectNameTextBox, "value");
    }

    /**
     * Gets inner text of Project Account Link.
     * @return the text of Project Account Link
     */
    public String getTextProjectAccountLink() {
        return getTextFrom(projectAccountLink);
    }

    /**
     * Gets inner text of Project Privacy CheckBox.
     * @return true if Project Privacy Checkbox status is selected, otherwise return false
     */
    public boolean getStatusOfProjectPrivacyCheckbox() {
        return GuiInteractioner.getStateOfWebElement(projectPrivacyCheckbox);
    }
}
