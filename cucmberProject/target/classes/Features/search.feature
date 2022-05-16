@smoke
Feature:SC4- Logged User could search for any product, SC5- Logged User could switch between currencies US-Euro,SC6- Logged user could select different Categories
  Scenario: Users login into the sign-in page and start to search for different categories and change the currency
    Given open the chromeBrowser and navigate to the Login page
    When The Users start to Sign-in with valid data
    Then If the user wants to search for any product he should use the search label
    And If the user wants to switch between currencies US AND Euro
    And Logged user could select different Categories select Electronics Category
    And Logged user could select different Categories select Apparel Category
    And When the user finishes his shopping process, close the browser


