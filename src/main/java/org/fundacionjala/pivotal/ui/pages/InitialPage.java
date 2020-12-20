package org.fundacionjala.pivotal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {
    @FindBy(linkText = "Log in")
    private WebElement LogInLink;

    private void clickLogInLink() {
        this.LogInLink.click();
    }

    public LoginStep1Page goToLoginStep1() {
        clickLogInLink();
        return new LoginStep1Page();
    }

}
