@Leads
Feature: Leads Module Test
  A registered user wants to create a new lead
  for a customer and then validate
  If the lead is saved or not

  Background:
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    Then User should be redirected to Unison Dashboard
    And User closes the active session if there is one already
    When User selects relationship number from dropdown and enters the relationship number in search box
    And User attempts to search that relationship number
    Then Search results should return the customer details
    When User validates the questionnaire
    Then View details text should be visible and on clicking it the customer details should be opened

  @Functional
  Scenario: Create a new lead and then validate it
    When User navigates to the Leads tab and clicks on the new Lead Request button
    And User enters all of the required details for a Lead and save
    Then The newly created Lead should be shown in the list


#    When User is on the Leads page
#    And User navigates to the Add Lead option
#    And User enters the required details and search for customer
#    And User selects the customer and proceeds to the next screen
#    And User enters the required details for the creation of a new Lead and save it
#    Then The lead should be created