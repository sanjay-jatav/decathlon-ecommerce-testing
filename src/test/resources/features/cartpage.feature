Feature: Cart Page Functionality

  @addProduct1
  Scenario: Add a product to the cart and validate it appears
    Given I am on a Product Details Page
    When I add the product to the cart
    Then the cart should contain the product

  @removeProduct2
  Scenario: Remove a product from the cart
    Given I have a product in the cart
    When I remove the product from the cart
    Then the cart should be empty

  @updateQuantity3
  Scenario: Update quantity of a product in the cart
    Given I have a product in the cart
    When I update the quantity to 3
    Then the cart should reflect quantity as 3

  @priceCalculation4
  Scenario: Validate total price calculation based on quantity
    Given I have a product in the cart with quantity 2
    Then the total price should be correctly calculated

  @multipleProducts5 
  Scenario: Add multiple different products and validate cart
    Given I add multiple different products to the cart
    Then all products should be listed in the cart
