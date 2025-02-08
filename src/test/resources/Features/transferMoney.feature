@test
Feature: Transfer money process

  Background:
    Given User navigate to login page
    Then Verify that the user should be on login page
    When User can login
    Then Verify that the user should be on home page
    When User can click open money transfer button
    Then Verify that the user should be on money transfer page
    When User can click transfer money button
    Then Verify that the user should be see "Sender account" header


  @transferMoney
  Scenario: User can transfer money to account
    And Verify that the user should be see sender account and receiver account
    When User can enter amount for transfer money
    And User can click send button
    Then Verify that the user should be see sender on transactions place
    And Verify that the user should be see receiver on transactions place
    And Verify that the user should be see amount on transactions place
    And Verify that the user should be see total amount on my account place

  @transferMoneyOtherAccount
  Scenario: User can transfer money other receiver account
    When User can change receiver account
    When User can enter amount for transfer money
    And User can click send button
    Then Verify that the user should be see sender on transactions place
    And Verify that the user should be see receiver on transactions place
    And Verify that the user should be see amount on transactions place (otherAccount)

