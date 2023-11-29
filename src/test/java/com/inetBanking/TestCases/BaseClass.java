package com.inetBanking.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig rconf=new ReadConfig();
	
	public String BaseUrl=rconf.GetAppUrl();
	public String UserName=rconf.GetUserName();
	public String UserPwd=rconf.GetPwd();
	public String path=rconf.GetXlPath();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br) {
		
		logger= Logger.getLogger("inetBanking");
		
		PropertyConfigurator.configure("log4j.properties");
		
		
		
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		
		if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(BaseUrl);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts= (TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	File target=new File(System.getProperty("user.dir")+"/Screenshots/"+ tname +".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot Captured");
	
	}
}
