Feature: Test1

  Scenario Outline: Choosing destination and all other reference
    Given I am on booking home page
    When I change language to "<language>"
    And I add destination "<destination>"
    And I add start and end date "<startDate>" "<endDate>"
    And I will increase num of kids by one and I will select age
    And I will will click on search button
    Then I will see results of my choosen destination

    Examples:
      | language |  | destination |  | startDate        |  | endDate        |
      | Srpski   |  | Kopaonik    |  | 31 decembar 2021 |  | 30 januar 2022 |
#                | Zlatibor    |  | 20 januar 2022 |   |10 februar 2022|
#                 | Beograd     |  | 30 januar 2022 |   |20 februar 2022|

