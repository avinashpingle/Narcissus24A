#SCRUM-1 Search product functionality
Feature: This feature tests the search product functionality on myntra

Scenario: Search product with only 3 characters
	Given User enters three characters as "lev"
	When a list of products appears
	Then Verify the list of products starts with these 3 letters