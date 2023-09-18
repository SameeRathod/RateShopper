package demoTest;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.dataProvider.DataProviderTest;

public class DemoTest extends RateShopperBaseTest {
	
	@Test(dataProvider = "getData",dataProviderClass = DataProviderTest.class,alwaysRun = true)
	public void dataProviderTest() {
		
	}

}
