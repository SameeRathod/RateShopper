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
import com.axisrooms.rateShopper.utils.SelectClassUtils;

public class RefreshPage {
	
	@FindBy (xpath = "//input[@id='app_rates']/..")
	private WebElement clickOnMobileRatesCheckBox;
	
	@FindBy(xpath = "//li[@class='list-group-item checkbox text-center']//label")
	private List<WebElement>refreshForCheckBox;
	
	@FindBy(xpath = "//ge-header/div[1]/div[2]/div[3]/div[1]/ge-refresh[1]/div[1]/div[1]/div[2]/div[2]/div[3]/ul[3]/li/label")
	private List<WebElement>dateQuickLinks;
	
	
	@FindBy (xpath = "//select[@id='max_occupancy']")
	private WebElement selectNoOfGuest;
	
	@FindBy (xpath = "//select[@id='nights']")
	private WebElement selectNoOfNights;
	
	
	@FindBy (xpath = "//h4[@class='quick-links']/following-sibling::li[6]/input")
	private WebElement clickOnSubmitButton;
	
	@FindBy (xpath = "(//button[@type='button'])[3]")
	private WebElement clickOnOkButton;
	
	@FindBy (xpath = "(//*[name()='text'][normalize-space()='Prices'])[1]")
	private WebElement getPriceText;
	
	@FindBy (xpath = "//h2[@id='swal2-title']")
	private WebElement getRefreshSumbittedText;
	
	public RefreshPage() {
		PageFactory.initElements(new DriverManager().getDriver(), this);
	}


	public RefreshPage clickOnMobileRatesCheckBox() {
		
		ExplicitWaitFactory.click(clickOnMobileRatesCheckBox, WaitStrategy.CLICKABLE, "  user clicked on Mobile rates check box");
		ExtentLogger.info(clickOnMobileRatesCheckBox+" selected");
		return this;
	}
	
	public RefreshPage refreshForCheckBox(String nameOfCheckBox) {
		for (int i = 0; i < refreshForCheckBox.size(); i++) {
			System.out.println(refreshForCheckBox.get(i).getText());
			if (refreshForCheckBox.get(i).getText().equalsIgnoreCase(nameOfCheckBox)) {
				WebElement ele=refreshForCheckBox.get(i);
				
				ExplicitWaitFactory.click(ele, WaitStrategy.CLICKABLE, " user cliked on refresh for check box link");
				ExtentLogger.info(refreshForCheckBox+" selected");
				break;
			}
	}
		return this;
	}
	
	public RefreshPage dateQuickLinks(String dateQuickLinksIn_day_noOfDaysIs_7or14or30) {
		for (int i = 0; i < dateQuickLinks.size(); i++) {
			System.out.println(dateQuickLinks.get(i).getText());
			if (dateQuickLinks.get(i).getText().equalsIgnoreCase(dateQuickLinksIn_day_noOfDaysIs_7or14or30)) {
				WebElement ele=dateQuickLinks.get(i);
			
				ExplicitWaitFactory.click(ele, WaitStrategy.CLICKABLE, " user cliked on date quick link");
				ExtentLogger.info("No of days for refresh is  "+dateQuickLinksIn_day_noOfDaysIs_7or14or30+" selected");
				break;
			}
	}
		return this;
		
	}

	public RefreshPage selectNoOfGuest(String enterNoOfGuest) {
		SelectClassUtils.selectByVisibleText(selectNoOfGuest, enterNoOfGuest);
		ExtentLogger.info("No of Guest is  "+enterNoOfGuest+" selected");
		
		return this;
	}

	public RefreshPage selectNoOfNights(String enterNoOfNights) {
		SelectClassUtils.selectByVisibleText(selectNoOfNights,enterNoOfNights );
		ExtentLogger.info("No of night is  "+enterNoOfNights+" selected");
		return this;
	}

	

	public RefreshPage clickOnSubmitButton() {
		
		ExplicitWaitFactory.click(clickOnSubmitButton, WaitStrategy.CLICKABLE, " user clicked on submit button");
		ExtentLogger.info(clickOnSubmitButton+" selected");
		return this;
	}
	
	public HomePage clickOnOkButton() {
		
		ExplicitWaitFactory.click(clickOnOkButton, WaitStrategy.CLICKABLE, " user clicked on ok button");
		return new HomePage();
	}
	
	public String getPriceText() {
	WebDriverWait wait =new WebDriverWait(new DriverManager().getDriver(), Duration.ofSeconds(10));
		
		return wait.until(ExpectedConditions.visibilityOf(getPriceText)).getText();
		
	
		
	}
	
	public String getRefreshSumbittedText() {
		WebDriverWait wait =new WebDriverWait(new DriverManager().getDriver(), Duration.ofSeconds(10));
		
		return wait.until(ExpectedConditions.visibilityOf(getRefreshSumbittedText)).getText();
		
	
	}
	
	

}
