
Feature: User Sign-Up

  Scenario: Successful Sign-Up
    Given I am on the sign-up page
    When I enter a valid username
    And I enter a valid password
    And I enter a user level
    Then I should see a confirmation message
