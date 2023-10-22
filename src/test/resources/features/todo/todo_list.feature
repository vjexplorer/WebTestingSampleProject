@webtest
Feature: Add items to list
  As a busy person
  I would like to make a list of things to do
  So that I can be sure to complete all items in the list

  Rule: Add one or more items to list
    Example: Add single item to a list
      Given Todd has an empty list
      When he adds "Buy some milk"
      Then he see following item on the do to list
      |Buy some milk|
