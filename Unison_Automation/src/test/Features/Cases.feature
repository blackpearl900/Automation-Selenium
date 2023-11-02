@Cases
Feature:  Cases Module Test
          An agent wants to search a specific case
          in cases module and log a new case also
          validate it

  @Functional
    Scenario:   Cases tab availability
    Given       User is on the login page
    When        User enter valid username
    And         User enter valid password
    And         User clicks on the login button
    And         User click on Cases Tab
    Then        Successful cases screen should be displayed

  @Functional
    Scenario:   Successful cases summary screen displayed
    Given       User is on the login page
    When        User enter valid username
    And         User enter valid password
    And         User clicks on the login button
    And         User click on Cases Tab
    And         Successful cases screen should be displayed
    Then        Successful cases summary screen should be displayed

  @Functional
    Scenario:   Successful Button options displayed in Cases
    Given       User is on the login page
    When        User enter valid username
    And         User enter valid password
    And         User clicks on the login button
    And         User click on Cases Tab
    And         Successful cases screen should be displayed
    Then        Cases screen should contains Add, Download PDF and CSV Buttons on its right top

  @Functional
  Scenario:     Successfully searching via Product
  Given         User is on the login page
  When          User enter valid username
  And           User enter valid password
  And           User clicks on the login button
  And           User click on Cases Tab
  And           User enter details in the search area of product
  Then          Products should be searched and should be shown to user.

  @Functional
  Scenario:     Successful clicking on Cases ticket number
  Given         User is on the login page
  When          User enter valid username
  And           User enter valid password
  And           User clicks on the login button
  And           User click on Cases Tab
  And           User Click on any Cases ticket number
  Then          Successful Cases details screen should be viewed by clicking on Cases ticket number hyperlink from Cases summary screen

  @Functional
  Scenario:     Successful clicking on Cases ticket number
  Given         User is on the login page
  When          User enter valid username
  And           User enter valid password
  And           User clicks on the login button
  And           User click on Cases Tab
  And           User Click on any Cases ticket number
  Then          Make sure to successfully display current state and actor

  @Functional
  Scenario:     Verification of case screen details field verification
  Given         User is on the login page
  When          User enter valid username
  And           User enter valid password
  And           User clicks on the login button
  And           User click on Cases Tab
  And           Successful cases screen should be displayed
  And           User Click on any Cases ticket number
  Then          Make sure to All fields mentioned should be shown to user

  @Functional
  Scenario:    Error should be shown on validation screen
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
  And          click on case
  And          Search case in search area
  And          User click on Next button
  And          User click on submit button
  Then         Make sure that case should display an error

  @Functional
  Scenario:    Make a new Case for a customer
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
  And          click on case
  And          Search case in search area
  And          User click on Next button
  And          User Enter details in the provided fields
  Then         Case should be saved successfully and success message should be shown to user

  @Functional
  Scenario:     Open the recently saved case and change the status of case accordingly
    Given       User is on the login page
    When        User enter valid username of user to whom case has been assigned
    And         User enter valid password
    And         User clicks on the login button
    And         User closes the active session if there is one already
    And         User navigates to the Agent Desktop
    When        User selects CNIC from dropdown and enters the CNIC in search box
    And         User attempts to search that CNIC
    Then        Search results should return the customer details
    When        User validates the questionnaire
    And         click on case only
    When        User navigates to the recently saved case
    And         User changes the status of case from Open to initiated
    And         User closes the active session if there is one already
    And         User logs out and logs in with the assigned case user
    And         User closes the active session if there is one already
    And         User navigates to the Agent Desktop
    When        User selects CNIC from dropdown and enters the CNIC in search box
    And         User attempts to search that CNIC
    Then        Search results should return the customer details
    When        User validates the questionnaire
    And         click on case only
    When        User navigates to the recently saved case
    And         User changes the status of case from initiated to in progress
    And         User closes the active session if there is one already
    And         User logs out and logs in with the assigned case user
    And         User closes the active session if there is one already
    And         User navigates to the Agent Desktop
    When        User selects CNIC from dropdown and enters the CNIC in search box
    And         User attempts to search that CNIC
    Then        Search results should return the customer details
    When        User validates the questionnaire
    And         click on case only
    When        User navigates to the recently saved case
    And         User changes the status of case from in progress to resolved
    And         User changes the status of case from Done to Closed
    Then        corresponding case should be closed


  @Functinal
  Scenario:    Verification for back button - Case
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
  And          click on case
  And          Search case in search area
  Then         Make sure that pop up should disappear and user should be routed to backscreen

  @Functional
  Scenario:    Warning on same case addition
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
  And          click on case
  And          Search case in search area
  And          User click on Next button
  Then         Warning should be provided to the user on logging a similar Case

#working on this.
  @Functional
  Scenario:       Successfully searching via date filter
    Given         User is on the login page
    When          User enter valid username
    And           User enter valid password
    And           User clicks on the login button
    And           User click on Cases Tab
    And           User enter details in the search area of case - Date Filter
    Then          Cases should be displayed

  @Functional
  Scenario:   Successfully download the PDF and CSV
  Given       User is on the login page
  When        User enter valid username
  And         User enter valid password
  And         User clicks on the login button
  And         User click on Cases Tab
  And         Cases screen should contains Add, Download PDF and CSV Buttons on its right top
  And         User click on PDF and CSV button for case
  Then        User using PDF and CSV buttons should download a case file in format of PDF and CSV

  @Functional
  Scenario:      Successfull validation of Activities on Case
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
    And          click on case only
    And          user click on topcase
    Then         Make sure that activity area should be shown

  @Functional
  Scenario:    Successful Case Ticket Number verification
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
  And          click on case only
  Then         Make sure that case should have CA in it



  #@Functional
   # Scenario:   Successful Button options displayed in Cases
    #When        User Login with valid credentials
    #And         User click on Cases Tab
    #And         User is on Cases detail screen
    #Then        Cases screen should contains Add, Download PDF and CSV Buttons on its right top