package com.inetbanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testChrome {
	
	WebDriver driver;
	



	@Test
	public void enterURL() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("/Users/andihan/Documents/ALAN/jobs/seleniumJava /driver/chromedriver"));
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		System.out.println("enter URL");
		
	}


	
}
