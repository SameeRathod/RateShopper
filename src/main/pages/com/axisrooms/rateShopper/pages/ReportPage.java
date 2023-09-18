package com.axisrooms.rateShopper.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.enums.WaitStrategy;
import com.axisrooms.rateShopper.factories.ExplicitWaitFactory;

public class ReportPage {

	@FindBy(xpath = "//div[@class='occupancy-dropdown-widget']")
	private WebElement clickOnNoOfAdultsDropdown;

	@FindBy(xpath = "//div[@class='occupancy-dropdown-widget']/select/option")
	private List<WebElement> selectNoOfAdults;

	@FindBy(xpath = "//div[@class='nights-dropdown-widget']")
	private WebElement clickOnNoOfNightsDropdown;

	@FindBy(xpath = "//div[@class='nights-dropdown-widget']/select/option")
	private List<WebElement> selectNoOfNights;

	@FindBy(xpath = "//ul[@class='list-group']/li/label")
	private List<WebElement> selectNoOfDayForRefresh;

	@FindBy(xpath = "//li[@class='list-group-item submit']/input")
	private WebElement clickOnSubmitButton;

	@FindBy(xpath = "//button[@type='button' and contains(text(),'OK')]")
	private WebElement clickOnPopUpOkButton;

	public ReportPage() {
		PageFactory.initElements(new DriverManager().getDriver(), this);
	}

	public ReportPage getClickOnNoOfAdultsDropdown() {
		
		ExplicitWaitFactory.click(clickOnNoOfAdultsDropdown, WaitStrategy.CLICKABLE,
				" user Clicked on Adults Dropdown");
		return this;
	}

	public ReportPage getSelectNoOfAdults(String selectNoOfAdultsFromList) {
		for (int i = 0; i < selectNoOfAdults.size(); i++) {

			if (selectNoOfAdults.get(i).getText().equalsIgnoreCase(selectNoOfAdultsFromList)) {
				
				ExplicitWaitFactory.click(selectNoOfAdults.get(i), WaitStrategy.CLICKABLE,
						" user clicked on the element");

				break;

			}
		}
		return this;
	}

	public ReportPage getClickOnNoOfNightsDropdown() {
		
		ExplicitWaitFactory.click(clickOnNoOfNightsDropdown, null, null);
		return this;
	}

	public ReportPage getSelectNoOfNights(String selectNoOFNightsFromList) {
		for (int i = 0; i < selectNoOfNights.size(); i++) {

			if (selectNoOfNights.get(i).getText().equalsIgnoreCase(selectNoOFNightsFromList)) {

				selectNoOfNights.get(i).click();
				break;

			}
		}
		return this;
	}

	public ReportPage getSelectNoOfDayForRefresh(String dateQuickLinksIn_day_noOfDaysIs_7or14or30) {
		for (int i = 0; i < selectNoOfDayForRefresh.size(); i++) {
			System.out.println(selectNoOfDayForRefresh.get(i).getText());
			if (selectNoOfDayForRefresh.get(i).getText().equalsIgnoreCase(dateQuickLinksIn_day_noOfDaysIs_7or14or30)) {
			
				ExplicitWaitFactory.click(selectNoOfDayForRefresh.get(i), WaitStrategy.CLICKABLE,
						" user clicked on the element");

					break;

			}
		}
		return this;
	}

	public ReportPage clickOnSubmitButton() {
		
		ExplicitWaitFactory.click(clickOnSubmitButton, WaitStrategy.CLICKABLE, " user clicked on submit button");
		return this;
	}

	public HomePage clickOnPopUpOkButton() {
		
		ExplicitWaitFactory.click(clickOnPopUpOkButton, WaitStrategy.CLICKABLE,
				" user clicked on pop up ok button");
		return new HomePage();
	}

}
