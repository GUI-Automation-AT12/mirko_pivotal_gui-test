package org.fundacionjala.pivotal.ui.pages.LoggedIn;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.ui.popups.CreateProjectPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BaseLoggedInPage {


    @FindBy(id = "create-project-button")
    private WebElement createProjectBtn;



    private void clickCreateProjectBtn() {
        GuiInteractioner.clickWebElement(createProjectBtn);
    }

    /**
     * Allows user to drive to Project Creation PopUp.
     * @return CreateProjectPopup
     */
    public CreateProjectPopup goToProjectCreation() {
        clickCreateProjectBtn();
        return new CreateProjectPopup();
    }
}
