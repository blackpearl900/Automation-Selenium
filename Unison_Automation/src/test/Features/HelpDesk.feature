@HelpDeskModule
Feature: Help Desk Module Test
  An admin wants to add a
  Help Desk Request into the system

  @Functional
  Scenario: Add a help desk ticket from admin panel
    Given  User is on the login page
    When   User enter valid username
    And    User enter valid password
    And    User clicks on the login button
    And    User clicks on the help desk button to navigate to the help desk screen
    And    User clicks on the new help desk ticket button
    And    Help desk ticket popup should be opened and then user selects the right option
    And    User fills all of the details in the fields and click save to log the help desk ticket
    Then   Help desk ticket should be logged successfully