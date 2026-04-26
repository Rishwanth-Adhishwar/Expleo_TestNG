package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginDemo {
	public static final ThreadLocal<WebDriver> driver1 = new ThreadLocal<WebDriver>();
	public static Logger log = LogManager.getLogger(LoginDemo.class);

	@BeforeMethod
	public void beforeMethod() {
		log.info("Browser Initializing");
		driver1.set(new ChromeDriver());
	}

	@Test(dataProvider="vdatas",dataProviderClass=com.utils.ExeclDataProvider.class,priority=1)
	public void vCase(String email, String password) {
		WebDriver driver = driver1.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		log.info("Browser Opened");
		driver.get("https://tutorialsninja.com/demo/");
		log.info("URL Launched in browser");
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/login']"))).click();
		log.info("Entering email: "+email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-email"))).sendKeys(email);
		log.info("Enetering Password");
		driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		log.info("Clicked Login");//
		String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2:nth-child(1)")))
				.getText();
		String expected = "My Account";
		try {
			Assert.assertEquals(actual, expected);
			log.info("Login Successfull");

		} catch (AssertionError e) {
			log.error("Invalid Username or password");
			System.out.println(e.getMessage());
		}

	}
	
	
	@Test(dataProvider="ivdatas",dataProviderClass=com.utils.ExeclDataProvider.class,priority=2)
	public void ivCase(String email, String password) {
		WebDriver driver = driver1.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		log.info("Browser Opened");
		driver.get("https://tutorialsninja.com/demo/");
		log.info("URL Launched in browser");
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("a[href='https://tutorialsninja.com/demo/index.php?route=account/login']"))).click();
		log.info("Entering email: "+email);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-email"))).sendKeys(email);
		log.info("Enetering Password");
		driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		log.info("Clicked Login");
		String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-danger.alert-dismissible"))).getText();
		String expected = "Warning: No match for  Address and/or Password.";
		Assert.assertEquals(actual, expected);
		log.info("Login UnSuccessfull");

	}

	@AfterMethod
	public void afterMethod() {
		WebDriver driver = driver1.get();
		if (driver != null) {
			driver.quit();
			driver1.remove();
		}
	}

}
