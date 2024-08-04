Feature: Product Management
  Scenario: Add, update, and remove available products

  Given Store owner logs in to the system
  When Store owner navigates to the Product Management section
  And Store owner can add a new product by providing necessary details
  And Store owner can update existing product information
  Then Store owner can remove a product from the list


  Scenario: Monitor sales and profits

  Given Store owner logs in to the system
  When Store owner navigates to the Sales Reports section
  Then System displays sales and profit reports

  Scenario: Identify best-selling products

  Given Store owner logs in to the system
  When Store owner navigates to the Best-Selling Products section
  Then System displays the best-selling products


  Scenario: Implement dynamic discount features

  Given Store owner logs in to the system
  When Store owner navigates to the Discount Management section
  Then Store owner can set dynamic discounts for products