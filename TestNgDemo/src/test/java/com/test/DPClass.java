package com.test;

import org.testng.annotations.DataProvider;

public class DPClass {
	@DataProvider(name="testdata",parallel=true)
	public Object[][] dataSearch()
	{
		return new Object[][] {{"selenium","21-yrsOld"},{"TestNg","Java8"},{"Automation","Selenium4"}};
	}

}
