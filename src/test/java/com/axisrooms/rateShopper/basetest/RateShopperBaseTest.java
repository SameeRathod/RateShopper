package com.axisrooms.rateShopper.basetest;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.axisrooms.rateShopper.driver.Drivers;

public class RateShopperBaseTest {

	@BeforeMethod
	public void setUp(Object[] data) {
		
		@SuppressWarnings("unchecked")
		Map<String,String> map=(Map <String,String>)data[0];
		new Drivers().initDrivers(map.get("Browser"));

		

		// DriverManager.getDriver().navigate().to("https://rm.axisrooms.com/#/login");

	}

	@AfterMethod
	public void tearDown() {
		//new LogutUtility().logoutUtility();
		Drivers.quitDriver();
		

	}

}
