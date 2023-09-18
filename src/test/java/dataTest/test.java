package dataTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.driver.DriverManager;

public class test extends RateShopperBaseTest {
	@Test(invocationCount = 2)
	public void text() throws InterruptedException {

		new DriverManager().getDriver().findElement(By.xpath("//input[@name='email']"))
				.sendKeys("demo@axisrooms.com");
		new DriverManager().getDriver().findElement(By.xpath("//input[@name='password']"))
				.sendKeys("Axisrooms321#");
		new DriverManager().getDriver().findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);
		new DriverManager().getDriver().findElement(By.xpath("//i[@class='fa fa-caret-right']")).click();

		new DriverManager().getDriver().findElement(By.xpath("(//button[@id='dLabel'])[1]")).click();

		forLoop(2);

		// again have to click on dropdown to close it
		new DriverManager().getDriver().findElement(By.xpath("(//button[@id='dLabel'])[1]")).click();

		//

		new DriverManager().getDriver().findElement(By.xpath("(//button[@id='dLabel'])[2]")).click();
		
		List<WebElement> month = new DriverManager().getDriver()
				.findElements(By.xpath("//button[@class='selectorfilter_checkbox']/label"));
		for (int i = 0; i < month.size(); i++) {
			System.out.println(month.get(i).getText());
			if (i==3) {
				month.get(i).click();
				break;
			}

			Thread.sleep(2000);

		}
	}

	public static void forLoop(int number) {
		List<WebElement> findElements = new DriverManager().getDriver()
				.findElements(By.xpath("(//button[@id='dLabel'])[1]/following-sibling::div/div/div"));

		for (int i = 0; i < findElements.size(); i++) {

			if (i == number) {
				findElements.get(i).click();
				break;
			}
		}

	}
}
