package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPageDM extends BasePageDM{

	public DashboardPageDM(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="#logout2")
	WebElement homePageElement;
	
	public String getHomePageTexts()
	{
		wait.until(ExpectedConditions.visibilityOf(homePageElement));
		return homePageElement.getText();
	}

}
