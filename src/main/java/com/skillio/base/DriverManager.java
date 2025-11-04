package com.skillio.base;

import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * This class will manage the WebDriver instances using ThreadLocal for parallel execution.
 */
public class DriverManager {

	private static ThreadLocal<RemoteWebDriver> driverThreadLocal = new ThreadLocal<>();

	public static void setDriver(RemoteWebDriver driver) {
		driverThreadLocal.set(driver);
		
	}

	public static RemoteWebDriver getDriver() {
		return driverThreadLocal.get();
	}

	public static void removeDriver() {
		driverThreadLocal.remove();
	}
}
