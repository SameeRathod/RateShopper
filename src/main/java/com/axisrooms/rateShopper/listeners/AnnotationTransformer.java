package com.axisrooms.rateShopper.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.axisrooms.rateShopper.dataProvider.DataProviderTest;

//it will execute each time test method is called
//here we can customize based on any annotation
//used this class on TestNG xml remove ITestListener And Add This Class name
public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass, @SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) {
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderTest.class);
		//annotation.setRetryAnalyzer(RateShopperRetry.class);
		annotation.getAlwaysRun();
		
		
	}
}
