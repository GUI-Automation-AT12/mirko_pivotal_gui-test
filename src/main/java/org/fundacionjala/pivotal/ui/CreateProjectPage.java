package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProjectPage extends BasePage{

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
        this.projectNameTextBox.clear();
        this.projectNameTextBox.sendKeys(projectName);
    }

    private void clickAccountDropdownList() {
        this.accountDropdownList.click();
    }

    private void clickAccount1Option() {
        this.account1Option.click();
    }

    private void clickCreateBtn() {
        this.createBtn.click();
    }

    public ProjectPage createProject(final String projectName) {
        fillProjectNameTextBox(projectName);
        clickAccountDropdownList();
        clickAccount1Option();
        clickCreateBtn();
        return new ProjectPage();
    }
}
