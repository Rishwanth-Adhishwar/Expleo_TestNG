package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By titleText=By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
	By username=By.xpath("//input[@name='username']");
	By password=By.xpath("//input[@name='password']");
	By loginButton=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setUserName(String strUserName)
	{
		driver.findElement(username).sendKeys(strUserName);
	}
	
	public void setUserPassword(String strUserPassword)
	{
		driver.findElement(password).sendKeys(strUserPassword);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	public String getLogin()
	{
		return driver.findElement(titleText).getText();
	}
	
	public void login(String strUserName,String strUserPassword)
	{
		this.setUserName(strUserName);
		this.setUserPassword(strUserPassword);
		this.clickLogin();
	}

}
