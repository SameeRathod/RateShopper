package com.axisrooms.rateShopper.factories;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.enums.WaitStrategy;
import com.axisrooms.rateShopper.reports.ExtentLogger;
import com.axisrooms.rateShopper.utils.JavaScriptUtils;

public class ExplicitWaitFactory {

	// for click
	public static void click(WebElement element, WaitStrategy waitstrategy, String ele) {
		
		
		if (waitstrategy == (WaitStrategy.CLICKABLE)) {
			elementToBeClickable(element);
		} else if (waitstrategy == (WaitStrategy.VISIBLE)) {
			elementVisibiity(element);
		}

		else if (waitstrategy == (WaitStrategy.DISPLAY)) {
			elementIsDisplay(element);
		}

		element.click();

		try {
			ExtentLogger.pass(ele, true);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void Actionclick(WebElement element, WaitStrategy waitstrategy, String ele , WebDriver driver) {
		if (waitstrategy == (WaitStrategy.CLICKABLE)) {
			elementToBeClickable(element);
		} else if (waitstrategy == (WaitStrategy.VISIBLE)) {
			elementVisibiity(element);
		}

		else if (waitstrategy == (WaitStrategy.DISPLAY)) {
			elementIsDisplay(element);
		}
		
	Actions actions = new Actions(driver);
	actions.moveToElement(element).click().build().perform();

		try {
			ExtentLogger.pass(ele, true);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	
	// for click using java script
		public static void clickUsingJavaScript(WebElement element, WaitStrategy waitstrategy, String ele) {
			
			
			if (waitstrategy == (WaitStrategy.CLICKABLE)) {
				elementToBeClickable(element);
			} else if (waitstrategy == (WaitStrategy.VISIBLE)) {
				elementVisibiity(element);
			}

			else if (waitstrategy == (WaitStrategy.DISPLAY)) {
				elementIsDisplay(element);
			}

			JavaScriptUtils.clickElementByJavascript(DriverManager.getDriver(), element);

			try {
				ExtentLogger.pass(ele, true);
			} catch (Exception e) {

				e.printStackTrace();
			}

		}


//send keys
	public static void sendKeys(WebElement element, String value, WaitStrategy waitstrategy, String ele) {
		if (waitstrategy == (WaitStrategy.CLICKABLE)) {
			elementToBeClickable(element);
		} else if (waitstrategy == (WaitStrategy.PRESENCE)) {
			elementVisibiity(element);
		}
		element.sendKeys(value);
		try {
			ExtentLogger.pass(" user entred "+value + ele, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get text
	public static void getText(WebElement element, WaitStrategy waitstrategy, String ele) {
		if (waitstrategy == (WaitStrategy.VISIBLE)) {
			elementToBeClickable(element);
		} else if (waitstrategy == (WaitStrategy.PRESENCE)) {
			elementVisibiity(element);
		}
		element.getText();
		try {
			ExtentLogger.pass( ele, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void elementToBeClickable(WebElement forClickAction) {

		new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(forClickAction));
	}

	private static void elementVisibiity(WebElement sendKeys) {
		 new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOf(sendKeys));
	}

	private static void elementIsDisplay(WebElement elementDispays) {
		Wait<WebDriver> wait = new WebDriverWait( DriverManager.getDriver(), Duration.ofSeconds(30));
		wait.until(d ->{
			d.navigate().refresh();
			elementDispays.isDisplayed();
			return elementDispays;
			
		});

	}

}