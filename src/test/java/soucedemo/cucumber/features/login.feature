Feature: Login page soucedemo.com
  Scenario: Success Login
    Given user open login page at www.saucedemo.com
    When  User enter correct username
    And User enter correct password
    And User Click Login Button
    Then User redirected to dashboard page

  Scenario: Failed Login
    Given user open login page at www.saucedemo.com
    When  User enter correct username
    And User enter incorrect password
    And User Click Login Button
    Then User get error message
