@smoke
Feature:SC9- Logged user could add different products to Shopping cart
  Scenario: user open browser to login and add different item to shop cart
  Given The system opens the browser and goes to the login page
  When login with valid password and username and clk on login button
  Then The customer starts to add different items to the shopping cart like the HTC mobile
    And The customer starts to add Apple MacBook Pro 13-inch to the shopping cart
    And close the website

