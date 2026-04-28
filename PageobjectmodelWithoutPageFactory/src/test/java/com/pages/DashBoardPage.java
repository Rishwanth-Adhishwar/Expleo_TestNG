package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
	WebDriver driver;
	
	By dashboardPageTitle=By.xpath("//h6[normalize-space()='Dashboard']");
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getHomePagetext()
	{
		String t=driver.findElement(dashboardPageTitle).getText();
		return t;
	}

}
