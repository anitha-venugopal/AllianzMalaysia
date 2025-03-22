Feature: Test functionality of Travel Insurance Plan during flight ticket booking

  Scenario Outline: User books a flight ticket and verifies the Insurance Plus plan during checkout
    Given User is on the Home Page
    And User sets From destination "<FromDestination>"
    And User sets To destination "<ToDestination>"
    Then User selects Depart date "<departDate>"
    Then User selects Return date "<returnDate>"
    And User clicks on the Home Page Search button
    Then User navigates to the Flights Search Page
    Then User selects departing flight "<departingFlight>"
    Then User selects returning flight "<returningFlight>"
    And User clicks on Continue as Guest button
    Then User navigates to the Checkout Page
    When User selects Insurance Plus from the list of options available
    Then The Insurance Plus Add-on price should be reflected in the Fare

    Examples: 
      | FromDestination                         | ToDestination                           | departDate | returnDate |  
      | Kuala Lumpur International Airport      | Don Mueang International Airport        | 29/03/2025 | 04/04/2025 |

  Scenario Outline: User books a flight ticket and verifies the Insurance Lite plan during checkout
    Given User is on the Home Page
    And User sets From destination "<FromDestination>"
    And User sets To destination "<ToDestination>"
    Then User selects Depart date "<departDate>"
    Then User selects Return date "<returnDate>"
    And User clicks on the Home Page Search button
    Then User navigates to the Flights Search Page
    Then User selects departing flight "<departingFlight>"
    Then User selects returning flight "<returningFlight>"
    And User clicks on Continue as Guest button
    Then User navigates to the Checkout Page
    When User selects Insurance Lite from the list of options available
    Then The Insurance Lite Add-on price should be reflected in the Fare

    Examples: 
       | FromDestination                         | ToDestination                          | departDate | returnDate|  
      | Kuala Lumpur International Airport      | Don Mueang International Airport        | 29/03/2025 | 04/04/2025 |