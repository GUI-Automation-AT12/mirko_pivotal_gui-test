package org.fundacionjala.pivotal.ui.component;

import org.fundacionjala.core.selenium.GuiInteractioner;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Set;

public class EditProfileForm extends BasePage {

    @FindBy(id = "person_username")
    private WebElement userNameTextBox;

    @FindBy(id = "person_name")
    private WebElement nameTextBox;

    @FindBy(id = "person_initials")
    private WebElement initialsTextBox;

    @FindBy(css = ".save_button.header_button")
    private WebElement saveEditProfileBtn;

    private void fillUserNameTextBox(final String newUserName) {
        GuiInteractioner.setInputText(userNameTextBox, newUserName);
    }

    private void fillNameTextBox(final String newName) {
        GuiInteractioner.setInputText(nameTextBox, newName);
    }

    private void fillInitialsTextBox(final String newInitials) {
        GuiInteractioner.setInputText(initialsTextBox, newInitials);
    }

    private void clickSaveEditProfileBtn() {
        GuiInteractioner.clickWebElement(saveEditProfileBtn);
    }

    private HashMap<String, Runnable> composeMapStrategy(final User user) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("User name", () -> fillUserNameTextBox(user.getUserName()));
        strategyMap.put("Name", () -> fillNameTextBox(user.getName()));
        strategyMap.put("Initials", () -> fillInitialsTextBox(user.getInitials()));
        return strategyMap;
    }

    private void setInformationToEdit(final Set<String> formFields, final User user) {
        HashMap<String, Runnable> strategyMap = composeMapStrategy(user);
        formFields.forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Edits information of a User Profile from GUI.
     * @param formFields fields to be edited
     * @param user user to be edited
     */
    public void editProfileInformation(final Set<String> formFields, final User user) {
        setInformationToEdit(formFields, user);
        clickSaveEditProfileBtn();
    }
}
