package com.axisrooms.rateShopper.utils;

import com.axisrooms.rateShopper.driver.DriverManager;

public class GetCurrentUrl {

	public  String getUrl() {
		
		String currentUrl = new DriverManager().getDriver().getCurrentUrl();
		return currentUrl;
		

	}

}
