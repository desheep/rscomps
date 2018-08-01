Feature: Checkout Action

Scenario: Should Be Able To Checkout A Basket Item From User Account
	Given I am on the store homepage
	When I login as my test user
	And I add a product to my basket
	And I try to checkout
	Then I should see the checkout address page
	
Scenario: Should Be Able To Checkout A Basket Item From guest Account
	Given I am on the store homepage
	When I add a product to my basket
	And I try to checkout
	Then I should be able to create a guest account 
	And I should see the checkout address page