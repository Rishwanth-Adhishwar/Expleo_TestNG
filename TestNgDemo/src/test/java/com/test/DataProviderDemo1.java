package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo1 {

	private static final ThreadLocal <WebDriver> driver1=new ThreadLocal <WebDriver>();
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Test Started");
		driver1.set(new ChromeDriver());
		driver.get("https://www.bing.com/");
	}

	@Test(dataProvider="testdata",dataProviderClass=DPClass.class)
	public void search(String keyWord1,String keyWord2) {
		
		
		WebElement txtbox=driver.findElement(By.id("sb_form_q"));
		txtbox.sendKeys(keyWord1,keyWord2);
		txtbox.sendKeys(Keys.ENTER);
		System.out.println("Result displayed");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After method Thread ID: "+Thread.currentThread());
		if(driver1!=null)
		{
			driver.quit();
		}
	}

}
