package com.skillio.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * This is a step definition class for searching products feature Following are
 * the steps included: Given User enters three characters as "lev" When a list
 * of products appears Then Verify the list of products starts with these 3
 * letters
 */
public class SearchProductsSteps {

	@Given("User enters three characters as {string}")
	public void user_enters_three_characters_as(String threeChars) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("a list of products appears")
	public void a_list_of_products_appears() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Verify the list of products starts with these 3 letters")
	public void verify_the_list_of_products_starts_with_these_3_letters() {
		// Write code here that turns the phrase above into concrete actions
	}

}
