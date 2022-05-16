@smoke
Feature:SC10- Logged user could add different products to Wishlist
  Scenario: Apply first step and add add different products to Wishlist
    Given The user opens the chrome browser and navigates to the login page
    When The user starts to enter his personal information and clk on submit login
    Then The user navigates to the home page and starts to add some products to list
    And The user adds another product to his wishlist cart
    And System Will close the browser after applying this method

