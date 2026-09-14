Feature: Product Inventory

  As a logged-in user
  I want to view and interact with the product inventory
  So that I can select products for purchase

  Background:
    Given the user is logged in
    And the user is on the inventory page


  Scenario: Inventory page is displayed after successful login
    Then the inventory page should be displayed
    And the page title should be "Products"


  Scenario: Product list is displayed
    Then the product list should be displayed
    And the inventory should contain available products


  Scenario: Product information is displayed correctly
    Then each product should display a name
    And each product should display a description
    And each product should display a price
    And each product should display an "Add to cart" button


  Scenario: Add a product to the cart
    When the user adds a product to the cart
    Then the product should be added to the cart


  Scenario: Remove a product from the inventory page
    Given the user has added a product to the cart
    When the user removes the product from the inventory page
    Then the product should be removed from the cart


  Scenario: Add multiple products to the cart
    When the user adds multiple products to the cart
    Then all selected products should be added to the cart


  Scenario: Cart badge is updated after adding a product
    When the user adds a product to the cart
    Then the cart badge should display "1"


  Scenario: Cart badge is updated after removing a product
    Given the user has added two products to the cart
    When the user removes one product from the inventory page
    Then the cart badge should display "1"


  Scenario: Open product details
    When the user clicks on a product name
    Then the product details page should be displayed
    And the selected product information should be displayed


  Scenario: Return to inventory from product details
    Given the user is viewing a product details page
    When the user returns to the inventory
    Then the inventory page should be displayed


  Scenario: Sort products by name from A to Z
    When the user sorts the products by "Name (A to Z)"
    Then the products should be displayed in ascending alphabetical order


  Scenario: Sort products by name from Z to A
    When the user sorts the products by "Name (Z to A)"
    Then the products should be displayed in descending alphabetical order


  Scenario: Sort products by price from low to high
    When the user sorts the products by "Price (low to high)"
    Then the products should be displayed in ascending price order


  Scenario: Sort products by price from high to low
    When the user sorts the products by "Price (high to low)"
    Then the products should be displayed in descending price order