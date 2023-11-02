@AgentDesktop
Feature: Customer Search from Agent Desktop Test
  An agent wants to search a customer
  through Agent Desktop
  Validate their questionnaire
  Access their hub/details

  @Functional
  Scenario:   Search Customer from Agent Desktop
    Given        User is on the login page
    When         User enter valid username
    And          User enter valid password
    And          User clicks on the login button
    Then         User should be redirected to Unison Dashboard
    And          User navigates to the Agent Desktop
    And          User closes the active session if there is one already
    When        User selects CNIC from dropdown and enters the CNIC in search box
    And         User attempts to search that CNIC
    Then        Search results should return the customer details

    @Functional
    Scenario:    Successfully search customer via CNIC
    Given        User is on the login page
    When         User enter valid username
    And          User enter valid password
    And          User clicks on the login button
    Then         User should be redirected to Unison Dashboard
    And          User navigates to the Agent Desktop
    And          User closes the active session if there is one already
    When         User selects CNIC from dropdown and enters the CNIC in search box
    And          User attempts to search that CNIC
    Then         Search results should return the customer details
    When         User validates the questionnaire
    Then         Make sure that name should be displayed

  @Functional
  Scenario:      Successfully search customer via CNIC - Invalid details of CNIC
    Given        User is on the login page
    When         User enter valid username
    And          User enter valid password
    And          User clicks on the login button
    Then         User should be redirected to Unison Dashboard
    And          User navigates to the Agent Desktop
    And          User closes the active session if there is one already
    When         User selects CNIC from dropdown and enters the invalid CNIC in search box
    And          User attempts to search that CNIC
    Then         Make sure that Error should be displayed

  @Functional
  Scenario:    Verification of Basic Search options
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  Then         Make sure that All values should be shown in agent selection dropdown

  @Functional
  Scenario:    Successfully search customer via CNIC with Verification of Basic Info Tab
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  Then         Make sure that name Gender Nationality Date of Birth should be displayed

  @Functional
  Scenario:    Successfully Verification for caution box
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  Then         Then make sure that caution box should be shown to user

  @Functional
  Scenario:    Successful addition of Walk-In Customer
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  And          User clicks on walk-in customer
  And          User click on Add button
  Then         User Enter details in the provided fields of Walk-in customer and submit

  @Functional
  Scenario:    Addition of Walk-In Customer - Walkin- Customer
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  And          User clicks on walk-in customer
  And          User click on Add button
  Then         Make sure that upon pressing submit an error should be displayed

  @Functional
  Scenario:    Close Session manually for active user
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          click on session button then show
  Then         Session should be ended

  @Functional
  Scenario:    Verification for Recent Customer
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  Then         Make sure that User navigates to the customer hub and record is displayed

  @Functional
  Scenario:    Verification of Balance inquiry
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Balance Inquiry
  Then         Make sure that balance should be shown to user

  @Functional
  Scenario:    Verification of Account Details
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Account Details
  Then         Make sure that Account details should be shown to user

  @Functional
  Scenario:    Verification of chequebook details
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to cheque book Details
  Then         Make sure that cheque book Details should be shown to user

  @Functional
  Scenario:    Verification of debit card list
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to debit card list by accounts
  Then         Make sure that debit card list should be shown to user

  @Functional
  Scenario:    Verification of Mini statement
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to mini statement
  Then         Make sure that mini statement should be shown to user

  @Functional
  Scenario:    Verification of SMS/Estatment status
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to SMS Estatment status
  Then         Make sure that SMS Estatment should be shown to user

  @Functional
  Scenario:    Verification of credit card details
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Credit Card details
  Then         Make sure that Credit Card Detail should be shown to user

  @Functional
  Scenario:    Verification of Credit Card Last 10 Transaction
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Credit Card last 10 transactions
  Then         Make sure that Credit Card Last 10 Transaction should be shown to user

  @Functional
  Scenario:    Verification of debit Card cross border enable
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to cross border enablment
  Then         Make sure that Cross Border transaction should be enabled

  @Functional
  Scenario:    Verification of Cross Border Status Fetch
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Cross Border Status Fetch
  Then         Make sure that Cross Border Status should be fetched

  @Functional
  Scenario:    Verification of Debit Card Detail
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Debit Card Detail
  Then         Make sure that Debit Card Detail should be fetched

  @Functional
  Scenario:    Verification of Debit Card Status Change
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Debit Card Status Change
  Then         Make sure that Debit Card status should be changed

  @Functional
  Scenario:    Verification of Debit Card Status Fetch
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Debit Card Status fetch
  Then         Make sure that Debit Card status should be fetched

  @Functional
  Scenario:    Verification of GDCI Service Block
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to GDCI Service Block
  Then         Make sure that GDCI Service should be Block

  @Functional
  Scenario:    Verification of GDCI Service Block
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to GDCI Service Block
  Then         Make sure that GDCI Service should be Block

  @Functional
  Scenario:    Verification of GDCI Service unBlock
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to GDCI Service unBlock
  Then         Make sure that GDCI Service should be unBlock

  @Functional
  Scenario:    Verification of Internet Session Status
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Internet Session Status
  Then         Make sure that Internet session status should be shown to user

  @Functional
  Scenario:    Verification of Online VISA Transaction
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Financial Accounts
  And          Go to Online VISA Transaction
  Then         Make sure that Online VISA transaction session request should be submitted

    #add more validation to the cases in last testcase
  @Functional
  Scenario:    Verification of ATM Customer Demographics
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to ATM Customer Demographics
  Then         Make sure that ATM Customer Demographics should be shown

  @Functional
  Scenario:    Verification of ATM Statement For One Year
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to ATM Statement For One Year
  Then         Make sure that ATM Statement For One Year should be shown

  @Functional
  Scenario:    Verification of ATM Today Transaction Statement
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to ATM Today Transaction Statement
  Then         Make sure that ATM Today Transaction Statement should be shown

 #add more validation to the cases in last testcase
  @Functional
  Scenario:    Verification of Account Customer Demographics
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to Account Customer Demographics
  Then         Make sure that Account Customer Demographics should be shown

  @Functional
  Scenario:    Verification of Account Statement For One Year
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to Account Statement For One Year
  Then         Make sure that Account Statement For One Year should be shown

  @Functional
  Scenario:    Verification of Account Today Transaction Statement
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to Account Today Transaction Statement
  Then         Make sure that Account Statement today should be shown

  @Functional
  Scenario:    Verification of Accounts List
  Given        User is on the login page
  When         User enter valid username
  And          User enter valid password
  And          User clicks on the login button
  Then         User should be redirected to Unison Dashboard
  And          User navigates to the Agent Desktop
  And          User closes the active session if there is one already
  When         User selects CNIC from dropdown and enters the CNIC in search box
  And          User attempts to search that CNIC
  Then         Search results should return the customer details
  When         User validates the questionnaire
  And          Click on Transaction Pad
  And          Go to Accounts List
  Then         Make sure that Account list should be shown