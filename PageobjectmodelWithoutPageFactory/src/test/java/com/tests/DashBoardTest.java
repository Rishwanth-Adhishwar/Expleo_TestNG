package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;


public class DashBoardTest extends BaseTest {
 
	@Test
	public void dashBoardTest()
	{
		lp=new LoginPage(driver);
		lp.login("Admin", "admin123");
		dp=new DashBoardPage(driver);
		String loginCheck=dp.getHomePagetext();
		Assert.assertEquals(loginCheck, "Dashboard");
		System.out.println("login SuccessFul");
	}

}
