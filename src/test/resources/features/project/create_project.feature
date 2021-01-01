@Project
Feature: Create Project

  @deleteProject
  Scenario: Create a new public Project from an existent Account
    Given I log in to Pivotal with Standard User credentials
    When I open the Create Project pop-up
    And I create a new public Project with the following information
      | Name         | New Public Project  |
      | Account      | Existent Account    |
      | Privacy      | Public              |
    Then I am driven to recently created Project Page
      And the name of my new project should be displayed at Project Dropdown Menu
    When I open the Project Summary page
    Then my new project should be listed in the summary