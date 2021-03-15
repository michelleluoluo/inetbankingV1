package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;


public class TC_AddCustomerTest_003 extends BaseClass{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		
		addcust.clickAddNewCustomer();
		
		addcust.setCustomerName("Michelle");
		addcust.setCustomerGender("female");
		addcust.setCustomerDob("13", "03", "1980");
		Thread.sleep(3000);
		addcust.setCustomerAddress("80 eoiut street");
		addcust.setCustomerCity("Melbourne");
		addcust.setCustomerState("Vic");
		addcust.setCustomerPin(353423);
		addcust.setCustomerPhone("9387934867");
		addcust.setCustomerPwd("111111");
		
		String email = randomestring() + "@gmail.com"; 
		addcust.setCustomerEmail(email);
		
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res ==  true)
		{
			Assert.assertTrue(true);
			logger.info("Login passed111");
		}
		else {
			
			System.out.println("add customer failed");
			captureScreen(driver, "addNewCustomer");
			 logger.warn("Login failed");
			 Thread.sleep(10000);
			Assert.assertTrue(false);
		}
		
	}

}
