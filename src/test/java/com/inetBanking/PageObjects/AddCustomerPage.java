package com.inetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]")
	@CacheLookup
	WebElement linkAddCustomer;
	
	@FindBy(name  = "name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(xpath = "(//input[@name=\"rad1\"])[1]")
	@CacheLookup
	WebElement CustomerGender;
	
	@FindBy(name =  "dob")
	@CacheLookup
	WebElement CustomerDob;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement CustomerAddress;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement Customercity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement Customerstate;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement CustomerPin;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement CustomerPhone;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement CustomerMailId;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement CustomerSubmit;
	
	public void linkaddCustomer() {
		linkAddCustomer.click();
	}
	
	public void CustomerName(String name) {
		CustomerName.sendKeys(name);
	}
	
	public void CustomerGender() {
		CustomerGender.click();
	}
	
	public void CustomerDob(String mm,String dd,String yy) {
		CustomerDob.sendKeys(mm);
		CustomerDob.sendKeys(dd);
		CustomerDob.sendKeys(yy);
		
	}
	
	public void CustomerAddress(String Address) {
		CustomerDob.sendKeys(Address);
	}
	
	public void Customercity(String City) {
		Customercity.sendKeys(City);
	}
	
	public void Customerstate(String state) {
		Customerstate.sendKeys(state);
	}
	
	public void CustomerPin(String Pin) {
		CustomerPin.sendKeys(Pin);
	}
	
	public void CustomerPhone(String Phone) {
		CustomerPhone.sendKeys(Phone);
	}
	
	public void CustomerMailId(String Mail) {
		CustomerMailId.sendKeys(Mail);
	}
	
	public void CustomerSubmit( ) {
		CustomerSubmit.click();
	}
}

