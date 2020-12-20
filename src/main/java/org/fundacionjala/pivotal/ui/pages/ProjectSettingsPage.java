package org.fundacionjala.pivotal.ui.pages;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.core.selenium.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends BasePage {

    @FindBy(id = "delete_link")
    private WebElement deleteProjectLink;

    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteProjectBtn;

    private void scrollDownToFindDeleteProjectLink() {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverManager.getInstance().getWebDriver();
        js.executeScript("arguments[0].scrollIntoView();", this.deleteProjectLink);
    }

    private void clickDeleteLink() {
        GuiInteractioner.clickWebElement(deleteProjectLink);
    }

    private void clickConfirmDeleteBtn() {
        GuiInteractioner.clickWebElement(this.confirmDeleteProjectBtn);
    }

    /**
     * Deletes a project from GUI.
     */
    public void deleteProject() {
        scrollDownToFindDeleteProjectLink();
        clickDeleteLink();
        clickConfirmDeleteBtn();
    }
}
