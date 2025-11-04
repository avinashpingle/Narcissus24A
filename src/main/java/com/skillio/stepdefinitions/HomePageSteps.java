package com.skillio.stepdefinitions;

import java.net.MalformedURLException;

import com.skillio.base.Keyword;
import com.skillio.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	@Given("ब्राउज़र खुलेगा और रेड बस की यूआरएल ओपन रहेगी")
	public void launchAppUrl() throws MalformedURLException {
		Keyword.openBrowser("Firefox");
		Keyword.launchUrl("https://redbus.in");
	}
	
	@When("User enters from city as Swargate")
	public void enterFromCity() {
		HomePage homepage = new HomePage();
		homepage.clickOnFromDiv();
		homepage.enterFromCityName("Swargate");
		homepage.selectFromCity();
	}
	
	@And("To city as Swargate")
	public void enterToCity() {
		HomePage homepage = new HomePage();
		homepage.enterToCityName("Swargate");
	}
	
	@Then("User should get an error message")
	public void verifyErrorMessage() {
		HomePage homepage = new HomePage();
		homepage.verifyErrorMessage();
	}
}
