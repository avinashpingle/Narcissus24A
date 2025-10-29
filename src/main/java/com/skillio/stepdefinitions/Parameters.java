package com.skillio.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.skillio.utilities.ExcelUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class Parameters {

	private static final Logger LOG = LogManager.getLogger(Parameters.class);
	
	@Given("I have {string} apples")
	public void acceptApples(String qty) {
		LOG.info("I have " + qty + " apples");
	}

	@Given("I have following fruits:")
	public void acceptListOfFruits(DataTable fruits) {
		LOG.info("I have following fruits:");
		
		Map<String, List> data = fruits.asMap(String.class, List.class);
		for (Map.Entry<String, List> entry : data.entrySet()) {	
			LOG.info(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	@Given("I have a {word} and {word}")
	public void acceptPincode(String pincode, String cityName) {
		LOG.info("I have a pincode: " + pincode);
		LOG.info("I have a cityname: " + cityName);
	}
	
	@Given("I have rownumber as {int}")
	public void acceptPinCodesAndCityName(int rowNumber) {
		 Object[] row =	ExcelUtil.readExcelRow("/Users/avinashpingale/Documents/Narcissus24A/pincodes.xlsx", "pincodes",rowNumber,1);
		 LOG.info("I have a pincode: " + row[0]);
		 LOG.info("I have a cityname: " + row[1]);
		 	
	}
}
