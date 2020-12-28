package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.pages.LoggedIn.ProfilePage;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProfileSteps {

    // Entities
    private User user;

    // Pages
    private ProfilePage profilePage;

    // Context
    private final Context context;

    /**
     * Adding Dependency injection to share Default Users information.
     * @param sharedContext
     */
    public ProfileSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * StepDef to edit user Profile from GUI receiving a Data Table.
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
        context.getUserByAlias("Editable User").setEditedFields(userInformation.keySet());
    }

    /**
     * StepDef to open the User Dropdown Menu of the Profile Page.
     */
    @When("I open the User Dropdown Menu from Top Menu")
    public void openUserDropdownMenuFromTopMenu() {
        profilePage.getTopMenu().openUserNameDropdownMenu();
    }

    /**
     * StepDef to compare a message given against the message present in Profile Page.
     * @param message
     */
    @Then("{string} message should be displayed in My Profile section")
    public void verifyMessageIsDisplayedInMyProfileSection(final String message) {
        String actual = profilePage.getTextFromChangesNotifier();
        assertEquals(message, actual);
    }

    /**
     * StepDef to verify that the user information edited was changed in Profile Page.
     */
    @Then("the user information should be updated in My Profile section")
    public void verifyUserInformationIsUpdatedInMyProfileSection() {
        Map<String, String> profileInfo = profilePage.getUserInformationAsMap();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(profileInfo.get("User name"), user.getUserName(),
                "The Username from Profile Page does not match with the Username edited previously.");
        softAssert.assertEquals(profileInfo.get("Name"), user.getName(),
                "The Name from Profile Page does not match with the Name edited previously.");
        softAssert.assertEquals(profileInfo.get("Initials"), user.getInitials(),
                "The Initials from Profile Page does not match with the Initials edited previously.");
        softAssert.assertAll();
    }

    /**
     * StepDef to check that the edited Name was showed in the User Management Menu.
     */
    @Then("my Name should be updated in the User Management Menu")
    public void verifyMyNameIsUpdatedInUserManagementMenu() {
        String managementMenuTitle = profilePage.getUserManagementMenuTitleAsString();
        assertEquals(user.getName().toUpperCase(), managementMenuTitle);
    }

    /**
     * StepDef to check that the edited User name was showed in the Top Menu.
     */
    @Then("my User Name should be updated in the Top Menu")
    public void verifyMyUserNameIsUpdatedInTheTopMenu() {
        String userNameFromTopMenu = profilePage.getTopMenu().getUserNameFromTopMenu();
        assertEquals(user.getUserName().toUpperCase(), userNameFromTopMenu);
    }


    /**
     * StepDef to verify that the user information edited was changed in the User Dropdown Menu.
     */
    @Then("the user information should be updated in the User Dropdown Menu")
    public void verifyUserInformationIsUpdatedInUserDropdownMenu() {
        Map<String, String> dropdownMenuInfo = profilePage.getTopMenu().getUserMenu().getUserInformationAsMap();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dropdownMenuInfo.get("Underlying initials"), user.getInitials(),
                "Underlying Initials of User Menu does not match with the Initials edited previously.");
        softAssert.assertEquals(dropdownMenuInfo.get("Details user name"), user.getUserName(),
                "The Username from User Menu does not match with the Username edited previously.");
        softAssert.assertEquals(dropdownMenuInfo.get("Details name"), user.getName(),
                "The Name from User Menu does not match with the Name edited previously.");
        softAssert.assertEquals(dropdownMenuInfo.get("Details initials"), user.getInitials(),
                "The Initials from User Menu does not match with the Initials edited previously.");
        softAssert.assertAll();
    }
}
