Feature: Add MacBook to Cart
  Scenario: User adds a MacBook to the shopping cart
    Given the user enter to the application
    When the user clicks on the laptops category
    And the user adds the MacBook to the cart
    Then the MacBook should be added to the cart successfully