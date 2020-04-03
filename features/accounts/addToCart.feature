# new feature
# Tags: optional

Feature: Add Product To Shopping Basket

  Background:
    Given John is on the home page

  @addToCart
  Scenario: Successful Add To Cart
    When John adds products from "WOMEN" catalog to his cart with the following details:
      | article                     | quantity | size | color  |
      | Faded Short Sleeve T-shirts | 2        | L    | Blue   |
      | Printed Dress               | 3        | M    | Orange |
    Then he should see what has ordered on the Shopping Cart Summary Page:





