Feature: Checkout

  As a logged-in user
  I want to complete the checkout process
  So that I can finish my purchase

  Background:
    Given the user is logged in
    And the user is on the inventory page
    And the user has added a product to the cart
    And the user opens the shopping cart
    And the user proceeds to checkout


  Scenario: Checkout information page is displayed
    Then the checkout information page should be displayed


  Scenario: Continue checkout with valid customer information
    When the user fills in the checkout information with valid data
    And the user continues the checkout
    Then the checkout overview page should be displayed


  Scenario: First name is required
    When the user leaves the first name field empty
    And the user fills in the last name
    And the user fills in the postal code
    And the user continues the checkout
    Then the error message should contain "First Name is required"


  Scenario: Last name is required
    When the user fills in the first name
    And the user leaves the last name field empty
    And the user fills in the postal code
    And the user continues the checkout
    Then the error message should contain "Last Name is required"


  Scenario: Postal code is required
    When the user fills in the first name
    And the user fills in the last name
    And the user leaves the postal code field empty
    And the user continues the checkout
    Then the error message should contain "Postal Code is required"


  Scenario: Complete purchase successfully
    When the user fills in the checkout information with valid data
    And the user continues the checkout
    And the user finishes the purchase
    Then the order confirmation page should be displayed
    And the success message should be "Thank you for your order!"