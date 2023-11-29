package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		File file=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String GetAppUrl() {
		String url=prop.getProperty("BaseUrl");
		return url;
		
	}
	
	public String GetUserName() {
		String UserName=prop.getProperty("UserName");
		return UserName;
	}
	
	public String GetPwd() {
		String Pwd=prop.getProperty("UserPwd");
		return Pwd;
	}
	public String GetXlPath() {
		String path=prop.getProperty("xlPath");
		return path;
	}
}
