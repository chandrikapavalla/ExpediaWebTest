package com.crm.qa.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CarsPage;

/**
 * @author Chandu
 *
 */
public class CarsSearch extends TestBase {
	Logger log = Logger.getLogger(CarsSearch.class);
	CarsPage carspage;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		initializaton(browser);
		carspage = new CarsPage();
	}

	@Test(description = "verify whether user able to serch for rental cars or not")
	public void TC_01()

	{
		log.info("Start TC_01 :::::::::");
		carspage.toolBarMenu("cars");
		carspage.rentalCars();
		carspage.selectCheckinDate("Sep", "4");
		carspage.selectCheckOutDate("Sep", "8");
		carspage.timings("0100AM", "0215AM");
		carspage.applyMemebership();
		carspage.clickSearch();
		log.info("End TC_01 :::::::::");
	}

	@AfterClass
	public void tearDown() {
		// FormatResult();
		tearDownMain();
	}

}
