@smoke
Feature:SC2- User could log in with valid email and password

  Background: user open browser and login to the home page
    Given user open browser
    And user navigate to login page

  #Test Scenario 1
  Scenario: User login with valid email and password without choosing the "Remember me" Button.
    When user enter valid user name and password and login
    #Excpected Result
    Then user could login successfully



  #Test Scenario 2
  Scenario:User login with email and password and choose the "Remember me" Button.
    When user enter valid user name and password and login with remember button
    And user choose Remember me Button
    And click on Login Button
    #Excpected Result
    Then user login successfully
    And close App
