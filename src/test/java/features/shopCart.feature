Feature: Shop Cart page 

Scenario: Verify items are added in the cart 
	Given Open Chrome and go to "http://jupiter.cloud.planittesting.com" 
	When Go to shop page from home page and click two times on Funny Cow and one time on Fluffy Bunny 
	And Click on Cart Menu 
	Then Validate Items are in the Cart 
