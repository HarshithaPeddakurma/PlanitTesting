Feature: Jupiter Toys page 

Scenario Outline:
Display errors if the mandatory fields are not entered on the contact Page 
	Given Open Chrome and navigate to "http://jupiter.cloud.planittesting.com" 
	When Go to contact page from home page and click on submit button 
	Then Validate Errors 
	And Populate Mandatory fields "<Forename>""<Email>""<Message>" 
	Then Validate Errors are gone 
	
	Examples: 
		|Forename 	      | Email                    |Message		   |
		|Harshitha        |  harshitha.p@gmail.com   |Hi               |
		
Scenario:
Validate successful submission after successful submission of contacts fields 
	Given Populate Mandatory fields 
	When Click submit after entering the data in the Contacts Page 
	Then Validate successful submission 
	
Scenario:
Validate errors after entering invalid data in the mandatory field of Contacts Page 
	Given Click Back button on the successful submission of Contacts page 
	When Populate invalid data in the mandatory field of Contacts Page 
	Then Validate invalid data Errors 
	
	
	
	
	
