package com.axisrooms.rateShopper.dataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.axisrooms.rateShopper.constants.FrameworkConstant;
import com.axisrooms.rateShopper.utils.ExcelUtility;



public class DataProviderTest {
	
	private  List<Map<String, String>> list=new ArrayList<>();
	@DataProvider(name = "getData")
	public Object[] getRateShopperData(Method m) {
		
		String testName=m.getName();
		
		if(list.isEmpty()) {
		list = ExcelUtility.getTestDetails(FrameworkConstant.iterationSheet());
		}
		
		List<Map<String, String>> iterationList=new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).get("TestName").equalsIgnoreCase(testName)&&(list.get(i).get("Execute").equalsIgnoreCase("yes"))) {
				 {
					iterationList.add(list.get(i));
				}
			}
		}
		//list.removeAll(iterationList);
		return  iterationList.toArray();
	}
		
		
	
	
}
