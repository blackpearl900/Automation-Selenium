@EmailManagement
Feature: Email Management Test
  As a registered user
  User wants to send an email using email management module
  Also validate it in the SENT email box

  Background:
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    Then User navigates to the Email Management module

  @Functional
  Scenario: Composition of a new email
    When User navigates to compose email
    And User selects sender email and provide recipients
    And User enters the subject and body of the email
    Then User selects the email template and sends the email

  @Functional
  Scenario: Validate the sent email in sent email box
    When User navigates to compose email
    And User selects sender email and provide recipients
    And User enters the subject and body of the email
    And User selects the email template and sends the email
    Then User navigates to the sent emails and verify if the email was sent or not