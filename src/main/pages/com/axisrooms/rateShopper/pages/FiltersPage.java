package com.axisrooms.rateShopper.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.enums.WaitStrategy;
import com.axisrooms.rateShopper.factories.ExplicitWaitFactory;
import com.axisrooms.rateShopper.reports.ExtentLogger;

public class FiltersPage {

	@FindBy(xpath = "//body/app-root[1]/ge-home[1]/ge-home-slider[1]/div[1]/div[1]/div[1]/ge-ota[1]/div[1]/div[1]/button[1]")
	private WebElement clickOnOtasDropdown;

	@FindBy(xpath = "//div[@class='dropdown-menu']/div/div")
	private List<WebElement> unCheckOTAS;

	@FindBy(xpath = "(//button[@id='dLabel'])[2]")
	private WebElement clickOnMonthDropdown;

	@FindBy(xpath = "//button[@class='selectorfilter_checkbox']")
	private List<WebElement> selectMonthFromDroplist;
	
	@FindBy(xpath = "//div[@class='selectorfilter_dropdown dropdown open active']//button[@id='dLabel']/../div/div/button")
	private List<WebElement> selectNoOfAdults;
	
	@FindBy(xpath = "//ge-nights//button[@id='dLabel']/../div/div/button")
	private List<WebElement> selectNoOfNights;

	@FindBy(xpath = "(//button[@id='dLabel'])[3]")
	private WebElement clickOnAdultsDropdown;

	@FindBy(xpath = "(//button[@id='dLabel'])[4]")
	private WebElement clickOnNightsDropdown;

	@FindBy(xpath = "(//button[@id='dLabel'])[5]")
	private WebElement clickOnMealCodeDropDown;

	@FindBy(xpath = "(//button[@id='dLabel'])[6]")
	private WebElement clickOnFelxRateDropdown;

	@FindBy(xpath = "(//button[@id='dLabel'])[7]")
	private WebElement clickOnRateFilterDropdown;

	@FindBy(xpath = "//p[normalize-space()='Filters']")
	private WebElement closeOnFilterSlider;

	public FiltersPage() {
		PageFactory.initElements(new DriverManager().getDriver(), this);
	}

	public FiltersPage clickOnOtasDropdown() {
		
		ExplicitWaitFactory.click(clickOnOtasDropdown, WaitStrategy.CLICKABLE,
				" user clicked on OTAS dropdown");
		return this;
	}

	public FiltersPage unCheckOTAS(int number) {

		for (int i = 0; i < unCheckOTAS.size(); i++) {

			if (i == number) {
				
				ExplicitWaitFactory.click(unCheckOTAS.get(i), WaitStrategy.CLICKABLE, " element clicked");
				break;
			}
		}
		return this;

	}

	public FiltersPage clickOnMonthDropdown() {
	
		ExplicitWaitFactory.click(clickOnMonthDropdown, WaitStrategy.CLICKABLE,
				" user selected Date");

		return this;
	}

	public FiltersPage selectMonthFromDroplist(String enterMonthInMM_YYYY_Format) {
		for (int i = 0; i < selectMonthFromDroplist.size(); i++) {

			if (selectMonthFromDroplist.get(i).getText().equalsIgnoreCase(enterMonthInMM_YYYY_Format)) {

			
				ExplicitWaitFactory.click(selectMonthFromDroplist.get(i), WaitStrategy.CLICKABLE, " element is clicked");
				break;

			}
		}
		return this;

	}

	public FiltersPage clickOnAdultsDropdown() {
		
		WebDriverWait wait=new WebDriverWait(new DriverManager().getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnAdultsDropdown)).click();
	
		return this;

	}

	public FiltersPage clickOnNightsDropdown() {
		new ExplicitWaitFactory();
		ExplicitWaitFactory.click(clickOnNightsDropdown, WaitStrategy.VISIBLE, " uesr clicked on nightdropdown");
		return this;

	}

	public FiltersPage selectNoOfAdultsFromList(String enterNoOfAdults) {
		for (int i = 0; i < selectNoOfAdults.size(); i++) {

			if (selectNoOfAdults.get(i).getText().equalsIgnoreCase(enterNoOfAdults)) {
				WebDriverWait wait=new WebDriverWait(new DriverManager().getDriver(), Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(selectNoOfAdults.get(i))).click();
				
				break;

			}
		}
		return this;

	}

	public FiltersPage selectNoOfNights(String enterNoOfNights) {

		for (int i = 0; i < selectNoOfNights.size(); i++) {

			if (selectNoOfNights.get(i).getText().equalsIgnoreCase(enterNoOfNights)) {

			
			ExplicitWaitFactory.click(selectNoOfNights.get(i), WaitStrategy.CLICKABLE, " element is clicked");
				ExtentLogger.info(" no of night is "+selectNoOfNights+" selected");
				break;

			}
		}
		return this;

	}

	public FiltersPage clickOnMealCodeDropDown() {
	
		ExplicitWaitFactory.click(clickOnMealCodeDropDown, WaitStrategy.CLICKABLE, " user selected clicked on meal code");
		return this;
	}

	public FiltersPage clickOnFelxRateDropdown() {
		
		ExplicitWaitFactory.click(clickOnFelxRateDropdown, WaitStrategy.CLICKABLE, " user clicked on flex rate");
		return this;
	}

	public FiltersPage clickOnRateFilterDropdown() {
	
		ExplicitWaitFactory.click(clickOnRateFilterDropdown, WaitStrategy.CLICKABLE, null);
		return this;
	}

	public FiltersPage selecctMealCodeDropDown(String enterMealCode) {

		for (int i = 0; i < selectMonthFromDroplist.size(); i++) {

			if (selectMonthFromDroplist.get(i).getText().equalsIgnoreCase(enterMealCode)) {

				
				ExplicitWaitFactory.click(selectMonthFromDroplist.get(i), WaitStrategy.CLICKABLE, " element is clicked");
				ExtentLogger.info(" Meal code is "+selectMonthFromDroplist+" removed");
				break;

			}
		}
		return this;

	}

	public FiltersPage selectFelxRateDropdown(String enterFelexRate) {

		for (int i = 0; i < selectMonthFromDroplist.size(); i++) {

			if (selectMonthFromDroplist.get(i).getText().equalsIgnoreCase(enterFelexRate)) {

			
			ExplicitWaitFactory.click(selectMonthFromDroplist.get(i), WaitStrategy.CLICKABLE, " element is clicked");
				ExtentLogger.info("felex rate is "+selectMonthFromDroplist+" selected");
				break;

			}
		}
		return this;

	}

	public FiltersPage SelectnRateFilterDropdown(String enterRateFilter) {

		for (int i = 0; i < selectMonthFromDroplist.size(); i++) {

			if (selectMonthFromDroplist.get(i).getText().equalsIgnoreCase(enterRateFilter)) {
			
				ExplicitWaitFactory.click(selectMonthFromDroplist.get(i), WaitStrategy.CLICKABLE, " element is clicked");
				
				break;

			}
		}
		return this;

	}

	public HomePage closeOnFilterSlider() {
		WebDriverWait wait=new WebDriverWait(new DriverManager().getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(closeOnFilterSlider)).click();
	

		return new HomePage();
	}

}
