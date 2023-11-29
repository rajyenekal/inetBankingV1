package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name=\"uid\"]")
	@CacheLookup
	WebElement UserId;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	@CacheLookup
	WebElement UserPwd;
	
	@FindBy(xpath = "//input[@name=\"btnLogin\"]")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(xpath = "//a[.='Log out']")
	@CacheLookup
	WebElement LoginOut;
	
	public void setUsername(String Uname) {
		UserId.sendKeys(Uname);
	}
	
	public void setPwd(String Upwd) {
		UserPwd.sendKeys(Upwd);
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}
	
	public void clickLogout() {
		LoginOut.click();
	}
}
