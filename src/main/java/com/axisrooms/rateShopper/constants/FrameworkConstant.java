package com.axisrooms.rateShopper.constants;

import com.axisrooms.rateShopper.enums.ConfigProperties;
import com.axisrooms.rateShopper.utils.PropertyUtils;

// if we don't want to allow people to extend this  class make class as final
//if we want to restrict to people for creating object create private constructor
public final class FrameworkConstant {

	private FrameworkConstant() {

	}

	private static final String RESOURCESPATH = System.getProperty("user.dir");
	private static final String CHROMEDRIVERPATH = RESOURCESPATH + "/src/test/resources/Executables/chromedriver.exe";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/src/test/resources/config/rateShopperConfig.properties";
	private static final String EXCELFILEPATH = RESOURCESPATH + "/src/test/resources/excelFiles/rateShopperTestData.xlsx";
	private static final String JSONFILEPATH = RESOURCESPATH + "/src/test/resources/Json/config.json";
	private static final String EXTENTREPORTFOLDERPATH = RESOURCESPATH + "/RateShopperExtent-test-output";
	private static  String extentReportFilePath = "";
	private static final String RUNMANAGERSHEET="RateShopperTest";
	private static final String ITERATIONDATASHEET="RateShopperTestData";

	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportPath();
			
		}
		return extentReportFilePath;
	}
	private static String createReportPath() throws Exception  {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/rateShopperReport.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"/rateShopperReport.html";
		}
	}

	public static String getChromeDriverPath() {
		return CHROMEDRIVERPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String excelFilePath() {
		return EXCELFILEPATH;
	}

	public static String jsonFilePath() {
		return JSONFILEPATH;
	}
	
	public static String runManagerSheet() {
		return RUNMANAGERSHEET;
	}
	public static String iterationSheet() {
		return ITERATIONDATASHEET;
	}

	/*public static String extentReportPath() throws Exception {
		if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTPATH + "/" + System.currentTimeMillis() + "/index.html";
		}
		else {
			return EXTENTREPORTPATH+"/index.html";
			
		}
		
	}*/

}
