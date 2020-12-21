package org.fundacionjala.pivotal.cucumber.steps;

import io.cucumber.java.en.When;
import org.fundacionjala.pivotal.entities.User;
import org.fundacionjala.pivotal.ui.component.TopMenu;

import java.util.Map;

public class ProfileSteps {

    // Entities
    private User user;

    // Components
    private TopMenu topMenu;


    /**
     * StepDef to edit user Profile receiving a Data Table.
     * @param userInformation
     */
    @When("^I edit My Profile with the following information$")
    public void editMyProfile(final Map<String, String> userInformation) {

        // Update User entity
        user.processInformation(userInformation);

        // Update User Information by UI
//        profilePage.setUserInformation(userInformation.keySet(), user);

    }
}
