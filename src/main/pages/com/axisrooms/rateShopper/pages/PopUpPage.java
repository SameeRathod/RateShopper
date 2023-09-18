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

public class PopUpPage {

	@FindBy(xpath = "//div[@class='lastUpd']/span")
	private WebElement jobRunningText;

	@FindBy(xpath = "//div[@class='modal-content']/div/section/div/h2/span/i")
	private List<WebElement> clickOnOTAsIcon;

	@FindBy(xpath = "//body/app-root[1]/ge-home/div/ge-graph/ge-popup/div/div/div/section/div[1]/div[1]/div/h6")
	private List<WebElement> clickOnProperties;

	@FindBy(xpath = "//body[1]/app-root[1]/ge-home[1]/div[1]/ge-graph[1]/ge-popup[1]/div[1]/div[1]/div[1]/section/div[1]/div[1]/ge-rp-list[1]/table[1]/tbody[1]/tr[1]/td[1]")
	private List<WebElement> roomTypeText;

	@FindBy(xpath = "//body[1]/app-root[1]/ge-home[1]/div[1]/ge-graph[1]/ge-popup[1]/div[1]/div[1]/div[1]/section/div[1]/div[1]/ge-rp-list[1]/table[1]/tbody[1]/tr[1]/td[2]/a")
	private List<WebElement> roomPriceInINR;

	public PopUpPage() {
		PageFactory.initElements(new DriverManager().getDriver(), this);
	}

	public void getJobRunningText() {
		WebDriverWait wait = new WebDriverWait(new DriverManager().getDriver(), Duration.ofSeconds(10));

		String text = wait.until(ExpectedConditions.visibilityOf(jobRunningText)).getText();
		while (text != "Job Running") {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public void clickOnOTAsIcon(int enterOTAs_Sequance) {
		for (int i = 0; i < clickOnOTAsIcon.size(); i++) {
			if (i == enterOTAs_Sequance) {

				
				ExplicitWaitFactory.click(clickOnOTAsIcon.get(i), WaitStrategy.CLICKABLE, " element is clicked");

			}
		}
	}

	public void clickOnProperties(int enterPropertiesSequance) {
		for (int i = 0; i < clickOnProperties.size(); i++) {

			String text = clickOnProperties.get(i).getText();
			System.out.println(text);
		
			ExplicitWaitFactory.click(clickOnProperties.get(i), WaitStrategy.CLICKABLE, " element is clicked");

		}
	}

	public void roomTypeText(int abcd) {
		for (int i = 0; i < roomTypeText.size(); i++) {

			String text = roomTypeText.get(i).getText();
			System.out.println(text);
			
			ExplicitWaitFactory.click(roomTypeText.get(i), WaitStrategy.CLICKABLE, " element is clicked");

		}
	}

}
