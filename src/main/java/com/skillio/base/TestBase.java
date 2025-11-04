package com.skillio.base;

import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class TestBase {

	
	@Before
	public void setup() throws MalformedURLException {
		Keyword.openBrowser("Firefox");
		Keyword.launchUrl("https://www.redbus.in");
	}
	
	@After
	public void teardown() {
        Keyword.closeBrowser();
    }
}
