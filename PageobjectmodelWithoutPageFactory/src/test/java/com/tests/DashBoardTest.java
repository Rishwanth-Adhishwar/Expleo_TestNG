package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;


public class DashBoardTest extends BaseTest {
 
	@Test(dataProvider="lData",dataProviderClass=com.utils.ExcelDdt.class)
	public void dashBoardTest(String uname,String upass)
	{
		lp=new LoginPage(driver);
		lp.login(uname, upass);
		dp=new DashBoardPage(driver);
		String loginCheck=dp.getHomePagetext();
		Assert.assertEquals(loginCheck, "Dashboard");
		System.out.println("login SuccessFul");
	}

}
