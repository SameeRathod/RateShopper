package com.axisrooms.rateShopper.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.axisrooms.rateShopper.enums.ConfigProperties;
import com.axisrooms.rateShopper.utils.PropertyUtils;

public class Drivers {

	public void initDrivers(String browser) {

		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", FrameworkConstant.getChromeDriverPath());

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				//chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--incognito");

				DriverManager.setDriver(new ChromeDriver(chromeOptions));
			} else if (browser.equalsIgnoreCase("firefox")) {

				DriverManager.setDriver(new FirefoxDriver());

			}

			else if (browser.equalsIgnoreCase("edge")) {

				DriverManager.setDriver(new EdgeDriver());

			}
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("screen-resolution", "1440x900");
			new DriverManager().getDriver().manage().window().maximize();
			new DriverManager().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			try {
				new DriverManager().getDriver().get(PropertyUtils.get(ConfigProperties.URL));
			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}

	public static void quitDriver() {

		if (Objects.nonNull(DriverManager.getDriver())) {

			DriverManager.getDriver().quit();
			DriverManager.unload();

		}

	}

}
