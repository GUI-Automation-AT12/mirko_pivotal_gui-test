@UserProfile
Feature: Edit User Profile

  @restoreUserInformation
  Scenario: Edit User's information in My Profile section
    Given I log in to Pivotal with Editable User credentials
    When I navigate to My Profile page
      And I edit My Profile with the following information
        | User name | User_UNIQUE_ID  |
        | Name      | Updated Name    |
        | Initials  | UU              |
    Then "Changes saved" message should be displayed in My Profile section
      And the user information should be updated in My Profile section
    When I reload the page
    Then my Name should be updated in the User Management Menu
      And my User Name should be updated in the Top Menu
    When I open the User Dropdown Menu from Top Menu
    Then the user information should be updated in the User Dropdown Menu