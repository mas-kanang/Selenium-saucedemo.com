Feature: User can view Product Detail page
  Scenario: Success view Detail Page
    When I open login page at www.saucedemo.com
    And I enter user end password
    And I click login button
    Then I can view product detail page