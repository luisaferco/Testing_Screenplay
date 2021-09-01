##Author:Luisa Fernanda Colorado
#encoding:iso-8859-1

@driver:iexplorer
Feature: Rest Service typecode
  Online Smart in order allow users learning english and order virtual lesson plan
  they need complete billing details to pay the offers

  Background: Enter to smart page
    Given Sam enter to smart page

  Scenario: The complete billing details to studying through lesson plan virtual
    When go to online store to add shopping cart english lesson plan level A1
    And Sam complete billing details
    Then should see details pay lesson