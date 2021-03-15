package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
//	
	public String baseURL = readconfig.getBasepath();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

//	public String baseURL = "http://demo.guru99.com/v4/";
//	public String username = "mngr311772";
//	public String password = "sUhUmyg";

	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

//		BasicConfigurator.configure();
		logger = LogManager.getLogger("BaseClass");
		PropertyConfigurator.configure(
				"/Users/andihan/Documents/ALAN/jobs/eBanking/inetBankingV1/src/test/resources/log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/andihan/Documents/ALAN/jobs/seleniumJava /driver/chromedriver");
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/andihan/Documents/ALAN/jobs/seleniumJava /driver/geckodriver");
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
//			System.setProperty("webdriver.ie.driver","/Users/andihan/Documents/ALAN/jobs/seleniumJava /driver/geckodriver");
//			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.get(baseURL);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		
		String timesStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = tname + timesStamp + ".html";
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + repName + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	
	public String randomeNum()
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

}
