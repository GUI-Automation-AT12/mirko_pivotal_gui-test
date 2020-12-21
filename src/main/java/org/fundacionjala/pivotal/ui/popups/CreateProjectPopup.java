package org.fundacionjala.pivotal.ui.popups;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;

public class CreateProjectPopup extends BasePage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextBox;

    @FindBy(css = ".tc-account-selector")
    private WebElement accountDropdownList;

    @FindBy(css = ".tc-account-selector__option-account:nth-child(1) .tc-account-selector__option-account-name")
    private WebElement account1Option;

    @FindBy(css = ".tc-project-type-chooser__label:nth-child(3) > .tc-project-type-chooser__label-name")
    private WebElement publicProjectType;

    @FindBy(css = ".pvXpn__Button--positive")
    private WebElement createBtn;

    private void fillProjectNameTextBox(final String projectName) {
        GuiInteractioner.fillWebElement(projectNameTextBox, projectName);
    }

    private void clickAccountDropdownList() {
        GuiInteractioner.clickWebElement(accountDropdownList);
    }

    private void clickAccount1Option() {
        GuiInteractioner.clickWebElement(account1Option);
    }

    private void clickCreateBtn() {
        GuiInteractioner.clickWebElement(createBtn);
    }

    /**
     * Creates a project from GUI.
     * @param projectName
     * @return a new ProjectPage.
     */
    public ProjectPage createProject(final String projectName) {
        fillProjectNameTextBox(projectName);
        clickAccountDropdownList();
        clickAccount1Option();
        clickCreateBtn();
        return new ProjectPage();
    }
}
