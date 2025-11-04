package com.skillio.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Keyword {
	private static final Logger LOG = LogManager.getLogger(Keyword.class);

	public static void openBrowser(String browserName) throws MalformedURLException {
		// For Grid Execution
		RemoteWebDriver driver = null;
		if (Environment.isOnGrid()) {
			FirefoxOptions option = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), option);
			LOG.info("Executing tests on Grid.......!");
		} else {
			LOG.info("Executing tests on Local......!");
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				LOG.info("Chrome browser is opened");
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				LOG.info("Firefox browser is opened");
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				LOG.info("Edge browser is opened");
			} else if (browserName.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
				LOG.info("Safari browser is opened");
			} else {
				throw new Error("Invalid browser name: " + browserName);
			}
		}
		DriverManager.setDriver(driver);
	}

	public static void launchUrl(String url) {
		DriverManager.getDriver().get(url);
		LOG.info("URL is launched");
	}

	public static void closeBrowser() {
		DriverManager.getDriver().close();
		LOG.info("Browser is closed");
	}

	public static void clickOnElement(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	public static void clickOnElement(By toDiv) {
		DriverManager.getDriver().findElement(toDiv).click();
	}

	public static void enterText(String locator, String text) {
		String locatorType = locator.split("##")[0]; // css
		String locatorValue = locator.split("##")[1]; // locator
		enterText(locatorType, locatorValue, text);
	}

	public static WebElement getWebElement(String locatorType, String locatorValue) throws Error {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = DriverManager.getDriver().findElement(By.xpath(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("id")) {
			element = DriverManager.getDriver().findElement(By.id(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("name")) {
			element = DriverManager.getDriver().findElement(By.name(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("css")) {
			element = DriverManager.getDriver().findElement(By.cssSelector(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = DriverManager.getDriver().findElement(By.linkText(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = DriverManager.getDriver().findElement(By.partialLinkText(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("className")) {
			element = DriverManager.getDriver().findElement(By.className(locatorValue));
			LOG.info("Element is clicked");
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = DriverManager.getDriver().findElement(By.tagName(locatorValue));
			LOG.info("Element is clicked");
		} else {
			throw new Error("Invalid locator type: " + locatorType);
		}

		return element;
	}

	public static void enterText(String locatorType, String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public static String getText(String locator) {
		String locatorType = locator.split("##")[0]; // css
		String locatorValue = locator.split("##")[1]; // locator
		return getText(locatorType, locatorValue);
	}

	public static String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).getText();
	}
}
