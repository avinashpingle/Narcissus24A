package com.skillio;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = "com.skillio", dryRun = false)
public class FeatureRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}
}
