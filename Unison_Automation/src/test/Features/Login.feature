@Dashboard
Feature:  Login Functionality Test
          As a registered user
          I want to login to the system
          So that I can access my account

  Background:
  Given   User is on the login page

  @Functional
  Scenario: Successful Login
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    Then User should be redirected to Unison Dashboard

  @Negative
  Scenario: Unsuccessful Login with Upper and lower cases credentials
    When User enter Upper and lower case username
    And User enter Upper and lower case password
    And User clicks on the login button
    Then User should not be redirected to Unison Dashboard


  @Functional
  Scenario: Successful locking user account
    When User enter invalid credentials greater than the number defined in system
    And User clicks on the login button
    Then User should not be redirected to Unison Dashboard


  @Negative
  Scenario: Unsuccessful user Login whose status is in-active
    When User enter valid username of an in-active account
    And User enter valid password
    And User clicks on the login button
    Then User should not be redirected to Unison Dashboard


  @Functional
  Scenario: Successful unlocking user account by administration account
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User clicks on the settings link and User clicks on the users option
    And Search and select the locked user
    And Mark the locked user account as active and clicks on save button
    Then User change should be made successfully and user account should be unlocked


  @Functional
  Scenario: Successful user Logging out from the system
    When User click on log out button
    Then User should be logged out from the system and should redirect to login page