package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FlightPage;

/**
 * @author Chandu
 *
 */
public class FlightsSearch extends TestBase {

	Logger log = Logger.getLogger(FlightsSearch.class);
	FlightPage flightpage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		initializaton(browser);
		flightpage = new FlightPage();
	}

	

	@Test(description = "Verify weather user able to search flights or not")
	public void TC_01() {
		log.info("Start TC_01 :::::::::");
		flightpage.toolBarMenu("flights");
		flightpage.verifyRoundtrip();
		flightpage.selectCheckinDate("Sep", "3");
		flightpage.selectCheckOutDate("Sep", "5");
		flightpage.VerifytravellersInfo(2, 1, 1, "3", "0");
		flightpage.flightClass("Business class");
		flightpage.clickSearch();
		flightpage.sortandFilter();
		log.info("End TC_01 :::::::::");
	}

	@AfterMethod
	public void tearDown() {
		// FormatResult();
		tearDownMain();
	}

}
