Feature:Admin User Management

@tag12
  Scenario: Manage user accounts
  Given Admin log in to the system
  When Admin navigate to the User Management section
  And Admin can view a list of users (store owners, raw material suppliers)
  And Admin can add new user by filling in the required details
  And Admin can update existing user details
  Then Admin can delete a user account


