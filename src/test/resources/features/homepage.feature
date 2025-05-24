Feature: Decathlon Homepage Testing

  @search1
  Scenario: Verify the search bar is functional
    Given User opens the Decathlon homepage
    When User enters "shoes" in the search bar
    And User clicks on the search icon
    Then Search results related to "shoes" should be displayed

  @navigation2
  Scenario: Verify top navigation menus are visible and clickable
    Given User opens the Decathlon homepage
    Then The navigation menu should include "Men", "Women", "Kids", "Sports", and "Offers"
    When User clicks on the "Men" category
    Then The user should be redirected to the Men’s category page

  @navigation3
  Scenario: Verify subcategories appear on hover over a main category
    Given User opens the Decathlon homepage
    When User hovers over the "Sports" category
    Then Subcategories like "Running", "Cycling", "Fitness" should be displayed

  @banner4
  Scenario: Verify homepage banner is visible and clickable
    Given User opens the Decathlon homepage
    Then The homepage banner should be visible
    When User clicks on the homepage banner
    Then The user should be redirected to the relevant promotion page

  @banner5
  Scenario: Verify banner slider automatically changes images
    Given User opens the Decathlon homepage
    Then The homepage should display different banner images after a few seconds
