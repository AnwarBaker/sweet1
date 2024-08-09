Feature: Exploration and Purchase


  Scenario: Browse and search for dessert recipes

  Given User logs in to the system
  When User navigates to the Recipes section
  Then User can browse and search for dessert recipes


  Scenario: Filter recipes based on dietary needs or food allergies

  Given User logs in to the system
  And User navigates to the Recipes section
  When User applies filters based on dietary needs or allergies
  Then System displays filtered recipes


  Scenario: Purchase desserts directly from store owners

  Given User logs in to the system
  And User navigates to the Store section
  When User selects a dessert to purchase
  Then User completes the purchase process


