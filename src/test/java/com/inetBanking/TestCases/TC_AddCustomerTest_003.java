package com.inetBanking.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.AddCustomerPage;
import com.inetBanking.PageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass{
	@Test
	public void AddNewCust() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(UserName);
		lp.setPwd(UserPwd);
		lp.clickLogin();
		
		Thread.sleep(2000);
		
		AddCustomerPage acp = new AddCustomerPage(driver);
		
		acp.linkaddCustomer();
		acp.CustomerName("Rajaneesh");
		acp.CustomerGender();
		acp.CustomerDob("27", "11", "1998");
		acp.CustomerAddress("Bangalore");
		acp.Customercity("Managlore");
		acp.Customerstate("Karnataka");
		acp.CustomerPin("578908");
		acp.CustomerPhone("7898765645");
		String mailId = randomstring()+"@gmail.com";
		acp.CustomerMailId(mailId);
		acp.CustomerSubmit();
		
		
				
	}
	
	public Boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	public String randomstring() {
		String generated = RandomStringUtils.randomAlphabetic(9);
		return generated;
	}

}
