@demoQA
Feature: Handle all alerts type

  Background:
    Given The user goes to ToolsQA url
    When The user click the "Alerts, Frame & Windows" module and clicks on "Alerts" tag


  Scenario:Display alert message
    Then Handling the Click Button to See alert


  Scenario: Alert will appear after 5 seconds
    Then Handling the Click Button appears after 5 seconds alert


  Scenario: Confirm box will appear
    Then Handling the confirm box appear alert


  Scenario: Prompt box will appear
    Then Handling prompt box appear alert
