package com.crm.qa.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;

/**
 * @author chandu
 *
 */
public class CarsPage extends TestBase {
	Logger log = Logger.getLogger(CarsPage.class);

	public CarsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[aria-controls='Rental-cars-transportation'] span")
	WebElement lnk_RentalCars;

	@FindBy(css = "[aria-label='Pick-up']")
	WebElement input_Pickup;

	@FindBy(css = "[data-stid='location-field-locn-menu-input']")
	WebElement txt_Pickup;

	@FindBy(css = "button[aria-label='Drop-off london']")
	WebElement input_dropOff;

	@FindBy(css = "[data-stid='location-field-loc2-menu-input']")
	WebElement txt_dropoff;

	@FindBy(css = "#d1-btn")
	WebElement clk_pickupDate;

	@FindBy(css = "#d2-btn")
	WebElement clk_dropOffDate;

	@FindBy(css = "table[class='uitk-new-date-picker-weeks']>thead+tbody>tr>td>button")
	List<WebElement> clk_datePicker;

	@FindBy(css = "[data-stid='apply-date-picker']")
	WebElement btn_ApplyDate;

	@FindBy(css = "select[aria-label='Pick-up time']")
	WebElement drpdn_PickupTime;

	@FindBy(css = "select[aria-label='Drop-off time']")
	WebElement drpdn_dropOffTime;

	@FindBy(css = "input[id='aarp-checkbox-toggle']")
	WebElement chk_AARPmember;

	@FindBy(css = "select[aria-label='Preferred brand']")
	WebElement drpdn_preferredBrand;

	@FindBy(css = "[data-testid='submit-button']")
	WebElement btn_Search;

	@FindBy(css = "span[class='is-visually-hidden']+span")
	WebElement lnk_discountCode;

	@FindBy(css = "select[aria-label='Discount type']")
	WebElement drpdn_discountType;

	@FindBy(css = "[aria-controls='Airport-transportation'] span")
	WebElement lnk_airportTransformation;

	@FindBy(css = "[aria-label='Airport']+span")
	WebElement input_airport;

	@FindBy(css = "[data-stid='location-field-location-menu-input']")
	WebElement txt_Airport;

	@FindBy(css = "[aria-label='Hotel name']")
	WebElement input_hotelName;

	@FindBy(css = "#location-field-hotelName")
	WebElement txt_hotelName;

	@FindBy(css = "select[aria-label='Flight arrival time']")
	WebElement drpdn_flightArrivaltime;

	@FindBy(css = "[data-testid='submit-button']")
	WebElement btn_search;

	@FindBy(css = "book-roundtrip-toggle")
	WebElement chk_bookRoundTrip;

	@FindBy(css = "#uitk-tabs-button-container li")
	List<WebElement> list_TabContainers;

	/**
	 * This method is used to select the menu
	 * 
	 * @param req_Tab
	 */
	public void toolBarMenu(String req_Tab) {
		try {
			String tabName = "";

			for (WebElement tab : list_TabContainers) {
				tabName = tab.getText();
				if (tabName.equalsIgnoreCase(req_Tab)) {
					tab.click();
					break;
				}

			}
		} catch (Exception e) {
			log.error("In Cars page, error occured while seecting the menu:::" + e.getMessage());
		}
	}

	/**
	 * This method is used to set the pickup and drop off
	 */
	public void rentalCars() {
		try {
			scrollToView(input_Pickup);
			implicitWait(5);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", input_Pickup);
			txt_Pickup.sendKeys("london");
			txt_Pickup.sendKeys(Keys.ARROW_DOWN.ENTER);

			input_dropOff.click();
			txt_dropoff.clear();
			txt_dropoff.sendKeys("central london");
			scrollToView(txt_dropoff);
			txt_dropoff.sendKeys(Keys.ARROW_DOWN.ENTER);
			implicitWait(2);
		} catch (Exception e) {
			log.error("In Cars page, error occured while setting the pickup and dropoff :::" + e.getMessage());
		}

	}

	/**
	 * This method is used to set the checkin date
	 * 
	 * @param MonthName
	 * @param date
	 */
	public void selectCheckinDate(String MonthName, String date) {
		try {
			clk_pickupDate.click();
			implicitWait(5);
			for (WebElement dat : clk_datePicker) {
				String calendarDate = dat.getAttribute("aria-label");
				if (calendarDate.contains(MonthName) && calendarDate.contains(date)) {
					scrollToView(dat);
					dat.click();
					log.info("Check in Date :::::::::" + calendarDate);
					scrollToView(btn_ApplyDate);
					btn_ApplyDate.click();
					break;
				}
			}
		} catch (Exception e) {
			log.error("In Cars page, error occured while setting the checkin date :::" + e.getMessage());
		}
	}

	/**
	 * This method is used to set the check out date using date picker
	 * 
	 * @param MonthName
	 * @param date
	 */
	public void selectCheckOutDate(String MonthName, String date) {
		try {
			implicitWait(2);
			clk_dropOffDate.click();
			implicitWait(5);
			for (WebElement dat : clk_datePicker) {
				String calendarDate = dat.getAttribute("aria-label");
				if (calendarDate.contains(MonthName) && calendarDate.contains(date)) {
					scrollToView(dat);
					dat.click();
					log.info("Check out Date :::::::::" + calendarDate);
					scrollToView(btn_ApplyDate);
					btn_ApplyDate.click();
					break;
				}
			}
		} catch (Exception e) {
			log.error("In Cars page, error occured while setting the checkout date :::" + e.getMessage());
		}
	}

	/**
	 * This method is used to set the checkin time and dropoff time
	 * 
	 * @param pickuptime
	 * @param dropofftime
	 */
	public void timings(String pickuptime, String dropofftime) {

		try {
			Select picktime = new Select(drpdn_PickupTime);
			picktime.selectByValue(pickuptime);

			Select droptime = new Select(drpdn_dropOffTime);
			droptime.selectByValue(dropofftime);
		} catch (Exception e) {
			log.error(
					"In Cars page, error occured while setting the pickup time and dropoff time :::" + e.getMessage());
		}

	}

	/**
	 * This method is used to select the member ship card
	 */
	public void applyMemebership() {
		try {
			if (!chk_AARPmember.isSelected()) {
				chk_AARPmember.click();
			}
		} catch (Exception e) {
			log.error("In Cars page, error occured while applying the membership card :::" + e.getMessage());
		}

	}

	/**
	 * This method is used to apply the discount
	 * 
	 * @param brandName
	 * @param discountType
	 */
	public void applyDiscount(String brandName, String discountType) {
		try {
			lnk_discountCode.click();

			Select brand = new Select(drpdn_preferredBrand);
			brand.selectByVisibleText(brandName);

			Select discount = new Select(drpdn_discountType);
			discount.selectByVisibleText(discountType);
		} catch (Exception e) {
			log.error("In Cars page, error occured while applying the discount :::" + e.getMessage());
		}

	}

	/**
	 * This method is used to click the Search button
	 */
	public void clickSearch() {
		try {
			btn_Search.click(); 
			Assert.assertTrue("User successfully navigated to search results page",(driver.getTitle()).contains("Rental Cars and Car Rentals"));  	  
		} catch (Exception e) {
			log.error("In Cars page, error occured while clicking the search button :::" + e.getMessage());
		}
	}

}
