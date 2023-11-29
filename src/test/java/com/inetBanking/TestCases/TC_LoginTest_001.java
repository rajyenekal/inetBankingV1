package com.inetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		
		logger.info("Navigated to URL");
	
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(UserName);
		logger.info("Entered User Name");
		lp.setPwd(UserPwd);
		logger.info("Entered Password");

		lp.clickLogin();
		
		

		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Successfully Login");

		}
		else {
			CaptureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Failed to Login");

		}
	}

}
