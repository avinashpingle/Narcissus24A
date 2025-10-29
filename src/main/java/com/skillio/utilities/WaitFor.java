package com.skillio.utilities;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skillio.base.Keyword;

public class WaitFor {

	private static final Logger LOG = LogManager.getLogger(WaitFor.class);
	
	static WebDriverWait wait;
	
	static{
		wait = new WebDriverWait(Keyword.driver, Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Script time out");
	}
	
	public static void presenceOfElement(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public static void presenceOfElement(WebElement e) { 
	
		String value  = e.toString();
		LOG.info(value);
		//String locator = value.split(":")[2].trim();
		String text = "Proxy element for: DefaultElementLocator 'By.cssSelector: input#srcDest'";
        Pattern pattern = Pattern.compile("By\\.cssSelector:\\s*([^']+)");
        Matcher matcher = pattern.matcher(text);
        String locator = "";
        if (matcher.find()) {
            LOG.info("Locator: " + matcher.group(1));
            locator=matcher.group(1);
        }
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
	}
	
}
