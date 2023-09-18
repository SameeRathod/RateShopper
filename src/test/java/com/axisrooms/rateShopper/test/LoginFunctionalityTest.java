package com.axisrooms.rateShopper.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.pages.LoginPage;
import com.axisrooms.rateShopper.utils.GetCurrentUrl;

public class LoginFunctionalityTest extends RateShopperBaseTest{
@Test
	public void loginFunctionalityTest(Map<String, String> getData) {
	
		assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/login");

		new LoginPage().getEmailIdTextField(getData.get("UserName")).getPasswordTextField(getData.get("Password"))
				.getLoginButton();

		try {

			assertEquals(new LoginPage().getTextInvalidCredential(), "Invalid Credentials");

		} catch (Exception e) {
			e.printStackTrace();
		}

		

		try {
			assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/login");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
