package com.axisrooms.rateShopper.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.axisrooms.rateShopper.constants.FrameworkConstant;
import com.axisrooms.rateShopper.utils.ExcelUtility;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String, String>> testDetails = ExcelUtility.getTestDetails(FrameworkConstant.runManagerSheet());
		
		List<IMethodInstance> result=new ArrayList<>();
		
		for(int i=0; i<methods.size(); i++) {
			for(int j=0; j<testDetails.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testDetails.get(j).get("TestCaseName"))) {
					if(testDetails.get(j).get("Execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(testDetails.get(j).get("TestCaseDescription"));
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testDetails.get(j).get("InvocationCount")));
					methods.get(i).getMethod().setPriority(Integer.parseInt(testDetails.get(j).get("Priority")));
					
					result.add(methods.get(i));
					}
					
				}
			}
		}
		return result;
	}



}
