Feature: Monitoring and Reporting


  Scenario: Monitor profits and generate financial reports

  Given Admin logs in to the system
  When Admin navigates to the Reports section
  And Admin selects the desired report type (e.g., monthly profits)
  Then System generates and displays the financial report


  Scenario: Identify best-selling products in each store

  Given Admin logs in to the system
  When Admin navigates to the Best-Selling Products section
  Then System displays a list of best-selling products for each store


  Scenario: Gather and display statistics on registered users by City

  Given Admin logs in to the system
  When Admin navigates to the User Statistics section
  Then System displays user statistics categorized by city (e.g., Nablus, Jenin)