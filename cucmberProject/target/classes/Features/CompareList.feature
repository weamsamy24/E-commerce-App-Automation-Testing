@smoke
Feature: SC11- Logged user could add different products to compare list
  Scenario: The User Will login with valid data and the system will navigate to homePage to select different items
    Given open Browser and Go to Login Page
    When Customer start to enter Some information and CLK to login Button
    Then Select the HomePage to add some items to compare list
    And After applying the previous steps close the browser

