Feature: user should not be able to log in with invalid credentials or empty field

  Background:
    Given user is on homepage

  @category
  Scenario Outline: User should not be able to log in with invalid credentials


    When user enters username as "<Username>" and password as "<Password>"
    And user clicks on Login
    Then user should see "<ErrorMessage>"
    Examples:
      | Username | Password | ErrorMessage                        |
      | Test     | Test1234 | Invalid Credentials                 |
      | Test     | Test123  | Invalid Credentials                 |
      | Test     | Test134  | Invalid Credentials                 |
      | test     | Test1234 | Invalid Credentials                 |
      | Test1    | test1234 | Invalid Credentials                 |
      | Test     |          | Password cannot be empty            |
      |          | Test1234 | Username cannot be empty            |
      |          |          | Username & Password cannot be empty |
     