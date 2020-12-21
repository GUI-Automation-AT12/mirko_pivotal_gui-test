package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.component.EditProfileForm;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProfileSteps {

    // Entities
    private User user;

    // Pages
    private EditProfileForm editProfileForm;
    private ProfilePage profilePage;

    /**
     * StepDef to edit user Profile receiving a Data Table.
     * @param userInformation
     */
    @When("^I edit My Profile with the following information$")
    public void editMyProfile(final Map<String, String> userInformation) {

        // Update User entity
        user.processInformation(userInformation);

        // Update User Information by UI
        editProfileForm = new EditProfileForm();
        editProfileForm.editProfileInformation(userInformation.keySet(), user);
    }

    @Then("{string} message should be displayed in My Profile section")
    public void messageShouldBeDisplayedInMyProfileSection(final String message) {
        profilePage = new ProfilePage();
        String actual = profilePage.getTextFromChangesNotification();
        assertEquals(actual, message);
    }

    @And("the user information should be updated in My Profile section")
    public void theUserInformationShouldBeUpdatedInMyProfileSection() {

    }
}
