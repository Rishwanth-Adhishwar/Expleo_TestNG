package com.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
	
	public static WebDriver driver;
	LoginPage lp;
	DashBoardPage dp;

	@BeforeClass
	public void setup() {
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterClass
	public void close() {
		if(driver!=null)
		{
			driver.quit();
		}
		
	}

}
