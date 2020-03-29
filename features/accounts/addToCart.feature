# new feature
# Tags: optional

Feature: Add Product To Shopping Basket

  Background:
    Given John is on the login page
  @addToCart
  Scenario Outline: Successful Add To Cart
    When John navigate to "Women" menu
    And then John selected to "<article>" product
    And then choose its quantity,size and color and submitted to cart:
      | article   | quantity   | size   | color   |
      | <article> | <quantity> | <size> | <color> |
    Then he should see what has ordered on the Shopping Cart Summary Page:
      | article   | quantity   | size   | color   |
      | <article> | <quantity> | <size> | <color> |
    Examples:
      | article                     | quantity | size | color |
      | Faded Short Sleeve T-shirts | 2        | L    | Blue  |

