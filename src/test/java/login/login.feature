Feature: Login functionality

  Scenario Outline: Valid login
    Given navigated to login page
    When valid "<username>" and "<password>" are entered
    And clicked on submit button
    Then user's home page is displayed

    Examples:
    |username           | password          |
    |standard_user      |secret_sauce       |
    |locked_out_user    |secret_sauce       |
    |problem_user       |sesecret_sauce     |
    |performance_glitch_user|secret_sauce   |



  Scenario: Invalid login
    Given navigated to login page
    When invalid username and password are entered
    And clicked on submit button
    Then error message will be displayed