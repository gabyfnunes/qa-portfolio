Feature: User Authentication

  As a registered user
  I want to log into the application
  So that I can access the products page

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "standard_user" and password "secret_sauce"
    Then the Products page should be displayed

  Scenario Outline: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters username "<username>" and password "<password>"
    Then the error message "<message>" should be displayed

    Examples:
      | username        | password           | message                                                                    |
      | wrong_user      | secret_sauce       | Epic sadface: Username and password do not match any user in this service |
      | standard_user   | wrong_secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | wrong_user      | wrong_password      | Epic sadface: Username and password do not match any user in this service |
      |                 |                    | Epic sadface: Username is required                                        |
      |                 | secret_sauce       | Epic sadface: Username is required                                        |
      | standard_user   |                    | Epic sadface: Password is required                                        |
      | locked_out_user | secret_sauce       | Epic sadface: Sorry, this user has been locked out.                       |

  Scenario: Password remains masked
    Given the user is on the login page
    When the user enters username "standard_user" and password "secret_sauce" without logging in
    Then the password field should remain masked

  Scenario: Access to the inventory page is denied without authentication
    When the user accesses the inventory page without being logged in
    Then the authentication error message should be displayed

  Scenario: Close the login error message
    Given the user is on the login page
    When the user enters username "wrong_user" and password "wrong_password"
    And closes the error message
    Then the error message should no longer be displayed