@test
Feature: User navigate to home page and verify on home page

  @homePage
  Scenario: User navigate to home page. Verify home page
    Given User navigate to login page
    When Verify that the user should be on login page
    When User can login
    Then Verify that the user should be on home page
    When User can click open money transfer button
    Then Verify that the user should be on money transfer page