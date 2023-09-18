package dataTest;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.dataProvider.DataProviderTest;

public class TestClass  {
	
	@Test(dataProvider = "dataProvider",dataProviderClass = DataProviderTest.class,alwaysRun = true)
	public void test(Map<String,String>data) {
		
		RateShopperBaseTest rateShopperBaseTest = new RateShopperBaseTest();
		rateShopperBaseTest.setUp(null);
		System.out.println(data);
		
	}

}
