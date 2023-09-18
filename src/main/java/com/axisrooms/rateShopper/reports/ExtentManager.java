package com.axisrooms.rateShopper.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>(); // all three method used to make
																					// thread
	// safe
	// to avoid to call this method if some one call this method
	// its not affect to
// our frame work

	static ExtentTest getExtentTest() {
		return exTest.get();
	}

	static void setExtentTest(ExtentTest test) {

		exTest.set(test);

	}

	static void unload() {
		exTest.remove();
	}

}
