##Author:Luisa Fernanda Colorado
#encoding:iso-8859-1

Feature: Online Linio Store
  Online Store in order allow users to add to cart technology articles
  they need add to cart selected articles that user wish to purchase

  Background: User enters to web page
    Given Tina enters to at the Linio web store

Scenario: Tina adds products consoles and video games category products to the shopping cart
  When she add products from consoles and video games category
  Then she should see all products on shopping cart


Scenario: Tina adds several quantity of the same product to shopping cart
  When she adds the products from sport category into Motorsports section
    |name                  |quantity|
    |Tula moto Impermeable |5       |
  Then she should see total price of the 5 articles on the shopping cart


Scenario: Tina looks for clothes in to fashion section with several features
  When she search products from Fashion section
  And she search by following properties
    |brand |priceRangeFrom|priceRangeTo|shipment|color  |
    |Adidas|15000         |400000      |Nacional|Blanco |
  And she sorts for lower price
  When Tina adds to shopping cart the first product found
  Then she should see the product to shopping cart

Scenario: Tina cleans the shopping cart
  Given Tina add several products to shopping cart
    |name                                    |quantity|
    |Videojuego Fifa 21                      |1       |
    |BT Nintendo Switch Neon Con Juego Mario |1       |
    But she decides remove all products of the shopping cart
  Then she should not see any products in to list
