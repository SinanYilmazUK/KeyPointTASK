@demoQA @wip
Feature: Verify Hover Over functionality

  Background:
    Given The user goes to ToolsQA url
    When The user click the "Widgets" module and clicks on "Tool Tips" tag

  Scenario Outline: Verify that message appears after hovering over
    Then Confirm "<Message>" that appears after hovering
    Examples:
      | Message                         |
      | You hovered over the Button     |
      | You hovered over the text field |



