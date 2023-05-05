Feature: ClickUp API test feature

  Scenario: Create a folder, list, task and then remove the task
    Given I create a ClickUp folder named "FOLDER1" and verify that the name is correct
    And I create a new list named "LIST1" in the folder
    And I verify that the name of the list is "LIST1"
    And In the list I create one task
    And I check that the name of the task is correct
    When I remove the task from the list
#    Then I verify that the task is not in the list anymore


