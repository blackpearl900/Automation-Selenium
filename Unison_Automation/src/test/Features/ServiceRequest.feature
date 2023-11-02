@ServiceRequest
Feature: Service Request Test
  An agent wants to search a specific SR
  Log a new SR and then validate that SR


  @Functional
  Scenario: Make a new service request for a customer
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    Then User should be redirected to Unison Dashboard
    And User navigates to the Agent Desktop
    And User closes the active session if there is one already
    When User selects CNIC from dropdown and enters the CNIC in search box
    And User attempts to search that CNIC
    Then Search results should return the customer details
    When User validates the questionnaire
    #Then View details text should be visible and on clicking it the customer details should be opened
    When User navigates to the new SR button
    And User selects the request they want to make from list
    And User enters all of the required details and save
    Then The newly created SR should be shown in the list


  @Commented
  Scenario: Open the recently saved service request and change the status of SR accordingly
    Given User is on the login page
    When User enter valid username of user to whom SR has been assigned
    And User enter valid password
    And User clicks on the login button
    And User closes the active session if there is one already
    And User navigates to the Agent Desktop
    When User selects relationship number from dropdown and enters the relationship number in search box
    And User attempts to search that relationship number
    Then Search results should return the customer details
    When User validates the questionnaire
    Then View details text should be visible and on clicking it the customer details should be opened
    When User navigates to the recently saved SR
    And User changes the status of SR from initiated to assigned
    And User closes the active session if there is one already
    And User logs out and logs in with the assigned SR user
    And User closes the active session if there is one already
    Then User should be redirected to Unison Dashboard
    When User selects relationship number from dropdown and enters the relationship number in search box
    And User attempts to search that relationship number
    Then Search results should return the customer details
    When User validates the questionnaire
    Then View details text should be visible and on clicking it the customer details should be opened
    When User navigates to the recently saved SR
    And User changes the status of SR from assigned to in progress
    And User closes the active session if there is one already
    And User logs out
    When User enter valid username of user to whom SR has been assigned
    And User enter valid password
    And User clicks on the login button
    And User navigates to the Agent Desktop
    When User selects relationship number from dropdown and enters the relationship number in search box
    And User attempts to search that relationship number
    Then Search results should return the customer details
    When User validates the questionnaire
    Then View details text should be visible and on clicking it the customer details should be opened
    When User navigates to the recently saved SR
    And User changes the status of SR from in progress to Done
    And User changes the status of SR from Done to Closed
    Then corresponding SR should be closed

  @Functional
  Scenario: Service request tab availability
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed



  @Functional
  Scenario: Successful Export PDF and CSV buttons available
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on PDF and CSV button
    Then User using PDF and CSV buttons should download a SR file in format of PDF and CSV



  @Functional
  Scenario: Successful Service Request screen details
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And Export button should be visible
    And Refresh Button should be visible
    And Setting Button should be visible
    And Service Request Number should be visible


  @Functional
  Scenario: Service Request search criteria
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    #Service Requests should be searched based on following criteria
    And Mandatory search fields are Service Request Number, CNIC, Product and Priority etc


  @Functional
  Scenario: Successful Service Request search from Service Request Number
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User Input valid Service Request Number
    Then Successful service Request should be searched from Service Request Number


  @Negative
  Scenario: Unsuccessful Service Request search from Service Request Number
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User Input invalid Service Request Number
    Then Service Request should not be searched from Service Request Number


  @Functional
  Scenario: Successful Service Request search from Customer ID (CNIC)
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User Input valid CNIC
    Then Successful service Request should be searched from Customer ID (CNIC)


  @Negative
  Scenario: Unsuccessful Service Request search from Customer ID (CNIC)
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User Input invalid Customer ID (CNIC)
    Then Service Request should not be searched from Customer ID (CNIC)


  @Functional
  Scenario: Successful Service Request search from Service Type
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User select valid Service Type from drop down
    Then Successful service Request should be searched from Service Typel


  @Functional
  Scenario: Filters options in service request detail screen
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on Filter Tab (Right side of grid)
    And User click on Add Filter
    Then Successful window should be appeared with following dropdowns Field Operator and Value


  @Functional
  Scenario: Successful Filters Search from Contains in service request detail screen
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on Filter Tab (Right side of grid)
    And User click on Add Filter
    And User select option from Fields & Operator dropdown and enter input in Value
    And User click on done and save button
    Then Data according to filters should be displayed


  @Commented #No Search Results Returned
  Scenario: Successful Filters Search from Equal in service request detail screen
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on Filter Tab (Right side of grid)
    And User Add Filter
    And User select option from Fields & Value dropdown
    And User select Equal
    And User click on done
    And User click on save button
    Then Data according to filters should be displayed


  @Commented #No Search Results Returned
  Scenario: Successful Filters Search from Not Equal in service request detail screen
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on Filter Tab (Right side of grid)
    And User Add Filter
    And User select option from Fields & Value dropdown
    And User select Not Equal
    And User click on done
    And User click on save button
    Then Data according to filters should be displayed


  @Commented #No Search Results Returned
  Scenario: Successful Cancel(Cross) filter in service request detail screen
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on Filter Tab (Right side of grid)
    And User Add Filter
    And User select option from Fields & Value dropdown
    And User select Not Equal
    And User click on done
    And User Cancel(Cross) the Filter
    Then All filter data should be revert back to normal


  @Functional
  Scenario: Service Request detail screen
    Given User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on any Service Request
    Then Service Request details screen should be viewed by clicking on Service Request ticket number hyperlink from Service Request summary screen


  @Functional
  Scenario: Successful Call Agent logged service request
    When User login from call agent ID
    And User navigates to the Agent Desktop
    And User closes the active session if there is one already
    When User selects CNIC from dropdown and enters the CNIC in search box
    And User attempts to search that CNIC
    Then Search results should return the customer details
    When User validates the questionnaire
    When User navigates to the new SR button
    And User selects the request they want to make from list
    And User enters all of the required details and save
    Then The newly created SR should be shown in the list


  @Non-Functional
  Scenario: Successful pop-up window appear for change State request
    When User is on the login page
    When User enter valid username
    And User enter valid password
    And User clicks on the login button
    And User click on Service Request Tab
    Then Successful Service request tab should be displayed
    And User click on any Service Request
    And User click on an activity that was performed on the Request
    Then Successful popup window should appear if the user want to move the complaint manually to another user
    Then New activity should appear in a record list on Activity tab on the Request details screen


  @Non-Functional
  Scenario: Successful perform bulk activity (state transitions) in Service request detail screen
    When User Login with valid credentials
    And User click on Service Request tab
    And User is on Request summary/list screen
    And User click on an activity that was performed on the Request
    Then Unison should allows performing bulk activity provided that all the selected Requests are of the same state and type


  @Non-Functional
  Scenario:  Bulk Activity options in service request
    When User Login with valid credentials
    And User click on Service Request tab
    And User is on Service request detail screen
    And User click on an activity that was performed on the Request
    Then bulk activity following flow options should be available
    When User Search Cases by View filter
    And Filter out type and state
    And Click on Bulk change button
    Then User should be choose the desired state
    Then User should be enter mandatory tasks details
    When Upon successful submit
    Then User should be asked for notes for auto assignment
    When Users should be select User and department also in case of manual assignment
    Then On activity completion screen user should be shown a success message


  @Non-Functional
  Scenario: Successful Service Request search from filter
    When  User click on Service Request tab
    And User is on Service request detail screen
    And User Search from filter
    Then Successful user Search Service request by View filter


  @Non-Functional
  Scenario: Unsuccessful Service Request search from filter
    When User click on Service Request tab
    And User is on Service request detail screen
    And User search Invalid data from filter
    Then Service Request should not be Filter out


  @Non-Functional
  Scenario: Bulk change button displayed on Service request detail screen
    When User click on Service request tab
    And User is on Service request detail screen
    Then Successful bulk change button should be visible on screen
    When User select same type and state of Service request
    And User click on bulk button
    Then Successfull bulk change screen should be appeared by selecting same type and state of Service request and states should be available on screen
    And In process
    And Parked
    And Assigned
    And Done


  @Non-Functional
  Scenario: Successful bulk Service request state change into In process
    When User click on Service Request tab
    And User is on Service request detail screen
    And User search from Type and state filter
    And User select the same types and state in service request
    And User click on bulk button
    And User change state to in process
    Then Successful bulk Service request state should change into In process


  @Non-Functional
  Scenario: Successful bulk Service request state change into Assigned
    When User click on Service Request tab
    And User is on Service request detail screen
    And User search from Type and state filter
    And User change state to Assigned
    Then Successful bulk Service request state should changed into Assigned


  @Non-Functional
  Scenario: Successful bulk Service request state change into Done
    When User click on Service Request tab
    And User is on Service request detail screen
    And User search from Type and state filter
    And User change state to Done
    Then Successful bulk Service request state should changed into Done


  @Non-Functional
  Scenario: Successful bulk Service request state change into Parked
    When User click on Service Request tab
    And User is on Service request detail screen
    And User search from Type and state filter
    And User change state to Parked
    Then Successful bulk Service request state should changed into Parked


  @Non-Functional
  Scenario: Mandatory fields data in service request
    When User click on Service Request tab
    And User is on Service request detail screen
    And User select multiple Service request change state
    Then User should enter mandatory tasks details


  @Non-Functional
  Scenario: Notes addition for auto assignment in service request
    When User click on Service Request tab
    And User is on Service request detail screen
    And User select multiple Service request
    And User change the state
    Then Upon changing state user should be asked for add notes for auto assignment


  @Non-Functional
  Scenario: Successful service request Manual assignment in bulk change
    When User click on Service Request tab
    And User is on Service request detail screen
    And User select multiple Service request change state
    Then Users should select user and department and should also in case of manual assignment


  @Non-Functional
  Scenario: Successful message display on bulk state change
    When User click on Service Request tab
    And User is on Service request detail screen
    And User select multiple Service request change state
    Then On activity completion screen user should be shown a success message


  @Non-Functional
  Scenario: Unsuccessful Bulk state change with selection of different states and types
    When User click on Service Request tab
    And User is on Service request detail screen
    And User select different states of Service request
    And User select different Type of Service request
    And User click on Bulk processing button
    Then Proper error should be appeared on screen


  @Non-Functional
  Scenario: Successful warning on same Service Request addition
    When User click on Service Request tab
    And User is on Service request detail screen
    And User Lock multiple Service Request on same searched customer
    Then Successful warning should be provided to the user on logging a similar Service Request


  @Non-Functional
  Scenario: Restriction on same Service Request addition
    When User click on Service Request tab
    And User is on Service request detail screen
    And User Lock multiple Service Request on same searched customer
    Then System should also restrict users to log duplicate Service Request


#    When User is on the Service Request Page
#    And User enters a service no in the search bar and search
#    Then search results should return that SR