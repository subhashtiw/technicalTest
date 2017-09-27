Feature: test

@runThis
Scenario: End to end from home page to checkout, from All Products line up
Given user is on the RS Components "home page" 
When user click on All Products drop down 
	And click on Batteries
	And click on Rechargeable Batteries
	And click on Add button in front of the same product
	And click on check out icon 
Then checkout page should be displayed


@runThis
Scenario: End to end from home page to checkout, from New Products line up
Given user is on the RS Components "home page" 
When user click on New Products
	And click on BatteriesNew
	And add Power Bank
	And click on basket icon
	Then checkout page should be displayed

@runThis
Scenario: Search for Power Bank and apply search filter with capacity
Given user is on the RS Components "home page"
When user search for Power Banks
	And click on search button
	And search filter changed to Capacity
	And click apply filter
Then filter is applied
	
@runThis
Scenario: Search for Power Bank and apply search filter with capacity and then remove filter
Given user is on the RS Components "home page"
When user search for Power Banks
	And click on search button
	And search filter changed to Capacity
	And click apply filter
	Then filter is applied
	And filter is removed

@runThis
Scenario: Search for Power Bank and apply multiple search filters from Input Voltage
Given user is on the RS Components "home page"
When user search for Power Banks
	And click on search button
	And search filter changed to Input Voltage
	And click apply filter
Then filter is applied




