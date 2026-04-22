package com.test;

import org.testng.annotations.Test;
import com.utils.ExcelDP;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestDP {

	private static final ThreadLocal<WebDriver> driver1 = new ThreadLocal<>();

	@BeforeMethod
	public void setup() {
		driver1.set(new ChromeDriver());
	}

	@Test(dataProvider = "vData", dataProviderClass = ExcelDP.class)
	public void validLogin(String uname, String upass) {

		WebDriver driver = driver1.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.cssSelector(".fa.fa-user")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(uname);

		driver.findElement(By.id("input-password")).sendKeys(upass);

		driver.findElement(By.cssSelector("input[value='Login']")).click();

		String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='My Account']"))).getText();

		Assert.assertEquals(actual, "My Account", "Login Successc");
	}


	@Test(dataProvider = "iData", dataProviderClass = ExcelDP.class)
	public void invalidLogin(String uname, String upass) {

		WebDriver driver = driver1.get();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.cssSelector(".fa.fa-user")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(uname);

		driver.findElement(By.id("input-password")).sendKeys(upass);

		driver.findElement(By.cssSelector("input[value='Login']")).click();

		String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-danger"))).getText();

		String expected = "Warning: No match for E-Mail Address and/or Password.";

		Assert.assertTrue(actual.contains(expected), "Error message not displayed properly");
	}
	@Parameters({"wordv"}) 
	@Test 
	public void searchValid(String word) { 
		WebDriver driver=driver1.get(); 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15)); 
		driver.manage().window().maximize(); 
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home"); 
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(word); 
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click(); 
		String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='content'] div:nth-child(1) div:nth-child(1) div:nth-child(2) div:nth-child(1) h4:nth-child(1) a:nth-child(1)"))).getText(); 
		Assert.assertEquals(actual.contains("mac"),false,"Products Found");
		} 
	@Parameters({"wordiv"}) 
	@Test 
	public void searchInValid(String word) {
		WebDriver driver=driver1.get(); 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15)); 
		driver.manage().window().maximize(); 
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys(word); 
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']")).click(); 
		String actual=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > p:nth-child(7)"))).getText(); 
		String expected="There is no product that matches the search criteria."; 
		Assert.assertEquals(actual, expected,"Products Not Found"); }
	

	@AfterMethod
	public void tearDown() {
		WebDriver driver = driver1.get();

		if (driver != null) {
			driver.quit();
			driver1.remove();
		}
	}
}