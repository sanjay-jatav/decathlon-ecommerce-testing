Feature: Product Listing Page functionality

  @productPage
  Scenario: Verify user can view list of products
    Given User is on the Decathlon homepage
    When User navigates to the Product Listing Page
    Then User should see a list of products displayed
