Feature: Place Order

Background: User Login
Given User is on login Page
When user enters "standard_user" and "secret_sauce"
Then User should be on Home Page

#@SmokeTest
Scenario: Add Item to Cart
Given User should be on Home Page
When user add item to cart
Then Item must be added

Scenario: Checkout Order
Given User is on Cart Page
When User do Checkout
Then Should navigate to checkout page

#@SmokeTest
Scenario: Delete an Item
Given Cart must have items
When User Delete an item
Then Should delete item from cart
