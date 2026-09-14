Feature: Shopping Cart

  As a logged-in user
  I want to manage products in my cart
  So that I can review my purchase before checkout

  Background:
    Given the user is logged in
    And the user is on the inventory page


  Scenario: Open the shopping cart
    Given the user has added a product to the cart
    When the user opens the shopping cart
    Then the cart page should be displayed


  Scenario: Added product is displayed in the cart
    Given the user has added a product to the cart
    When the user opens the shopping cart
    Then the added product should be displayed in the cart


  Scenario: Product information is displayed correctly in the cart
    Given the user has added a product to the cart
    When the user opens the shopping cart
    Then the cart product should display a name
    And the cart product should display a description
    And the cart product should display a price
    And the cart product quantity should be "1"


  Scenario: Remove product from the cart
    Given the user has added a product to the cart
    And the user opens the shopping cart
    When the user removes the product from the cart
    Then the cart should be empty


  Scenario: Continue shopping
    Given the user has added a product to the cart
    And the user opens the shopping cart
    When the user clicks on continue shopping
    Then the inventory page should be displayed


  Scenario: Proceed to checkout
    Given the user has added a product to the cart
    And the user opens the shopping cart
    When the user proceeds to checkout
    Then the checkout information page should be displayed