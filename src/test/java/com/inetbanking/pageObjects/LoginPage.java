package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(name = "uid")
	WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "/html/body/div[4]/div/ul/li[10]/a")
	@CacheLookup
	WebElement inkLogout;
	

	public void setUserName(String uname)
	{ 
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		System.out.println("clicksubmit");
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		
		WebElement aboutLink = ldriver.findElement(By.linkText("Log out"));
			System.out.println("clicklogout");
		aboutLink.click();
	
//		inkLogout.click();
//		System.out.println("clicklogout2");
	}
}
