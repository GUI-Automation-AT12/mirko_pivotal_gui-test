package org.fundacionjala.pivotal.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginStep1Page extends BasePage{
    @FindBy(id = "credentials_username")
    private WebElement usernameOrEmailTextBox;

    @FindBy(name = "action")
    private WebElement nextBtn;

    private void fillUsernameOrEmail(final String usernameOrEmail) {
        this.usernameOrEmailTextBox.clear();
        this.usernameOrEmailTextBox.sendKeys(usernameOrEmail);
    }

    private void clickNextBtn() {
        this.nextBtn.click();
    }

    public LoginStep2Page goToLoginStep2(final String usernameOrEmail) {
        fillUsernameOrEmail(usernameOrEmail);
        clickNextBtn();
        return new LoginStep2Page();
    }
}
