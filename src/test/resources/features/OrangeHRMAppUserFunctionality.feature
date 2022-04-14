@regression
Feature: Validating search and manage user functionality

      # Will run repeated steps that user has in each scenario
  # @Before method will run
  Background: Repeated first steps in each scenario

    Given user navigates to the HRM App
    When user Provides credentials username "Admin" and password "admin123"
    And user Moves to users page

  @MB4-170
  Scenario Outline:
    Then user searches for valid user with data
      | Username   | User Role   | Employee Name   | Status   |
      | <Username> | <User Role> | <Employee Name> | <Status> |
    Then user validates user is shown

    Examples:
      | Username    | User Role | Employee Name | Status  |
      | Aaliyah.Haq | ESS       | Admin A       | Enabled |

       # @After method will run

  @MB4-170-invalid
  Scenario Outline:
    Then user searches for invalid user with data
      | Username   | User Role   | Employee Name   | Status   |
      | <Username> | <User Role> | <Employee Name> | <Status> |
    Then user validates error message "No Records Found" is shown

    Examples:
      | Username    | User Role | Employee Name | Status  |
      | Aaliyah.Haq | Admin     | Admin A       | Enabled |
           # @After method will run