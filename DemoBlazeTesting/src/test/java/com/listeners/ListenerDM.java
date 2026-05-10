package com.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.tests.BaseTestsDM;

public class ListenerDM extends BaseTestsDM implements ITestListener{
	
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println(result.getName());
		try {
			captureScreenShort(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void captureScreenShort(String name) throws IOException
	{
		WebDriver driver=getDriver();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File( "D:\\Selinium_Automation\\DemoBlazeTesting\\screenshots\\"+name+".jpg"));
		
	}
}
