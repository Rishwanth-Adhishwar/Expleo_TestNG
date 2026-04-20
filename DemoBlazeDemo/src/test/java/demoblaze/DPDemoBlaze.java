package demoblaze;

import org.testng.annotations.DataProvider;


public class DPDemoBlaze {

	@DataProvider(name="testData",parallel=true)
	public Object[][] dataSearch()
	{
		return new Object[][] {{"admin1","admin"},{"admin","admin2"}};
	}

}
