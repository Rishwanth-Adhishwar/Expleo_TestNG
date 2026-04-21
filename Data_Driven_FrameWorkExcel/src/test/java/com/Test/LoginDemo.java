package com.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.DpExcel;

public class LoginDemo {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("start the test");
		driver.set(new ChromeDriver());
	}
	@Test(dataProvider = "vData", dataProviderClass = DpExcel.class)
	public void loginCheck(String name, String pass) {
		WebDriver driver1 = driver.get();
		driver1.manage().window().maximize();
		driver1.get("https://www.demoblaze.com/");
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
		driver1.findElement(By.id("login2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys(pass);
		driver1.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();
		String expect_login = "Welcome admin";
		WebElement actual_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Welcome admin']")));
		String actual = actual_ele.getText();
		Assert.assertEquals(actual, expect_login);
		System.out.println("Login successful");
	}
	 @Test (dataProvider = "iData", dataProviderClass = DpExcel.class) 
	  public void loginCheckInValPass(String name , String pass) 
	  {
		  
		  WebDriver driver1 = driver.get();
		  driver1.manage().window().maximize();
		  driver1.get("https://www.demoblaze.com/");
		  WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));
		  driver1.findElement(By.id("login2")).click();
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys(pass);
		  driver1.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();
		  Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		  String actual = alt.getText();
		  System.out.println(actual);
		  String expect = "Wrong password.";
		  Assert.assertEquals(actual, expect);
		  alt.accept();
	  }

	@AfterMethod
	public void afterMethod() {
		WebDriver driver1 = driver.get();

		if (driver1 != null) {
			driver1.quit();
		}
	}

}
