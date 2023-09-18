package com.axisrooms.rateShopper.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.pages.HomePage;
import com.axisrooms.rateShopper.pages.LoginPage;
import com.axisrooms.rateShopper.utils.GetCurrentUrl;

public class LoginTest extends RateShopperBaseTest {
	@Test
	public  void loginTest(Map<String, String> getData) {

		assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/login");

		new LoginPage().getEmailIdTextField(getData.get("UserName"))
		.getPasswordTextField(getData.get("Password"))
		.getLoginButton().rateShoppingTest();

		assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/home");

		try {
			new HomePage().clickbutton();
		} catch (Exception e) {

		}

	}

}
