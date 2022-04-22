@demoQA
Feature: Drag and drop functionality

  Scenario: Verify source can be droppable to target
    Given The user goes to ToolsQA url
    When The user click the "Interactions" module and clicks on "Droppable" tag
    Then Verify that source item is on the target