package com.axisrooms.rateShopper.utils;

import org.testng.asserts.SoftAssert;

public class SoftAssertUtils {
	 static SoftAssert softAssert = new SoftAssert();
	public static void assertAll() {
		softAssert.assertAll(); 
		
		
	}
	public static void assertEquals(String actual , String expected) {
		softAssert.assertEquals(actual, expected);
	}
	
	public static void asserTrueAndFalse(boolean actual, boolean expected) {
		softAssert.assertEquals(actual, expected);
	}
	

}
