package com.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class TestNG_Demo {
	WebDriver driver;
  @Test
  public void validation() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.findElement(By.cssSelector("#loginusername")).sendKeys("rishwanth");
	  driver.findElement(By.cssSelector("#loginpassword")).sendKeys("rishwa123");
	  driver.findElement(By.cssSelector("button[onclick='logIn()']")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("--start-maximized");
	  //options.addArguments("--headless");
	  driver=new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://demoblaze.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
