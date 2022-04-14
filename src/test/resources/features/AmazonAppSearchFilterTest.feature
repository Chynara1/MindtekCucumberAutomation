
Feature: Amazon Application search and filter functionality

  Scenario: Validating price range filter functionality for searched items
    Given  user navigates to the Amazon application
    When user searches for the "dresses"
    And user applies price filter over "50 to $100"
    Then user validates the items price is equal to over 50


