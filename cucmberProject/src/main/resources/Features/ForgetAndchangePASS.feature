@smoke
Feature: SC3- User could reset his/her password successfully
  Scenario: The user cold change his password from homepage and Forget Password page
    Given The user will open her browser and go to the login page if she wants to reset her email
    Then At first, a user must enter correct information about the user
    And The customer will navigate to HomePage and will select the Change password page
    And If the user Forget her password she will change it from the Login page
    And System will apply Previous steps then close the Browser