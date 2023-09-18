package com.axisrooms.rateShopper.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.enums.WaitStrategy;
import com.axisrooms.rateShopper.factories.ExplicitWaitFactory;
import com.axisrooms.rateShopper.reports.ExtentLogger;

public class LoginPage {

	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailIdTextField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='forgot-password']/a")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//div[@class='forgot-password']/a")
	private WebElement getTextOfForgotPassword;
	
	@FindBy (xpath="//pre[@class='invalid-login']")
	private WebElement getTextInvalidCredential;
	
	public LoginPage() {
		PageFactory.initElements(new DriverManager().getDriver(), this);
	}

	public LoginPage getEmailIdTextField(String enterUserNaame) {
		
		 ExplicitWaitFactory.sendKeys(emailIdTextField, enterUserNaame, WaitStrategy.VISIBLE,
				" user entered user name in user name text field");
		 ExtentLogger.info(enterUserNaame);
		return this;
	}

	public LoginPage getPasswordTextField(String enterPassword) {
		 ExplicitWaitFactory.sendKeys(passwordTextField, enterPassword, WaitStrategy.VISIBLE,
				" user entered password in password text field");
		 ExtentLogger.info(enterPassword);
		return this;
	}

	public HomePage getLoginButton() {
		 ExplicitWaitFactory.click(loginButton, WaitStrategy.CLICKABLE,
				" user clicked on login button");
		
		return new HomePage();
	}

	public ForgotPasswordPage getForgotPasswordLink() {
		 ExplicitWaitFactory.click(forgotPasswordLink, WaitStrategy.CLICKABLE,
				" user clicked on the forgot password link");
		return new ForgotPasswordPage();
	}
	
	public LoginPage getTextOfForgotPassword() {
		 ExplicitWaitFactory.getText(getTextOfForgotPassword, WaitStrategy.PRESENCE, null);
		ExtentLogger.info(getTextOfForgotPassword+" is visible");
		return this;
	}
	
	public LoginPage getTextInvalidCredential() {
		String text = getTextInvalidCredential.getText();
		 ExtentLogger.info(text);
		System.out.println(text);
		
		ExtentLogger.info(text+" is visible");
		return this;
	}

}
