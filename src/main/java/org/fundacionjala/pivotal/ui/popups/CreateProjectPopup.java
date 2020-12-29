package org.fundacionjala.pivotal.ui.popups;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProjectPage;

public class CreateProjectPopup extends BasePage {

    @FindBy(name = "project_name")
    private WebElement projectNameTextBox;

    @FindBy(css = ".tc-account-selector")
    private WebElement accountDropdownList;

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

    private void selectAccountOption(final String account) {
        GuiInteractioner.clickOptionFromWebElementList(
                accountDropdownList.findElements(By.className("tc-account-selector__option-account")), account);
    }

    private void clickPublicProjectType() {
        GuiInteractioner.clickWebElement(publicProjectType);
    }

    private void clickCreateBtn() {
        GuiInteractioner.clickWebElement(createBtn);
    }

    /**
     * Creates a public project from GUI.
     * @param projectName
     * @param account
     * @return a new ProjectPage.
     */
    public ProjectPage createPublicProject(final String projectName, final String account) {
        fillProjectNameTextBox(projectName);
        clickAccountDropdownList();
        selectAccountOption(account);
        clickPublicProjectType();
        clickCreateBtn();
        return new ProjectPage();
    }
}
