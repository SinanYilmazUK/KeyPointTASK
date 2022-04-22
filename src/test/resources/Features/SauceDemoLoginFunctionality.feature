
Feature: SauceDemo Login Functionality

  @positiveTest @sauceDemo
  Scenario Outline: <Username> should login with valid credentials
    Given The users should land on login page
    Then The users should login with "<Username>" "<Password>" successfully
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @negativeTest @sauceDemo
  Scenario Outline: The users should not login with invalid credentials
    Given The users should land on login page
    Then The users should not login with "<InvalidUsername>" "<InvalidPassword>"
    Examples:
      | TYPE                  | InvalidUsername         | InvalidPassword |
      | Blank username        |                         | secret_sauce    |
      | Blank password        | standard_user           |                 |
      | Both blank            |                         |                 |
      | Correct only password | wrong_username          | secret_sauce    |
      | Correct only username | standard_user           | wrong_password  |
      | Mixed                 | secret_sauce            | standard_user   |
