package com.inetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObjects.LoginPage;
import com.inetBanking.Utilities.XLUtils;

public class TC_DDTTest_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void LoginDDt(String UserNam,String Pw) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(UserNam);
		lp.setPwd(Pw);
		lp.clickLogin();
		
		//Thread.sleep(2000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();///close alert	
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			//Thread.sleep(2000);
			driver.switchTo().alert().accept();///close alert
			driver.switchTo().defaultContent();
			
		}
	}
	
	
	//User defined method to check alert is present or not 
	public Boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	
	String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/TestData.xlsx";
		
		int rownum=XLUtils.getrowCount(path, "Sheet1");
		int colcount=XLUtils.getcellcount(path, "Sheet1", rownum);
		
		String loginData [][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
