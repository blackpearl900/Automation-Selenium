@Dashboard
Feature:  Global Search Functionality Test
          As a registered user
          I want to login to the system
          So that I can access my account
          And perform global Searching

  Background:`
  Given   User is on the login page

  @Functional
  Scenario:     Successfully validate Global Searching
    When        User enter valid username
    And         User enter valid password
    And         User clicks on the login button
    And         User should be redirected to Unison Dashboard
    Then        Make sure that global search area should be displayed

  @Functional
  Scenario:     Successful search Case in Global Search
    When        User enter valid username
    And         User enter valid password
    And         User clicks on the login button
    And         User should be redirected to Unison Dashboard
    Then        Make sure that global search area should be displayed
    And         Case should be searched
    Then        Make sure that Case should be shown to user.

  @Functional
  Scenario:   Successful search SR in Global Search
  When        User enter valid username
  And         User enter valid password
  And         User clicks on the login button
  And         User should be redirected to Unison Dashboard
  Then        Make sure that global search area should be displayed
  And         SR should be searched
  Then        Make sure that SR should be shown to user

  @Functional
  Scenario:   Invalid details in the provided Global Search
  When        User enter valid username
  And         User enter valid password
  And         User clicks on the login button
  And         User should be redirected to Unison Dashboard
  Then        Make sure that global search area should be displayed
  Then        Enter invalid details on the provided area