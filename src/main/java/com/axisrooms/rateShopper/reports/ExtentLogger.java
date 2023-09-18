package com.axisrooms.rateShopper.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.axisrooms.rateShopper.enums.ConfigProperties;
import com.axisrooms.rateShopper.utils.PropertyUtils;
import com.axisrooms.rateShopper.utils.ScreenShotUtils;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

		} else {
			fail(message);

		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
		if (PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());

		} else {
			skip(message);
		}

	}

}
