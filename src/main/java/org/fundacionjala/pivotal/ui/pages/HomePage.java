package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']/div/div/a[1]")
    private WebElement profileLink;

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    private void clickUserNameDropdownMenu() {
        GuiInteractioner.clickWebElement(userNameDropdownMenu);
    }

    private void clickProfileLink() {
        GuiInteractioner.clickWebElement(profileLink);
    }

    private void clickCreateProjectBtn() {
        GuiInteractioner.clickWebElement(createProjectBtn);
    }

    /**
     * Allows to go to Project Creation Page from GUI.
     * @return CreateProjectPage;
     */
    public CreateProjectPage goToProjectCreation() {
        clickCreateProjectBtn();
        return new CreateProjectPage();
    }

    /**
     * Allows to go to Profile Page from GUI.
     * @return a new ProfilePage.
     */
    public ProfilePage goToProfile() {
        clickUserNameDropdownMenu();
        clickProfileLink();
        return new ProfilePage();
    }
}
