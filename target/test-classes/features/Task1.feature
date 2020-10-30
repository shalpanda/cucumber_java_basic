@regression
Feature: Task 1

  @debugs


  Scenario Outline: scenario outline for error cases
    Given I am on Enter a number page
    When I enter number: "<number>"
    And I click Submit
    Then I see Error: "<error>"
    Examples:
      | number | error                         |
      | 1      | Number is too small           |
      | 35     | Number is too small           |
      | 101    | Number is too big             |
      | abc    | Please enter a number         |

  @debugs


  Scenario Outline: scenario outline for correct numbers
    Given I am on Enter a number page
    When I enter number: "<number>"
    And I click Submit
    Then I see result: "<Result>"
    Examples:
      | number | Result                             |
      | 50     | Square root of 50 is 7.07          |
      | 66     | Square root of 66 is 8.12          |
      | 88     | Square root of 88 is 9.38          |


