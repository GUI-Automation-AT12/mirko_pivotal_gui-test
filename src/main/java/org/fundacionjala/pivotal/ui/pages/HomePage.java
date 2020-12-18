package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.pivotal.ui.component.TopMenu;
import org.fundacionjala.pivotal.ui.component.UserMenu;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".tc_pull_right:nth-child(3) .zWDds__Button")
    private WebElement userNameDropdownMenu;

    @FindBy(xpath = "//div[@class='Dropdown__options Dropdown__options--small']/div/div/a[1]")
    private WebElement profileLink;

    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;

    private TopMenu topMenu;

    public HomePage() {
        super();
        topMenu = new TopMenu();
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }

    private void clickUserNameDropdownMenu() {
        this.userNameDropdownMenu.click();
    }

    private void clickProfileLink() {
        this.profileLink.click();
    }

    private void clickCreateProjectBtn() {
        this.createProjectBtn.click();
    }

    public CreateProjectPopup goToProjectCreation() {
        clickCreateProjectBtn();
        return new CreateProjectPopup();
    }

    public UserMenu goToProfile() {
        clickUserNameDropdownMenu();
        clickProfileLink();
        return new UserMenu();
    }
}
