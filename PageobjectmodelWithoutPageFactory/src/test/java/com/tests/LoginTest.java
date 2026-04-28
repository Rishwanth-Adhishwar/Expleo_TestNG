package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest {
 
	@Test(priority=0)
	public void loginTest()
	{
		lp =new LoginPage(driver);
		
		String loginPageTitle =lp.getLogin();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		
	}
}
