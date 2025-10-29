package com.skillio;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.skillio.base.TestBase;
import com.skillio.pages.HomePage;
import com.skillio.utilities.PropUtil;
import com.skillio.utilities.WaitFor;

import static com.skillio.base.Keyword.*;

/**
 * This class mentions all test cases on home page of {@link www.redbus.in}
 */
public class BusTicketsTestCases {

	public void verifyErrorMessageWhenUserSelectsSameCityForFromAndToTxtBx() throws InterruptedException {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.redbus.in");
		driver.findElement(By.cssSelector("div[class*='AndSwapWrapper']>div[class*='srcDestWrapper']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.inputField___44481d")).sendKeys("Swargate");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.searchCategory___993266>div.listItem___9a15c0:nth-child(1)")).click();
		Thread.sleep(3000);
		
		//driver.findElement(By.cssSelector("div.inputsWrapper___4655bd div.srcDestWrapper___e67e69:nth-child(2)  div[class*='labelCityWrapper']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("input.inputField___44481d")).sendKeys("Swargate");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.searchCategory___993266>div.listItem___9a15c0:nth-child(1)")).click();
		driver.findElement(By.cssSelector("button[class*='searchButtonWrapper']")).click();
		String errorMessage = driver.findElement(By.cssSelector("div.message___48c25c")).getText();
		
		Assert.assertEquals(errorMessage, "Source and Destination city cannot be same");
	}

	/*
	@Test
	public void verifyErrorMessageWhenUserSelectsSameCityForFromAndToTxtBxUsingKeyword() throws InterruptedException {
		clickOnElement(Locators.getLocator("fromDiv"));
		
		WaitFor.presenceOfElement(By.cssSelector(fromTxtBx));
		enterText(fromTxtBx, "Swargate");
		Thread.sleep(3000);
		clickOnElement(toDiv);
		Thread.sleep(3000);
		enterText(toTextBx, "Swargate");
		Thread.sleep(3000);
		clickOnElement(fromListItem);
		clickOnElement(searchBtn);
		String errMsg = getText(errorMsg);
		Assert.assertEquals(errMsg, "Source and Destination city cannot be same");
		
	}
	*/
	
	public void verifyErrorMessageWhenUserSelectsSameCityForFromAndToTxtBxUsingPOM() {
		HomePage homepage = new HomePage();
		homepage.clickOnFromDiv();
		homepage.enterFromCityName("Swargate");
		homepage.selectFromCity();
		homepage.enterToCityName("Swargate");
		homepage.selectToCity();
		homepage.verifyErrorMessage();
	}
	
	
	
	
}
