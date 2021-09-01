##Author:Luisa Fernanda Colorado
#encoding:iso-8859-1

Feature: REST service countries
  Consume Rest service in order to get list of countries

  Scenario: Consume service countries
    Given consume countries service
    When get data list of countries
    Then should save all data countries in file