package com.skillio.base;


import com.skillio.utilities.PropUtil;

public class Environment {

	public static String getBrowserName() {
		String baseDir = System.getProperty("user.dir");
		return PropUtil.getProperty(baseDir+"/src/main/resources/Environment.properties", "browser_name");
	}
}
