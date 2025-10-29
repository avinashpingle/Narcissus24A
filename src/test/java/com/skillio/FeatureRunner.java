package com.skillio;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/Features",
glue = "com.skillio",
tags = "@Smoke",
dryRun=false)
public class FeatureRunner extends AbstractTestNGCucumberTests{

}
