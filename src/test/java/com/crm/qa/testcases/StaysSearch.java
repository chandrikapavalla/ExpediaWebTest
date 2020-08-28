package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.StaysPage;

/**
 * @author Chandu
 *
 */
public class StaysSearch extends TestBase {

	Logger log = Logger.getLogger(StaysSearch.class);

	StaysPage homepage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		initializaton(browser);
		homepage = new StaysPage();
	}


	@Test(description = "Verify weather user able to search hotels in stays tab")
	public void TC_01() {

		try {
			log.info("Start TC_01 :::::::::");
			homepage.verifyTitle();
			homepage.verifyWelcomeText();
			homepage.toolBarMenu("stays");
			homepage.inputDestination("glasgow");
			homepage.selectCheckinDate("Sep", "2");
			implicitWait(3);
			homepage.selectCheckOutDate("Sep", "10");
			implicitWait(3);
			homepage.verifytravellersInf(3, 1, "4");
			implicitWait(3);
			homepage.clickSearch();
			implicitWait(5);
			homepage.filters("Wonderful 4.5+");
			log.info("Start TC_01 :::::::::");
			// assertNotNull(object);
			// assertEquals(actual, expected);
		} catch (Exception e) {
			log.error("Error in TC_01 :::::::" + e.getMessage());
		}
	}

	
	@AfterClass
	public void tearDown() {
		// FormatResult();
		tearDownMain();
	}

}
