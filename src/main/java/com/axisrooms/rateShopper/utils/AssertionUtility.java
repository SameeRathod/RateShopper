package com.axisrooms.rateShopper.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.axisrooms.rateShopper.driver.DriverManager;

public class AssertionUtility {
	
	
	private static final int DEFAULT_TIMEOUT_SECONDS = 20;

    public static void assertElementIsDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed");
    }

    public static void assertElementIsNotDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.invisibilityOf(element));
        Assert.assertFalse(element.isDisplayed(), "Element is still displayed");
    }

    public static void assertElementTextEquals(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Element text mismatch. Expected: " + expectedText + ", Actual: " + actualText);
    }

    public static void assertElementContainsText(WebElement element, String expectedText) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
        String actualText = element.getText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Element text does not contain the expected text. Expected: " + expectedText + ", Actual: " + actualText);
    }

    public static void assertElementAttributeEquals(WebElement element, String attributeName, String expectedValue) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(element));
        String actualValue = element.getAttribute(attributeName);
        Assert.assertEquals(actualValue, expectedValue,
                "Element attribute mismatch. Expected: " + expectedValue + ", Actual: " + actualValue);
    }

    public static void assertElementIsSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        Assert.assertTrue(element.isSelected(), "Element is not selected");
    }

    public static void assertElementIsNotSelected(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeSelected(element)));
        Assert.assertFalse(element.isSelected(), "Element is still selected");
    }
    
    public static void assertCurrentUrlEquals(String expectedUrl) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Current URL mismatch. Expected: " + expectedUrl + ", Actual: " + actualUrl);
    }

    public static void assertCurrentUrlContains(String expectedText) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.urlContains(expectedText));
        String actualUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedText),
                "Current URL does not contain the expected text. Expected: " + expectedText + ", Actual: " + actualUrl);
    }

    // Add more assertion methods as needed

   
    // AssertionUtility.assertElementIsDisplayed(yourElement);
    // AssertionUtility.assertElementTextEquals(yourElement, "Expected Text");
    // AssertionUtility.assertElementAttributeEquals(yourElement, "attributeName", "expectedValue");
}


