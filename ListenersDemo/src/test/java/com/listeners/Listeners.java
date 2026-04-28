package com.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.LoginDemo;


public class Listeners extends LoginDemo implements ITestListener{
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Started "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Passed "+result.getName());
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Failed "+result.getName());
		try {
			File ssfol=new File("screenshots");
			ssfol.mkdir();
			captureScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void captureScreenshot(String name) throws IOException
	{
		WebDriver driver=driver1.get();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\krish\\git\\testng\\ListenersDemo\\screenshots\\"+name+".jpg"));
		System.out.println("ScreenShot Captured on fails");
	}

}
