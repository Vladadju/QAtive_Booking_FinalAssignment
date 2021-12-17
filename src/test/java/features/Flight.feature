Feature: Test Flight

  Scenario Outline: Booking flight with all reference
    Given I am on a booking home page
    When I will click on flight button end enter in flight page
    And I will enter destination from "<destinationFrom>"
    And I will enter destination to "<destinationTo>"
    And I will enter dates "<startDate>" "<endDate>"
    And I will enter flying class
    And I will select numb of passengers
    And I will click on search button
    Then I will se results of my choices flight tickets

    Examples:
      | destinationFrom |  | destinationTo |  | startDate  |  | endDate    |
      | Rome            |  | Belgrade      |  | January 10 |  | January 17 |


