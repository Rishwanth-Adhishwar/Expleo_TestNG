package com.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashboardPageDM;
import com.pages.LoginPageDM;
import com.utils.ExcelDataProviderDM;

public class DashboardTestsDM  extends BaseTestsDM{
	
	
	
	@Test(dataProvider="valid",dataProviderClass=ExcelDataProviderDM.class,priority=1)
	public void dashBoardTestvalid(String un,String up)
	{
		log.info("Testing With Valid Data");
		WebDriver driver=getDriver();
		LoginPageDM lp=new LoginPageDM(driver);
		log.info("sending username and password from excel");
		lp.loginTest(un,up);
		DashboardPageDM dp=new DashboardPageDM(driver);
		String c2=dp.getHomePageTexts();

		Assert.assertEquals(c2, "Log out");
		log.info("login Successfull with valid Credentials");

//		try
//		{
//			
//		}
//		catch(AssertionError e)
//		{
//			log.error("Login UnsucessFull with valid credentials: "+e.getMessage());
//		}
		

	}
	
	@Test(dataProvider="invalid",dataProviderClass=ExcelDataProviderDM.class,priority=2)
	public void dashBoardTestinvalid(String un,String up)
	{
		log.info("Testing With invalid Data");
		WebDriver driver=getDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(15));
		LoginPageDM lp=new LoginPageDM(driver);
		log.info("sending username and password from excel");
		lp.invalidloginTest(un,up);
		
		try
		{
			log.info("Waiting for alert");
			w.until(ExpectedConditions.alertIsPresent());
			log.info("Switching to Alert");
			Alert alt=driver.switchTo().alert();
			log.info("Alert Accepted");
			alt.accept();
		}catch(Exception e)
		{
			log.error("Test Failed For invalid Credentials: "+e.getMessage());
		}
		

	}

}
