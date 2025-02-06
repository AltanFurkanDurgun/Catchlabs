@test
Feature: Add money test process

  Background:
    Given User navigate to login page
    Then Verify that the user should be on login page
    When User can login
    Then Verify that the user should be on home page
    When User can click open money transfer button
    Then Verify that the user should be on money transfer page
    When User can click add money button
    Then Verify that the user should be on add money page

  @addMoney
  Scenario: User can add money and verify amount
    When User can enter card number
    And User can enter card holder
    And User can enter expiry date
    And User can enter cvv code
    And User can enter amount
    And User can click add button
    Then Verify that the user should be see total amount is correct
    And Verify that the user should be see amount is correct in transactions place

  @warningMessageControl
  Scenario: User cannot empty card information
    When User can click add button
    Then Verify that the user should be see all "Required" warning message
    When User can enter "1" on card number input box
    Then Verify that the user should be see "Too Short!" warning message on card number input box
    When User can enter "abc" on card holder input box
    Then Verify that the user should be see "Too Short!" warning message on card holder input box
    When User can enter "1" on expiry date input box
    Then Verify that the user should be see "Wrong date. Please give a correct date" warning message on expiry date input box
    When User can enter "1" on cvv input box
    Then Verify that the user should be see "Too Short!" warning message on cvv input box





