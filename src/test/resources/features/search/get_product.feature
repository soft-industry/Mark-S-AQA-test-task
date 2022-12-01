Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/test/{product} for getting the products.
### Available products: "apple", "mango", "tofu", "water"
### Prepare Positive and negative scenarios

  Scenario: Verify requested items displayed
    When user calls endpoint for "apple" product
    Then user sees the results displayed for "apple"
    When user calls endpoint for "mango" product
    Then user sees the results displayed for "mango"
    When user calls endpoint for "tofu" product
    Then user sees the results displayed for "tofu"
    When user calls endpoint for "water" product
    Then user sees the results displayed for "water"

  Scenario: Verify requested items is not displayed
    When user calls endpoint for "car" product
    Then user sees error message "Not found"
