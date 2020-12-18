package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']/div/div/a[1]")
    private WebElement profileLink;

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    private void clickUserNameDropdownMenu() {
        this.userNameDropdownMenu.click();
    }

    private void clickProfileLink() {
        this.profileLink.click();
    }

    private void clickCreateProjectBtn() {
        this.createProjectBtn.click();
    }

    public CreateProjectPage goToProjectCreation() {
        clickCreateProjectBtn();
        return new CreateProjectPage();
    }

    public ProfilePage goToProfile() {
        clickUserNameDropdownMenu();
        clickProfileLink();
        return new ProfilePage();
    }
}
