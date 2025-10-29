package com.skillio.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public static String getProperty(String filePath, String key) {
		String value = null;
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
}
