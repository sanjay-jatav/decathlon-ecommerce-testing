Feature: Product Details Page Functionality

  @scenarios1
  Scenario: Validate product title and price are displayed
    Given I am on the Product Listing Page
    When I click on a product
    Then the Product Details Page should display the product title
    And the Product Details Page should display the product price

  @scenario2
  Scenario: Validate product images and image zoom functionality
    Given I am on the Product Details Page
    When I hover over the main product image
    Then the image should zoom in
    And additional thumbnail images should be visible

  @scenario3
  Scenario: Validate product specifications are displayed
    Given I am on the Product Details Page
    Then I should see the product specifications section
    And it should include key details like material, dimensions, and warranty

  @scenario4
  Scenario: Validate product reviews section is displayed
    Given I am on the Product Details Page
    Then I should see a reviews section
    And it should display user ratings and comments

  @scenario5
  Scenario: Validate Add to Cart button functionality
    Given I am on the Product Details Page
    When I click on the "Add to Cart" button
    Then the product should be added to the cart
    And a confirmation message should appear
