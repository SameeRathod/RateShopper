package com.axisrooms.rateShopper.test;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.pages.FiltersPage;
import com.axisrooms.rateShopper.pages.HomePage;
import com.axisrooms.rateShopper.pages.RefreshPage;
import com.axisrooms.rateShopper.utils.GetCurrentUrl;
import com.axisrooms.rateShopper.utils.LoginUtils;

public class FiltersTest extends RateShopperBaseTest{
	@Test
	public void filtersTest(Map<String,String>getData) throws InterruptedException {
		
	
assertEquals(new GetCurrentUrl().getUrl(), "https://goldeneye.axisrooms.com/login");
		
		new LoginUtils().loginUtils(getData.get("UserName"), getData.get("Password"));
			
			new HomePage().selectHotelFromList(getData.get("selectProperties"));
			
			Thread.sleep(3000);
			new HomePage().getClickOnFilterSlider().clickOnOtasDropdown()
			.unCheckOTAS(Integer.parseInt(getData.get("OTAs"))).clickOnOtasDropdown();
			Thread.sleep(2000);
			new FiltersPage().clickOnAdultsDropdown().selectNoOfAdultsFromList(getData.get("NoOfAdults"));
			Thread.sleep(2000);
			new FiltersPage().clickOnAdultsDropdown();
			new FiltersPage().clickOnNightsDropdown().selectNoOfNights(getData.get("NoOfNights"));
			new FiltersPage().clickOnNightsDropdown();
			
			new FiltersPage().closeOnFilterSlider();
			Thread.sleep(2000);
			
		
			Thread.sleep(5000);
			new HomePage().clickOnRefreshButton();
			new RefreshPage().refreshForCheckBox(getData.get("RefreshFor")).selectNoOfGuest(getData.get("NoOfAdults"))
					.selectNoOfNights(getData.get("NoOfNights")).dateQuickLinks(getData.get("DateQuickLinks"))
					.clickOnSubmitButton();
			
					
		
			assertEquals(new RefreshPage().getRefreshSumbittedText(), "Refresh Submitted!");
					
			new RefreshPage().clickOnOkButton();
			Thread.sleep(Integer.parseInt(getData.get("TimeForWait")));
			
			new HomePage().clickOnReloadButton();
			Thread.sleep(2000);
		
			assertEquals(new RefreshPage().getPriceText(), "Prices");
			
		
	}

}
