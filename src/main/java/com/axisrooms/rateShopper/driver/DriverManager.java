package com.axisrooms.rateShopper.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public  class DriverManager {

	private static ThreadLocal<WebDriver> dri = new ThreadLocal<>();

	public static WebDriver getDriver() {

		return dri.get();

	}

	public static void setDriver(WebDriver driver) {
		if (Objects.nonNull(driver)) {

			dri.set(driver);

		}

	}

	public static void unload() {
		dri.remove();

	}

}
