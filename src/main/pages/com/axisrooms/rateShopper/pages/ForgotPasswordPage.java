package com.axisrooms.rateShopper.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.enums.WaitStrategy;
import com.axisrooms.rateShopper.factories.ExplicitWaitFactory;

public class ForgotPasswordPage {
	

	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement enterEmailIdInEmailTextField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement clickOnSubmitButton;
	
	public ForgotPasswordPage() {
		PageFactory.initElements(new DriverManager().getDriver(), this);
	}

	

	public ForgotPasswordPage getEnterEmailIdInEmailTextField(String enterEmailId) {
		
		ExplicitWaitFactory.sendKeys(enterEmailIdInEmailTextField, enterEmailId, WaitStrategy.VISIBLE, " User Entered email Id .");
		
		return this;
	}

	public ForgotPasswordPage getClickOnSubmitButton() {
	
		ExplicitWaitFactory.click(clickOnSubmitButton, WaitStrategy.CLICKABLE, " User clicked on submit Button");
		return this;
	}
	

}
