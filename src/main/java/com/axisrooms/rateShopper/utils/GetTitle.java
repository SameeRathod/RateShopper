package com.axisrooms.rateShopper.utils;

import com.axisrooms.rateShopper.driver.DriverManager;

public class GetTitle {

	public  String CurrentpageTitle() {

		return new DriverManager().getDriver().getTitle();
		
	
	}

}
