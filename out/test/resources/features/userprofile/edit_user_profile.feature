@UserProfile
Feature: Edit User Profile

  @ResetUserInformation
  Scenario: Edit User's information in My Profile section
    Given I log in to Pivotal with Editable User credentials
    When I navigate to My Profile page
      And I edit My Profile with the following information
        | User name | Updated User name UNIQUE_ID |
        | Name      | Updated name UNIQUE_ID      |
        | Initials  | UU                          |
    Then "Changed saved" message should be displayed in My Profile section
      And the user information should be updated in My Profile section
      And my Name should be updated in the User Management Menu
      And my User Name should be updated in the Top Menu
    When I open the User Dropdown Menu from Top Menu
      And the user information should be updated in the User Dropdown Menu
