package com.project.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class readconfig {


	Properties prop;

	public readconfig() {
		try {		
			InputStream input=new FileInputStream("C:\\Users\\akash\\git\\mystore\\projectdemo2\\configuration\\config.properties");
			prop=new Properties();
			prop.load(input);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	public String brow() {
		return prop.getProperty("browser");
	}
	public String user() {
		return prop.getProperty("username");
	}
	
	public String pass() {
		return prop.getProperty("password");
	}
	
	
}
