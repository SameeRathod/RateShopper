package com.axisrooms.rateShopper.utils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.pages.HomePage;

public class LogutUtility {
	
	public  void logoutUtility() {
		JavascriptExecutor js=(JavascriptExecutor) new DriverManager().getDriver();
		js.executeScript("window.scrollBy(0,250;");
		new HomePage().clickOnLogoutButton();

	
		 assertEquals(new GetCurrentUrl().getUrl(),
		 "https://goldeneye.axisrooms.com/login");
	}

}
