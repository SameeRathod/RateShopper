package com.axisrooms.rateShopper.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.pages.HomePage;
import com.axisrooms.rateShopper.utils.GetCurrentUrl;
import com.axisrooms.rateShopper.utils.LoginUtils;

public class ReportTest extends RateShopperBaseTest {

	@Test
	public void reportTest(Map<String, String> getData) throws InterruptedException {

		assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/login");

		new LoginUtils().loginUtils(getData.get("UserName"), getData.get("Password"));	

		new HomePage().selectHotelFromList(getData.get("selectProperties"));
		Thread.sleep(3000);
		new HomePage().clickOnTheReportButton().getClickOnNoOfAdultsDropdown()
				.getSelectNoOfAdults(getData.get("NoOfAdults")).getClickOnNoOfNightsDropdown()
				.getSelectNoOfNights(getData.get("NoOfNights"))
				.getSelectNoOfDayForRefresh(getData.get("DateQuickLinks")).clickOnSubmitButton().clickOnPopUpOkButton();

		Thread.sleep(3000);
	}

}
