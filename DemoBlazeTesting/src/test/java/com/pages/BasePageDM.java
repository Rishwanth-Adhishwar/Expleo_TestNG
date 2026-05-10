package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageDM {
	
	WebDriver driver;
	WebDriverWait wait;
	public BasePageDM(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
