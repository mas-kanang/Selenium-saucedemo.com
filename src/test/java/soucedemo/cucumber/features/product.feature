Feature: After login user can view product page
  Scenario: Success view product page
    When User open login page at www.saucedemo.com
    And user enter user end password
    And user click login button
    Then user can view product page