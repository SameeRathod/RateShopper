package com.axisrooms.rateShopper.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.axisrooms.rateShopper.constants.FrameworkConstant;

public final class ExtendReport {

	private ExtendReport() {

	}

	private static ExtentReports extentReports;
	// public static ExtentTest createTest;

	public static void initReports() throws Exception {

		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
					FrameworkConstant.getExtentReportFilePath());
			extentReports.attachReporter(extentSparkReporter);

			extentSparkReporter.config().setTheme(Theme.DARK);
			extentSparkReporter.config().setDocumentTitle("GE Testing Report");
			extentSparkReporter.config().setReportName("Rate Shopper Automation Testing");
		}
	}

	public static void flushReports() throws Exception {

		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
		}
		ExtentManager.unload();

		try {
			Desktop.getDesktop().browse(new File(FrameworkConstant.getExtentReportFilePath()).toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void createTest(String testcaseName) {
		// ExtentTest createTest = extentReports.createTest(testcaseName);
		ExtentManager.setExtentTest(extentReports.createTest(testcaseName));
		
	}

}
