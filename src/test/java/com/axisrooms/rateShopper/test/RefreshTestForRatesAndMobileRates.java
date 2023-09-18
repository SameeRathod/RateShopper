package com.axisrooms.rateShopper.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.pages.HomePage;
import com.axisrooms.rateShopper.utils.GetCurrentUrl;
import com.axisrooms.rateShopper.utils.LoginUtils;

@Test
public class RefreshTestForRatesAndMobileRates extends RateShopperBaseTest {

	public void refreshTestForRatesAndMobileRates(Map<String, String> getData)
			throws NumberFormatException, InterruptedException {
		assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/login");

		new LoginUtils().loginUtils(getData.get("UserName"), getData.get("Password"));
		Thread.sleep(2000);
		new HomePage().clickOnRefreshButton().clickOnMobileRatesCheckBox().selectNoOfGuest(getData.get("NoOfAdults"))
				.selectNoOfNights(getData.get("NoOfNights")).dateQuickLinks(getData.get("DateQuickLinks"))
				.clickOnSubmitButton().clickOnOkButton();
		Thread.sleep(Integer.parseInt(getData.get("TimeForWait")));
	}

}
