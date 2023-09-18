package com.axisrooms.rateShopper.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class ActionsClassUtils {

	
	
	public static void mouseHoverActions(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public static void rightClickActions(WebElement element ,  WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).contextClick().build().perform();
	}
	
	public static void doubleClickActions(WebElement element ,  WebDriver driver){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).doubleClick().build().perform();
		
	}
	public static void clickAction(WebElement element ,  WebDriver driver) {
		Actions actions = new Actions(driver);
		
		actions.moveToElement(element).click().build().perform();
	}
	
	public static void moveOffSet(WebElement element ,  WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(20, 20).build().perform();
		
	}

}
