package dataTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.axisrooms.rateShopper.basetest.RateShopperBaseTest;
import com.axisrooms.rateShopper.driver.DriverManager;

public class RateShopperBrokenLinks extends RateShopperBaseTest {

	@Test
	public void brokenLinks() throws IOException, InterruptedException {

		new DriverManager().getDriver().findElement(By.xpath("//div[@class='form-section']/div/form/div/p[3]")).click();
		new DriverManager().getDriver().findElement(By.xpath("//input[@id='emailId']")).sendKeys("sameer@axisrooms.com");
		new DriverManager().getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("15Me430@");
		new DriverManager().getDriver().findElement(By.xpath("//button[text()='Login']")).click();

		// capture link from web page
		Thread.sleep(2000);
		List<WebElement> findElements = new DriverManager().getDriver().findElements(By.tagName("a"));
		System.out.println(findElements.size());

		for (int i = 0; i < findElements.size(); i++) {
			// by using herf property we can get url of required link
			WebElement webElement = findElements.get(i);
			String url = webElement.getAttribute("href");
			if (isUrlValid(url)) {
				URL link = new URL(url);

				// create connection using url object link
				HttpURLConnection http = (HttpURLConnection) link.openConnection();

				Thread.sleep(2000);
				// establish connection
				http.connect();
				// if response code is above 400 then it is broken link
				int responseCode = http.getResponseCode();

				if (responseCode >= 400) {
					System.out.println(url + " - " + " is broken link");
				}

				
			}
		}

	}

	public static boolean isUrlValid(String url) {

		try {
			URL obj = new URL(url);
			obj.toURI();
			return true;
		} catch (MalformedURLException e) {
			return false;
		} catch (URISyntaxException e) {
			return false;
		}

	}

}
