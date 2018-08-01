Feature: Search Action

Scenario: Should Be Able To Search By Keyword
	Given I am on the store homepage
	When I search by keyword
	Then I should be taken to the exact store page for the keyword
	
Scenario: Should Be Able To Search By Manfacturer Part Number
	Given I am on the store homepage
	When I search by manufacturer part number
	Then I should be taken to the exact store page for the manufacturer part number
	
Scenario: Should Be Able To Search By RS Part Number
	Given I am on the store homepage
	When I search by RS Part Number "847-7672"
	Then I should be taken to the exact store page for rs number "847-7672"