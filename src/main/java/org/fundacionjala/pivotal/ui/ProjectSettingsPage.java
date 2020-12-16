package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectSettingsPage extends BasePage{

    @FindBy(id = "delete_link")
    private WebElement deleteProjectLink;

    @FindBy(id = "confirm_delete")
    private WebElement deleteProjectBtn;

    protected ProjectSettingsPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    private void scrollDownToFindDeleteProjectLink() {
        JavascriptExecutor js = (JavascriptExecutor) super.webDriver;
        js.executeScript("arguments[0].scrollIntoView();", this.deleteProjectLink);
    }

    private void clickDeleteLink() {
        this.deleteProjectLink.click();
    }

    private void clickDeleteBtn() {
        this.deleteProjectBtn.click();
    }

    public void deleteProject() {
        scrollDownToFindDeleteProjectLink();
        clickDeleteLink();
        clickDeleteBtn();
    }
}
