Feature: Search property and verify otp to get the peroperty details

@Smoke
Scenario: Verify search results when 2BHK filter is applied
	When User enters from city as Swargate
	And To city as Swargate
	Then User should get an error message
	
@Regression @Smoke
Scenario: Sample scenario to pass parameter
	Given I have following fruits:
		|Apple|10|Green|
		|Banana|12|Red|
		|Mango|4|Purple|
		|Guava|6|Red|
		|Kiwi|67|Green|
		|Pear|18|Reddish|
		|Orange|7|Green|
		|Peach|4|Yellow|
		
		
Scenario Outline: This is sample data driven test
	Given I have rownumber as <row>
Examples:
	|row|
	|1|
	|2|
	|3|
	|4|
	|5|
	|6|
	|7|
	|8|
	|9|
	|10|
	
	