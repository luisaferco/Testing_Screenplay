##Author:Luisa Fernanda Colorado
#encoding:iso-8859-1

Feature: REST service users
  Consume rest service in order to get data users as list

  Scenario: Consume resource users
    Given consume typecode service
    When get data user
    Then should save data in file