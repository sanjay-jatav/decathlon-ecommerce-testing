Feature: Decathlon Homepage Testing

  @homepage
  Scenario: Verify homepage is loading with correct title and logo
    Given User opens the Decathlon homepage
    Then The page title should be "Decathlon - Buy Sport Products Online | Download Decathlon App"
    And The Decathlon logo should be visible
