package com.skillio.base;


import com.skillio.utilities.PropUtil;

/**
 * This class reads the proeperties from Environment.properties file
 */
public class Environment {

	public static String getBrowserName() {
		String baseDir = System.getProperty("user.dir");
		return PropUtil.getProperty(baseDir+"/src/main/resources/Environment.properties", "browser_name");
	}
	
	public static boolean isOnGrid() {
		String baseDir = System.getProperty("user.dir");
		return Boolean.parseBoolean(PropUtil.getProperty(baseDir+"/src/main/resources/Environment.properties", "isOnGrid"));
	}
	
	
}
