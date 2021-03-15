package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import java.io.IOException;

import org.junit.Assert;
//import org.openqa.selenium.WebDriver;


public class TC_LoginTest_001 extends BaseClass{

 @Test
 	public void loginTest() throws InterruptedException, IOException
	{
	 
//		driver.get(baseURL);

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);	
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test is passed");
		}
		else
		{
			
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Test is failed");
		}

		
	}
	
}
