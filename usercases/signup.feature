
Feature: User Sign-Up
  @tag12
  Scenario: Successful Sign-Up
    Given I am on the sign-up page
    When the user enters a valid signup data like
    Then I should see a confirmation message

  @tag13
  Scenario: User signs up with non-matching data

  Given I am on the sign-up page
  When the user enters signup data of exist data like
  Then the user should see a exist data message

