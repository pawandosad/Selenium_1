package com.itlearn.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
Properties pro; // Properties is a class in java that helps to read the properties file.
	
	public ConfigDataProvider()
	{
		File src = new File("./Configuration/config.properties"); // file contractor is using here because everytime when we call this configDataProvider this file will be loaded by default.
		
		try {
			FileInputStream fis= new FileInputStream(src);// here we are trying to get access of file file inside "src".
			
			pro= new Properties();
			
			pro.load(fis); // file is loaded here which is in "fis".
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		} 
	}

	//Once the file is loaded in "pro" now there two methods will help to read the data here.
	public String getBrowser() {
		// TODO Auto-generated method stub
		return pro.getProperty("browser"); //This will help us to get browser details 
	}


	public String getStagingUrl() {
		// TODO Auto-generated method stub
		return pro.getProperty("testurl"); // This will help us to get browser url.
	}
}
