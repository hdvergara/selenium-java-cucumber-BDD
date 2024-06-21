Feature: Login

  Scenario: Logging in with incorrect credentials
    Given the user enter to the application
    When the user click on the login option
    And enter incorrect login credentials
    Then a message indicating that the credentials are incorrect is displayed

  Scenario: Logging in with correct credentials
    Given the user enter to the application
    When the user click on the login option
    And enter login credentials
      | Username   | Password  |
      | pragmatest | Test12345 |
    Then user is logged correctly