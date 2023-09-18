package com.axisrooms.rateShopper.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClassUtils {

	public static void selectByVisibleText(WebElement element, String visibleText) {
		

		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	
	}

	public static void selectByValue(WebElement element, String value) {
	
		Select select = new Select(element);
		select.selectByValue(value);
		

	}

	public static void selectByIndex(WebElement element, int index) {
		
		Select select = new Select(element);
		select.selectByIndex(index);
		
	}

}
