Feature: User Account Feature


  Scenario: Sign up for a new account

  Given User navigates to the registration page.
  When User fills in the required details and submits the form.
  Then System creates a new account for the user.


  Scenario: Sign in to the platform

  Given User navigates to the login page.
  Then User enters credentials and logs in.


  Scenario: Manage personal accounts

  Given User logs in to the system.
  When User navigates to the Account Management section.
  Then User can update personal information and account settings.


  Scenario: Post and share personal dessert creations

  Given User logs in to the system.
  And User navigates to the Share Creations section.
  Then User uploads a new dessert creation with details.
