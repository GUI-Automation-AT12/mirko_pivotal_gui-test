@Story
Feature: Manage Stories

  @deleteStory
  Scenario: Drag a Story from Backlog panel and drop it into Icebox panel
    Given I log in to Pivotal with Standard User credentials
    When I go to Project Page of Existent Project
      And I create a new Story in Backlog with the following info
        | Name         | A New Story  |
      And I send a GET API request to "projects/{projectId}/history/snapshots"
    Then the Story should be in "current" list in the response
    When I do a drag and drop of the Story from Backlog to Icebox
      And I send a GET API request to "projects/{projectId}/history/snapshots?fields=icebox"
    Then the Story should be in "icebox" list in the response
    When I send a GET API request to "projects/{projectId}/history/snapshots"
    Then the Story should not be in "icebox" list in the response