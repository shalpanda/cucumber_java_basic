Feature: Task 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Background:
    Given I am on List of People page

  Scenario: Add a new person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Add
    Then A new person is added.


  Scenario: Edit person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Add
    And I click pencil
    And I change Status: "Employee"
    And I click Edit
    Then Status is changed from Intern to Employee.


  Scenario: Remove person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Add
    And I click Remove
    Then Person is removed.

  Scenario: Reset after adding person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Add
    And I click Reset
    Then Person is removed.

  Scenario: Reset after editing person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Add
    And I click pencil
    And I change Status: "Employee"
    And I click Edit
    And Status is changed from Intern to Employee.
    And I click Reset
    Then Person is removed.

  Scenario: Reset after removing person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Add
    And I click Remove
    And Person is removed.
    And I click Reset
    Then Person is removed.

  Scenario: Clearing on adding new person
    When I click on Add Person
    And I enter Name: "Hazem"
    And I enter Surname: "Shaaban"
    And I enter Job: "Trainee"
    And I enter DoB: "09/03/1996"
    And I select Language: "English"
    And I select Gender: "Male"
    And I select Status: "Intern"
    And I click Clear
    Then All Fields are cleared.