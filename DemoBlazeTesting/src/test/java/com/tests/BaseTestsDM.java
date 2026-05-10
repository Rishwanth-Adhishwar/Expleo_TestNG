package com.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestsDM {
	
	public static ThreadLocal<WebDriver> driver1 =new ThreadLocal<WebDriver>();
	Logger log=LogManager.getLogger(BaseTestsDM.class);
	public WebDriver getDriver()
	{
		log.info("Getting Driver");
		return driver1.get();
	}
	
	@BeforeMethod
	public void setup()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		log.info("Setting ChromeDriver");
		driver1.set(new ChromeDriver(opt));
		WebDriver driver=getDriver();
		
		log.info("Maximizing Browser Windoe");
		driver.manage().window().maximize();
		log.info("Opening Website Url");
		driver.get("https://www.demoblaze.com/index.html");
	
		
	}
	@AfterMethod
	public void turnDown()
	{
		if(driver1!=null)
		{
			getDriver().quit();
		}
	}

}
