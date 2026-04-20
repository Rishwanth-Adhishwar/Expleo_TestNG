package demoblaze;

import org.testng.annotations.Test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DemoBlaze {
	
	private static final ThreadLocal <WebDriver> driver1=new ThreadLocal <WebDriver>();
	private static final ThreadLocal <WebDriverWait> wait=new ThreadLocal <WebDriverWait>();
	public WebDriver getDriver()
	{
		return driver1.get();
	}
	public WebDriverWait getWait()
	{
		return wait.get();
	}
	
	

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void beforeTest(String browser, String url) {

		switch (browser) {

		case "firefox":
			driver1.set(new FirefoxDriver());
			break;
		case "chrome":
			driver1.set(new EdgeDriver());
			break;

		}

		getDriver().manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(15)));

		getDriver().get(url);
	}

	@Parameters({ "email", "password" })
	@Test(priority = 1)
	public void validation(String email, String password) {

		getDriver().findElement(By.id("login2")).click();

		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(email);
		getDriver().findElement(By.id("loginpassword")).sendKeys(password);

		getDriver().findElement(By.xpath("//button[text()='Log in']")).click();
		
		WebElement check= getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='logout2']")));
		String s=check.getText();
		Assert.assertEquals(s, "Log out","Login Successful");
	}

	
	@Test(priority = 2, groups = { "reggresion" },dataProvider="testData",dataProviderClass=DPDemoBlaze.class)
	public void invalid_with_username(String emails, String password) {

		getDriver().findElement(By.id("login2")).click();

		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(emails);
		getDriver().findElement(By.id("loginpassword")).sendKeys(password);

		getDriver().findElement(By.xpath("//button[text()='Log in']")).click();

		getWait().until(ExpectedConditions.alertIsPresent());
		Alert alert = getDriver().switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

	}


	@AfterMethod
	public void afterTest() {
		if(getDriver()!=null)
		{
			getDriver().quit();
			System.out.println("Test Done");
		}
	}
}
