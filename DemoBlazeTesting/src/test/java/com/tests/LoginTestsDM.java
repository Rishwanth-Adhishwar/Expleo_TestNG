package com.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPageDM;

public class LoginTestsDM extends BaseTestsDM {
	
	
	@Test(priority=0)
	public void landingPageTest()
	{
		WebDriver driver=getDriver();
		LoginPageDM lp=new LoginPageDM(driver);
		log.info("Check Whether Login Page is Displayed ");
		String c1=lp.landingPage();
		try
		{
			Assert.assertEquals(c1,"Log in");
			log.info("login page is Displayed");
		}
		catch(AssertionError e)
		{
			log.error("Invalid Page : "+e.getMessage());
		}
	}
	

}
