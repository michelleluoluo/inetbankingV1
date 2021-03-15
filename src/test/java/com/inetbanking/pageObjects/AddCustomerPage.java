package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/ul/li[2]/a")
	@CacheLookup
	WebElement InkAddNewCustomer;
	
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	
	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement rdGenderMale;
	
	@FindBy(how = How.XPATH, using = "/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement rdGenderFemale;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCustomerCity;
	
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinno;
	
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailid;
	
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer()
	{
		WebElement eNewcustomer = ldriver.findElement(By.linkText("New Customer"));
		eNewcustomer.click();
//		InkAddNewCustomer.click();
	}
	
	public void setCustomerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void setCustomerGender(String cgender) {
		if(cgender.equals("male"))
		{
			rdGenderMale.click();
		}
		else
		{
			rdGenderFemale.click();
		}
	}
	
	public void setCustomerDob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void setCustomerAddress(String caddress) {
		txtAddress.sendKeys(caddress);
	}

	public void setCustomerCity(String ccity) {
		txtCustomerCity.sendKeys(ccity);
	}
	
	public void setCustomerState(String cstate) {
		txtState.sendKeys(cstate);
	}
	
	public void setCustomerPin(int cpin) {
		txtPinno.sendKeys(String.valueOf(cpin));
	}
	
	public void setCustomerPhone(String cphone) {
		txtTelephoneno.sendKeys(cphone);
	}
	
	public void setCustomerEmail(String cemail) {
		txtEmailid.sendKeys(cemail);
	}
	
	public void setCustomerPwd(String cpassword) {
		txtPassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}

}
