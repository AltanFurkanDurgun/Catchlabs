@test
Feature: Edit account page test

  Background:
    Given User navigate to login page
    Then Verify that the user should be on login page
    When User can login
    Then Verify that the user should be on home page
    When User can click open money transfer button
    Then Verify that the user should be on money transfer page
    When User can click edit account button
    Then Verify that the user should be see account name title
    When User can clear account name input box

  @emptyAccountName
  Scenario: User cannot empty account name box
    Then Verify that the user should be see account name text box as empty
    And Verify that the user should be see update button as disable

  @numericValue
  Scenario: User cannot enter numeric input
    When User enter just numeric value on account name input box
    And Verify that the user should be see update button as disable

  @updateAccountName
  Scenario: User can update account name
    When User update account name as text value
    And User can click update button
    Then Verify that the user should be see updated account name on my account place



