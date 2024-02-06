package com.axisrooms.rateShopper.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.axisrooms.rateShopper.reports.ExtendReport;
import com.axisrooms.rateShopper.reports.ExtentLogger;

public class ListenerClass implements ITestListener ,ISuiteListener {

	  @Override
	    public void onStart(ISuite suite) {
	        try {
	            ExtendReport.initReports();
	            System.out.println("Suite started: " + suite.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onFinish(ISuite suite) {
	        try {
	            ExtendReport.flushReports();
	            System.out.println("Suite finished: " + suite.getName());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        String methodName = result.getMethod().getMethodName();
	        ExtendReport.createTest(methodName);
	        System.out.println("Test started: " + methodName);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	        System.out.println("Test passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        ExtentLogger.fail(result.getMethod().getMethodName() + " is failed");
	        ExtentLogger.fail(result.getThrowable().toString());

	        System.out.println("Test failed: " + result.getMethod().getMethodName());
	        // Print each line of the stack trace on a new line
	        StackTraceElement[] stackTrace = result.getThrowable().getStackTrace();
	        for (StackTraceElement element : stackTrace) {
	            ExtentLogger.fail(element.toString());
	            System.out.println("    " + element.toString());
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
	        System.out.println("Test skipped: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        /* For now, we are not using this */
	    }

	    @Override
	    public void onTestFailedWithTimeout(ITestResult result) {
	        /* For now, we are not using this */
	    }

	    @Override
	    public void onStart(ITestContext context) {
	        /*
	         * We are having just one test in our suite, so we don't have any special
	         * implementation as of now
	         */
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        /*
	         * We are having just one test in our suite, so we don't have any special
	         * implementation as of now
	         */
	    }
}
