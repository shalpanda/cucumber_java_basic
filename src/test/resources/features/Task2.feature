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
    #And I select Employee status: "Intern"
    #And I click Add
    #Then A new person is added.

  #Scenario: a new scenario 2 with regex
    #When I enter name: "Bob"
   # And I enter age: 61
    #And I click submit age
   # Then I see message: "Hello, Bob, you are an adult"
