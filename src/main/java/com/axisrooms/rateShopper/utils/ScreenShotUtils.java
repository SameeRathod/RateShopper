package com.axisrooms.rateShopper.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.axisrooms.rateShopper.driver.DriverManager;

public class ScreenShotUtils {
	
	public static String getBase64Image() {
		return ((TakesScreenshot)new DriverManager().getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
