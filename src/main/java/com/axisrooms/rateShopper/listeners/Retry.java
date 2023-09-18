package com.axisrooms.rateShopper.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
//when ever test is failed this method will called. if method return true the failed
	//method will be rerun
	int counter =0;
	int limit=2;
	@Override
	public boolean retry(ITestResult result) {
		if(counter<limit) {
			counter++;
			return true;
		}
		
		return false;
	}

}
