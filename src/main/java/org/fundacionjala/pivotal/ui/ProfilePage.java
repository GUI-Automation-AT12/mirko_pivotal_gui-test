package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{
    @FindBy(css = "#general.card ul.rows.read li div")
    private WebElement profileUserName;

    public ProfilePage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public String getProfileUserNameAsString() {
        return this.profileUserName.getText();
    }
}
