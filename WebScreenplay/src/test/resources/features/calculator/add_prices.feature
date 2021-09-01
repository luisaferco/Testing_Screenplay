##Author:Luisa Fernanda Colorado
#encoding:iso-8859-1

Feature: Add prices
  sum of prices of shopping carts

  Scenario: Add total prices
    Given user open calculator
    When sum total prices of shopping
    Then should see total 3683000