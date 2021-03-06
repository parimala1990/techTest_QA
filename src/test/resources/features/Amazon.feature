@test_id01

Feature: Validate payment failure functionality

  Scenario: User add item to the basket,proceed to checkout and validate the failure reason in payment methods
    Given I login into amazon with valid credentials
    And I search for product "Mac cosmetics"
    And I select item "Mac Retro matte lipstick 3 g, Ruby Woo"
    And I add item to the cart to proceed to checkout
    When I select a payment method as Gift card
      | giftCardNumber      |
      | 3456 7898 000 56712 |
    Then I verify error alert is displayed
    And I should see "The promotional code you entered is not valid." error message


