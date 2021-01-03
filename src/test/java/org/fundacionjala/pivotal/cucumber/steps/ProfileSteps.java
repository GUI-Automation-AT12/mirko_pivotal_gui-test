package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.context.Context;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.component.TopMenu;
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
     * Adds Dependency injection to share Context information.
     * @param sharedContext
     */
    public ProfileSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Edits user Profile from GUI receiving a Data Table.
     * @param userInformation
     */
    @When("^I edit My Profile with the following information$")
    public void editMyProfile(final Map<String, String> userInformation) {

        // Update User entity
        user = new User();
        user.processInformation(userInformation);
        user.setAlias("Editable User");
        user.setEditedFields(userInformation.keySet());
        context.getEditedUsersList().add(user.getAlias());
        context.getUserByAlias(user.getAlias()).setEditedFields(userInformation.keySet());

        // Update User Information by UI
        profilePage = new ProfilePage();
        profilePage.getEditProfileForm().editProfileInformation(userInformation.keySet(), user);
    }

    /**
     * Opens the User Dropdown Menu of the Profile Page.
     */
    @When("I open the User Dropdown Menu from Top Menu")
    public void openUserDropdownMenuFromTopMenu() {
        TopMenu topMenu = new TopMenu();
        topMenu.openUserNameDropdownMenu();
    }

    /**
     * Compares a message given against the message present in Profile Page.
     * @param message
     */
    @Then("{string} message should be displayed in My Profile section")
    public void verifyMessageIsDisplayedInMyProfileSection(final String message) {
        String actual = profilePage.getTextFromChangesNotifier();
        assertEquals(message, actual);
    }

    /**
     * Verifies that the user information edited was changed in Profile Page.
     */
    @Then("the user information should be updated in My Profile section")
    public void verifyUserInformationIsUpdatedInMyProfileSection() {
        Map<String, String> actualProfileInfo = profilePage.getUserEditedInfoAsMap(user.getEditedFields());
        Map<String, String> expectedProfileInfo = user.getEditedInfo();
        SoftAssert softAssert = new SoftAssert();
        actualProfileInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedProfileInfo.get(field),
                    "The " + field + " from Profile Page does not match with the " + field + " edited previously.");
        });
        softAssert.assertAll();
    }

    /**
     * Checks that the edited Name was showed in the User Management Menu.
     */
    @Then("my Name should be updated in the User Management Menu")
    public void verifyMyNameIsUpdatedInUserManagementMenu() {
        String managementMenuTitle = profilePage.getUserManagementMenuTitleAsString();
        assertEquals(user.getName().toUpperCase(), managementMenuTitle);
    }

    /**
     * Checks that the edited User name was showed in the Top Menu.
     */
    @Then("my User Name should be updated in the Top Menu")
    public void verifyMyUserNameIsUpdatedInTheTopMenu() {
        String userNameFromTopMenu = profilePage.getTopMenu().getUserNameFromTopMenu();
        assertEquals(user.getUserName().toUpperCase(), userNameFromTopMenu);
    }


    /**
     * Verifies that the user information edited was changed in the User Dropdown Menu.
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
                "The Details Initials from User Menu does not match with the Initials edited previously.");
        softAssert.assertAll();
    }
}
