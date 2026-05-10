package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageDM extends BasePageDM {

	public LoginPageDM(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@id='login2']")
	WebElement loginPageElement;
	
	@FindBy(xpath="//div[@id='logInModal']//div[@class='modal-header']")
	WebElement loginForm;
	
	@FindBy(xpath="//input[@id='loginusername']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement loginButton;
	
	public void loginTest(String uname,String upass)
	{
		wait.until(ExpectedConditions.visibilityOf(loginPageElement)).click();
		wait.until(ExpectedConditions.visibilityOf(loginForm));
		username.sendKeys(uname);
		password.sendKeys(upass);
		loginButton.click();
	}
	
	public void invalidloginTest(String uname,String upass)
	{
		wait.until(ExpectedConditions.visibilityOf(loginPageElement)).click();
		wait.until(ExpectedConditions.visibilityOf(loginForm));
		username.sendKeys(uname);
		password.sendKeys(upass);
		loginButton.click();
	}
	
	public String landingPage()
	{
		return loginPageElement.getText();
	}

}
