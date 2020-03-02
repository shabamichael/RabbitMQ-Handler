package com.self.service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Utilities {
	public static final String absoluteFilePath = "C:\\Users\\Michael.Shaba\\Desktop\\MULTICHOICE\\PROJECTS\\SELF SERVICE\\MONITORING\\HANDLERS\\Handlers.properties";

	public String getHandlersList() {
		String handler1 = null;

		Properties prop = new Properties();
		Reader reader;

		//15:44 17/02/2020 List of services
		
		try {
			prop.load(new FileInputStream(absoluteFilePath));
			handler1 = prop.getProperty("handler1");

			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return handler1;
	}

	
	
	/*
	 * public static List<String>getPropertyList(Properties properties, String name)
	 * { List<String> result = new ArrayList<String>(); for (Map.Entry<Object,
	 * Object> entry : properties.entrySet())
	 * 
	 * 
	 * return result;
	 * 
	 * }
	 */

	public static void WhatsAppMessages() {

	}

	public static void smsMessage() {

	}
	
	public static void reConnectHandler() {

	}
	
}
