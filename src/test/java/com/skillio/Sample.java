package com.skillio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Sample {

	public static void main(String[] args) throws IOException {
		//How to read properties file

		String baseDir = System.getProperty("user.dir");
		System.out.println(baseDir);
		FileInputStream fis = new FileInputStream(baseDir+"/src/main/resources/Locators.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty("fromDiv");
		System.out.println(value);
	}
}
