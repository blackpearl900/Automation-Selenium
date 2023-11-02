@Login
Feature:  Dashboard Functionality Test
          As a registered user
          I want to login to the system
          So that I can access my account

  Background:
    Given User is on the login page

  @Functional
  Scenario:   Successful Login
   When       User enter valid username
   And        User enter valid password
   And        User clicks on the login button
   Then       User should be redirected to Unison Dashboard

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
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    Then User should not be redirected to Unison Dashboard


  @Functional
  Scenario:   Verificaiton of Home Portal of the logged-in user
  When       User enter valid username
  And        User enter valid password
  And        User clicks on the login button
  Then       User should be redirected to Unison Dashboard
  Then       Make sure that all grids on dashboard should be shown


