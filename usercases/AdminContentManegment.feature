Feature: Content Management


  Scenario: Manage the content shared on the system

  Given Admin logs in to the system
  When Admin navigates to the Content Management section
  Then Admin can add, update, or delete recipes and posts shared by users

  Scenario: Manage user feedback

  Given Admin logs in to the system
  When Admin navigates to the Feedback Management section
  And Admin can view all feedback from users
  Then Admin can respond to or moderate feedback