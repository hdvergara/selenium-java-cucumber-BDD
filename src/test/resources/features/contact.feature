Feature: Contact option

  Scenario: Send the form
    Given the user enter to the application
    When we click on the contact option
    And we fill the form
    Then the form is sent