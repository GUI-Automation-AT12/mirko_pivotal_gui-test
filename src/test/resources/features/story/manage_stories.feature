@Story
Feature: Manage Stories

  @deleteStory
  Scenario: Drag a Story from Backlog panel and drop it into Icebox panel
    Given I log in to Pivotal with Standard User credentials
    When I go to Project Page of Existent Project
      And I create a new Story in Backlog with the following info
        | Name         | A New Story  |
      And I use the API to get the Backlog
    Then the Story should be in the Backlog
    When I do a drag and drop of the Story from Backlog to Icebox
      And I use the API to get the Icebox
    Then the Story should be in the Icebox
      And the Story should not be in the Backlog