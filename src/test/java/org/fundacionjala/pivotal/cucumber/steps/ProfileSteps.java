package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProfileSteps {

    // Entities
    private User user;

    // Pages
    private ProfilePage profilePage;

    /**
     * StepDef to edit user Profile receiving a Data Table.
     * @param userInformation
     */
    @When("^I edit My Profile with the following information$")
    public void editMyProfile(final Map<String, String> userInformation) {

        // Update User entity
        user = new User();
        user.processInformation(userInformation);

        // Update User Information by UI
        profilePage = new ProfilePage();
        profilePage.getEditProfileForm().editProfileInformation(userInformation.keySet(), user);
    }

    @Then("{string} message should be displayed in My Profile section")
    public void messageShouldBeDisplayedInMyProfileSection(final String message) {
        String actual = profilePage.getTextFromChangesNotification();
        assertEquals(message, actual);
    }

    @Then("the user information should be updated in My Profile section")
    public void theUserInformationShouldBeUpdatedInMyProfileSection() {
        Map<String, String> profileInfo = profilePage.getUserInformationAsMap();
        assertEquals(user.getUserName(), profileInfo.get("User name"));
        assertEquals(user.getName(), profileInfo.get("Name"));
        assertEquals(user.getInitials(), profileInfo.get("Initials"));
    }

    @Then("my Name should be updated in the User Management Menu")
    public void myNameShouldBeUpdatedInTheUserManagementMenu() {
        String managementMenuTitle = profilePage.getUserManagementMenuTitleAsString();
        assertEquals(user.getName().toUpperCase(), managementMenuTitle);
    }

    @Then("my User Name should be updated in the Top Menu")
    public void myUserNameShouldBeUpdatedInTheTopMenu() {
        String userNameFromTopMenu = profilePage.getTopMenu().getUserNameFromTopMenu();
        assertEquals(user.getUserName().toUpperCase(), userNameFromTopMenu);
    }

    @When("I open the User Dropdown Menu from Top Menu")
    public void iOpenTheUserDropdownMenuFromTopMenu() {
        profilePage.getTopMenu().openUserNameDropdownMenu();
    }


    @Then("the user information should be updated in the User Dropdown Menu")
    public void theUserInformationShouldBeUpdatedInTheUserDropdownMenu() {
        Map<String, String> dropdownMenuInfo = profilePage.getTopMenu().getUserMenu().getUserInformationAsMap();
        assertEquals(user.getInitials(), dropdownMenuInfo.get("Underlying initials"));
        assertEquals("@" + user.getUserName(), dropdownMenuInfo.get("Details user name"));
        assertEquals(user.getName(), dropdownMenuInfo.get("Details name"));
        assertEquals(user.getInitials(), dropdownMenuInfo.get("Details initials"));
    }
}
