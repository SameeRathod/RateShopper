package com.axisrooms.rateShopper.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.pages.HomePage;
import com.axisrooms.rateShopper.pages.RefreshPage;
import com.axisrooms.rateShopper.utils.AssertionUtility;
import com.axisrooms.rateShopper.utils.LoginUtils;

public class RefreshTestForRates extends RateShopperBaseTest {
	@Test
	public void refreshTest(Map<String, String> getData) throws InterruptedException {

		AssertionUtility.assertCurrentUrlEquals("https://goldeneye.axisrooms.com/login");

		new LoginUtils().loginUtils(getData.get("UserName"), getData.get("Password"));

		new HomePage().rateShoppingTest().selectHotelFromList(getData.get("selectProperties"));
		new HomePage().clickOnReloadButton();
		Thread.sleep(3000);
		new HomePage().clickOnRefreshButton();
		new RefreshPage().refreshForCheckBox(getData.get("RefreshFor")).selectNoOfGuest(getData.get("NoOfAdults"))
				.selectNoOfNights(getData.get("NoOfNights")).dateQuickLinks(getData.get("DateQuickLinks"))
				.clickOnSubmitButton();

		//AssertionUtility.assertElementTextEquals(new RefreshPage().getRefreshSumbittedText, "Refresh Submitted!");

		new RefreshPage().clickOnOkButton();
		new HomePage().clickOnReloadButton();
		Thread.sleep(Integer.parseInt(getData.get("TimeForWait")));

		new HomePage().clickOnReloadButton();

		assertEquals(new RefreshPage().getPriceText(), "Prices");

		// HomePage().clickOnGraphCircle(30);

		new HomePage().MouseHoverOnGraphCircle(13, DriverManager.getDriver());

		// ne/new PopUpPage().roomTypeText(1);
		// new PopUpPagwe().clickOnProperties(1);

	}

}
