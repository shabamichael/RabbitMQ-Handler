package com.self.service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class HandlerMonitor {
	/*
	 * This application is to monitor the RabbitMQ handler services If the handler
	 * process goes down, the application will identify and send an error message to
	 * a log file which can be monitored by App Dynamics
	 * 
	 */
	public static Utilities utils =  new Utilities();
	
	public static final String absoluteFilePath ="C:\\Users\\Michael.Shaba\\Desktop\\MULTICHOICE\\PROJECTS\\SELF SERVICE\\MONITORING\\HANDLERS\\handlers.log";
    private static final Logger logger = Logger.getLogger(HandlerMonitor.class.getName());
	static File file = new File(absoluteFilePath);
	private static String serviceName = utils.getHandlersList();;
	private static String service ;

	private static String STATE_PREFIX = "STATE              : ";
	private String message;

	public static ServiceName sName = new ServiceName(serviceName);

	
	
	public static void main(String[] args) {
		
		
		
		sName.setServiceName(serviceName);
		service = sName.getServiceName();
		
		CreateNewFile();

		try {
			Process process = Runtime.getRuntime().exec("sc query " + serviceName);

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = reader.readLine();
			while (line != null) {
				if (line.trim().startsWith("STATE"))

				{
					if (line.trim().substring(line.trim().indexOf(":") + 1, line.trim().indexOf(":") + 4).trim()
							.equals("1")) {

					System.out.println(currentDate() + "  " + service + " Service " + STATE_PREFIX + "Stopped");
					WriteToFile(currentDate() + "  " + service + " Service " + STATE_PREFIX + "Stopped");
					}
					
					
					else if (line.trim().substring(line.trim().indexOf(":") + 1, line.trim().indexOf(":") + 4).trim()
							.equals("2")) {
						System.out.println("Startting....");

					}
					else if (line.trim().substring(line.trim().indexOf(":") + 1, line.trim().indexOf(":") + 4).trim().equals("3")) {
						System.out.println("Stopping....");
					}
					else if (line.trim().substring(line.trim().indexOf(":") + 1, line.trim().indexOf(":") + 4).trim().equals("4")) {
						System.out.println(
								currentDate() + "  " + service + " Service " + STATE_PREFIX + "Running");
						WriteToFile(currentDate() + "  " + service + " Service " + STATE_PREFIX + "Running");
					}
				}
				line = reader.readLine();
			}

		}

		catch (IOException e1) {
		}
	}
	
    public static void CreateNewFile() {
    	
        try {
        	
        	if (!file.exists())
        	{
        		file.createNewFile() ;
			}
			
		} catch (IOException e) {
		      System.out.println("An error occurred.");
			e.printStackTrace();
		}
	
	}

	public static void WriteToFile(String message) {
	
			FileWriter writer;
			try {
				writer = new FileWriter(file);
				BufferedWriter br = new BufferedWriter(writer);
				br.append(message);
				br.close();
				writer.close();
			} catch (IOException e) {
		System.out.println("An error occurred when writing to the file.");
				e.printStackTrace();
			}
		
			
	
	}
	public static String currentDate() {
		Date dateTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return formatter.format(dateTime);
	}
	
}
