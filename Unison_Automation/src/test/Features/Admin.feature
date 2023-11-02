@AdminModule
Feature: Admin Module Test
  An admin wants to add
  Roles, Groups & ORG. Unit

  @Functional
  Scenario: Add a role from admin panel
    Given  User is on the login page
    When   User enter valid username
    And    User enter valid password
    And    User clicks on the login button
    Then   User navigates to the settings button and selects Roles under Users and Control
    And    User enters the role name, secondary name and selects the parent role from the dropdown


  @Functional
  Scenario: Add a group from admin panel
    Given User is on the login page
    When   User enter valid username
    And    User enter valid password
    And    User clicks on the login button
    Then   User navigates to the settings button and selects Groups under Users and Control


  @Functional
  Scenario: Add organization unit from admin panel
    Given  User is on the login page
    When   User enter valid username
    And    User enter valid password
    And    User clicks on the login button
    And    User navigates to the settings button and selects Organization Unit under Users and Control
    Then   User add all of the required details and register a new org unit


  @Functional
  Scenario: Add Users from admin panel
    Given  User is on the login page
    When   User enter valid username
    And    User enter valid password
    And    User clicks on the login button
    And    User navigates to the settings button and selects Users under Users and Control
    Then   User enters all of the required details and successfully registers a new user

