package com.skillio.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class TestBase {

	
	@Before
	public void setup() {
		Keyword.openBrowser("Firefox");
		Keyword.launchUrl("https://www.redbus.in");
	}
	
	@After
	public void teardown() {
        Keyword.closeBrowser();
    }
}
