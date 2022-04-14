@regression @smoke

Feature: Validating select and edit add row timesheet functionalities

#  Background: Repeated first steps in each scenario
#    Given user send username "Admin" and password "admin123"
#    When user navigates to "My Timesheets" page

  @MB4-141

  Scenario: Validating select timesheet for week dropdown
    Given user send username "Admin" and password "admin123"
    When user navigates to "My Timesheets" page
    And user chooses and clicks one of the "weeks" weeks from dropdown
    Then user validates the desired "2022-04-11 to 2022-04-17" week is selected

  @MB4-145

  Scenario:  Validating edit add row timesheet functionality
    Given user send username "Admin" and password "admin123"
    When user navigates to "My Timesheets" page
    And user adds a row to the week
      | Project Name                                   | Activity Name | Mon 4 | Tue 5 | Wed 6 | Thu 7 | Fri 8 | Sat 9 | Sun 10 |
      | Global Corp and Co - Global Software phase - 2 | QA Testing    | 8     | 3     | 2     | 3     | 4     | 0     | 0      |
    Then user validates the row is added