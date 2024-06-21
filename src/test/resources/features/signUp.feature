Feature: User Registration in the Application

  Scenario: Registering a new user
    Given the user enter to the application
    When the user selects the Sign Up option
    And enter the data for registration
    Then a successful registration confirmation message is displayed