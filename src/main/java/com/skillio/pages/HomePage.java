package com.skillio.pages;

import static com.skillio.base.Keyword.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skillio.base.Keyword;
import com.skillio.utilities.WaitFor;

public class HomePage {

	@FindBy(css = "div[class*='inputAndSwapWrapper'] div[class*='labelCityWrapper']")
	public WebElement fromDiv;
	@FindBy(css = "input#srcDest")
	public WebElement fromTextBx;
	@FindBy(css = "div[class*='searchCategory']>div[class*='listItem']:nth-child(1)")
	public WebElement fromCityName;
	
	//Locator
	public By toDiv = By.cssSelector("i.icon-dropping_point+div");
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFromDiv() {
		fromDiv.click();
		WaitFor.presenceOfElement(fromTextBx);
		System.out.println("Clicked on from dest div tag");
	}
	
	public void waitForFromCityList() {
		WaitFor.presenceOfElement(fromCityName);
	}

	public void enterFromCityName(String cityName) {
		fromTextBx.sendKeys(cityName);
		waitForFromCityList();
		System.out.println("Entered from city name as : "+cityName);
	}

	public void waitForToCity() {
		WaitFor.presenceOfElement(fromTextBx);
	}

	public void selectFromCity() {
		fromCityName.click();
	}

	public void enterToCityName(String string) {
		
	}

	public void waitForToCityList() {
		
	}

	public void selectToCity() {
		
	}

	public void clickOnToDiv() {
		Keyword.clickOnElement(toDiv);
	}

	public void verifyErrorMessage() {
		
	}
}
