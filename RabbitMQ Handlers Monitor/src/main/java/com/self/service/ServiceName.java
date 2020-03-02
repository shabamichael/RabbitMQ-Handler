package com.self.service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//This class create a new File if it does not exist
public class ServiceName {
	
	private static String serviceName ;

	

	public ServiceName(String ServiceName) {
		this.serviceName = ServiceName;
	}
	public static String getServiceName() {
		return serviceName;
	}

	public static void setServiceName(String serviceName) {
		ServiceName.serviceName = serviceName;
	}
	
	
}
