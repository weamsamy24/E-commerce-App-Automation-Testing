@smoke
Feature: SC1- User could register with valid data


  Scenario:User register with valid data and choose a male as a gender
    #Test Scenario 1
    Given open Browser
    And user navigate to Register page
    When user enter valid data
     #Excpected Result
    Then user press the submit register
    And user make sure that the registers were successfully
    And Close Tabs











