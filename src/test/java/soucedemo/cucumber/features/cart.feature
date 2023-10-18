Feature: After login user can view cart page
  Scenario: Success view cart page
    When users open login page at www.saucedemo.com
    And users enter user end password
    And users click login button
    Then users can view cart page