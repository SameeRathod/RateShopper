package com.axisrooms.rateShopper.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.axisrooms.rateShopper.driver.DriverManager;
import com.axisrooms.rateShopper.enums.WaitStrategy;
import com.axisrooms.rateShopper.factories.ExplicitWaitFactory;
import com.axisrooms.rateShopper.reports.ExtentLogger;
import com.axisrooms.rateShopper.utils.ActionsClassUtils;
import com.axisrooms.rateShopper.utils.SelectClassUtils;

public class HomePage {


	@FindBy(xpath = "//div[@id='refreshWidget']")
	private WebElement refereshButton;

	@FindBy(xpath = "//select[@class='select2-hidden-accessible']")
	private WebElement selectHotelFromList;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchHotelTextField;

	@FindBy(xpath = "//div[@id='refreshWidget']")
	private WebElement clickOnRefreshButton;
	// ==========================================================================================
	@FindBy(xpath = "//p[normalize-space()='Filters']")
	private WebElement clickOnFilterSlider;

	@FindBy(xpath = "//button[@class='hamburger float-left']")
	private WebElement clickOnInsightButton;

	@FindBy(xpath = "//input[@type='checkbox']/../span[1]")
	private WebElement clickOnShowingMobileRateSlider;

	@FindBy(xpath = "//ul[@class='nav nav-pills']/li[2]")
	private WebElement clickOnRateParity;

	@FindBy(xpath = "//ul[@class='nav nav-pills']/li[3]")
	private WebElement clickOnRanking;

	@FindBy(xpath = "//ul[@class='nav nav-pills']/li[4]/a")
	private WebElement clickOnReviewScore;

	@FindBy(xpath = "(//div[@class='logout'])[1]/a")
	private WebElement clickOnLogoutButton;

	@FindBy(xpath = "//ul/li/a[text()='Rate Shopping']")
	private WebElement rateShoppingTest;

	@FindBy(xpath = "//button[@id='notification-close-btn']")
	private WebElement clickbutton;

	@FindBy(xpath = "//li[@class='select2-results__option']")
	private List<WebElement> selectPropertiesFromList;

	@FindBy(xpath = "//div[@id='reportsWidget']")
	private WebElement clickOnTheReportButton;

	@FindBy(xpath = "//button[@class='btn btn-load-rates']")
	private WebElement clickOnReloadButton;

	@FindBy(xpath = "//*[name()='circle']")
	private List<WebElement> clickOnGraphCircle;

	@FindBy(xpath = "//div[@class='lastUpd']/span")
	private WebElement jobRunningText;

	@FindBy(xpath = "//div[@class='lastUpd']")
	private WebElement lastFtechText;

	@FindBy(xpath = "//div[@class='lastUpd']/span")
	private WebElement lastFetchDAteAndTime;

	public HomePage() {

		PageFactory.initElements(DriverManager.getDriver(), this);

	}

	public HomePage getRefereshButton() {
		return this;
	}

	public HomePage selectHotelFromList(String visibleText) throws InterruptedException {
		SelectClassUtils.selectByVisibleText(selectHotelFromList, visibleText);
		ExtentLogger.info("name of hotel is " + visibleText + " selected");
		Thread.sleep(4000);

		return this;
	}

	public RefreshPage clickOnRefreshButton() {
		/*WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnRefreshButton)).click();*/
		
		 ExplicitWaitFactory.click(clickOnRefreshButton, WaitStrategy.CLICKABLE, " element is clicked");

		return new RefreshPage();
	}

	public FiltersPage getClickOnFilterSlider( ) {
		
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(clickOnFilterSlider)).click();
		
		return new FiltersPage();
	}

	public HomePage rateShoppingTest() {
		
		ExplicitWaitFactory.getText(rateShoppingTest, WaitStrategy.VISIBLE, " rate shopping text is visible");
		return this;
	}

	public LoginPage clickOnLogoutButton() {

	
		ExplicitWaitFactory.click(clickOnLogoutButton, WaitStrategy.CLICKABLE, " user clicked on logout button");
		return new LoginPage();
	}

	public HomePage clickbutton() {
		
		ExplicitWaitFactory.click(clickbutton, WaitStrategy.CLICKABLE, "user clicked on button");
		return this;
	}

	public HomePage selectPropertiesFromList(String clickOnProperties) {
		for (int i = 0; i < selectPropertiesFromList.size(); i++) {

			if (selectPropertiesFromList.get(i).getText().equalsIgnoreCase(clickOnProperties)) {
				
				ExplicitWaitFactory.click(selectPropertiesFromList.get(i), WaitStrategy.CLICKABLE, "user clicked on button");
				
				break;

			}
		}
		return this;
	}

	public ReportPage clickOnTheReportButton() {
	
		ExplicitWaitFactory.click(clickOnTheReportButton, WaitStrategy.CLICKABLE,
				" user clicked on report button");
		return new ReportPage();
	}

	public HomePage clickOnReloadButton() {
		
		ExplicitWaitFactory.click(clickOnReloadButton, WaitStrategy.CLICKABLE, " user Clicked on reload button");

		ExtentLogger.info(clickOnReloadButton + "  selected");
		return this;
	}

	public HomePage clickOnGraphCircle(int noOfDay) {
		for (int i = 0; i < clickOnGraphCircle.size(); i++) {

			if (i == noOfDay) {

				WebElement webElement = clickOnGraphCircle.get(i);
				
				ExplicitWaitFactory.click(webElement, WaitStrategy.CLICKABLE,
						" user clicked on the circle");
				ExtentLogger.info(clickOnGraphCircle + "  clicked");
				break;

			}
		}
		return this;

	}

	public void MouseHoverOnGraphCircle(int dayOfResfresh,	WebDriver driver) {
		long currentTimeMillis = System.currentTimeMillis();

		for (int i = 0; i < clickOnGraphCircle.size(); i++) {
			WebElement webElement = clickOnGraphCircle.get(i);
			
			//new ExplicitWaitFactory().Actionclick(webElement, WaitStrategy.VISIBLE," user clicked on the circle");
			if (i == dayOfResfresh) {

				ActionsClassUtils.mouseHoverActions(webElement,driver);
				
				//new ExplicitWaitFactory().getText(jobRunningText, WaitStrategy.VISIBLE," text is visible");
				
				while (jobRunningText.getText().equalsIgnoreCase("Job Running")) {
					ActionsClassUtils.moveOffSet(jobRunningText,driver);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

						e.printStackTrace();

					}
					System.out.println(i);
					ActionsClassUtils.mouseHoverActions(webElement,driver);
					WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
					wait.until(ExpectedConditions.elementToBeClickable(jobRunningText));
				
					

				}

			}
		}
		long currentTimeMillis2 = System.currentTimeMillis();
		long time = currentTimeMillis2 - currentTimeMillis;
		ExtentLogger.info("Total time taken for refresh is " + time/60000 +" minutes");
		
	
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		String text = wait.until(ExpectedConditions.visibilityOf(lastFtechText)).getText();

		WebDriverWait wait1 = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
		String text1 = wait1.until(ExpectedConditions.visibilityOf(lastFetchDAteAndTime)).getText();
		ExtentLogger.info(text + " " + text1);
		System.out.println(text + " " + text1);
		

	}
}
