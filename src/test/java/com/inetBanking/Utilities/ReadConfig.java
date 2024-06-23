package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("exception is"+  e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("AppURL");
		return url;
	}
	
	public String getUsername() {
		String username=pro.getProperty("AppUsername");
		return username;
	}
	
	public String getPassword() {
		String password=pro.getProperty("AppPassword");
		return password;
	}



}
