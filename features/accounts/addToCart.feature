# new feature
# Tags: optional

Feature: Add Product To Shopping Basket

  Background:
    Given John is on the login page

  Scenario Outline: Successful Add To Cart
    When John navigate to "Women" menu
    And then John selected to "<article>" product
    And then choose its quantity,size and color and submitted to cart:
      | quantity   | size   | color   |
      | <quantity> | <size> | <color> |
    Then he should see what has ordered on the Shopping Cart Summary Page:
      | quantity   | size   | color   |
      | <quantity> | <size> | <color> |
    Examples:
      | article                     | quantity | size | color |
      | Faded Short Sleeve T-shirts | 2        | L    | Blue  |

