package com.crm.qa.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.FlightsSearch;

/**
 * @author Chandu
 *
 */
public class FlightPage extends TestBase {

	Logger log = Logger.getLogger(FlightsSearch.class);

	/**
	 * 
	 */
	public FlightPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class='uitk-tabs-inner-container'] li")
	List<WebElement> triptype;

	@FindBy(css = "[aria-label='Leaving from']")
	WebElement input_leavingFrom;

	@FindBy(css = "[aria-label='Going to']")
	WebElement input_goingTo;

	@FindBy(css = "[id='location-field-leg1-destination']")
	WebElement txt_destination;

	@FindBy(css = "#location-field-leg1-origin")
	WebElement txt_origin;

	@FindBy(css = "a[data-testid='travelers-field']")
	WebElement drpdn_traveller;

	@FindBy(css = "svg[aria-labelledby*='increase-adults']")
	WebElement btn_increaseAdults;

	@FindBy(css = "svg[aria-labelledby*='step-increase-children']")
	WebElement btn_increaseChild;

	@FindBy(css = "[aria-labelledby*='step-decrease-children']")
	WebElement btn_decreaseChild;

	@FindBy(css = "[aria-labelledby*='-step-decrease-adults']")
	WebElement btn_decreaseAdult;

	@FindBy(css = "#child-age-input-0-0")
	WebElement drpdn_childage;

	@FindBy(css = "[aria-labelledby*='step-increase-infants']")
	WebElement btn_increaseinfants;

	@FindBy(css = "#infant-age-input-0-0")
	WebElement drpdn_infantAge;

	@FindBy(css = "div[class='uitk-scrim guestsDoneBtn fade-button']")
	WebElement btn_Done;

	@FindBy(css = "a[aria-label='Preferred flight class Economy']")
	WebElement lnk_flight;

	@FindBy(css = "[aria-label='Preferred flight class Economy']+div>div>a")
	List<WebElement> lnk_flightclass;

	@FindBy(css = "#d1-btn")
	WebElement btn_departing;

	@FindBy(css = "table[class='uitk-new-date-picker-weeks']>thead+tbody>tr>td+td>button")
	List<WebElement> clk_datePicker;

	@FindBy(css = "#d2-btn")
	WebElement btn_returning;

	@FindBy(css = "[aria-label='Sep 8, 2020 selected, current check in date.']")
	WebElement checkInDate;

	@FindBy(css = "[data-stid='apply-date-picker']")
	WebElement btn_ApplyDate;

	@FindBy(css = "[aria-label='Sep 10, 2020']")
	WebElement checkOutDate;

	@FindBy(css = "button[data-testid='submit-button']")
	WebElement btn_Search;

	@FindBy(css = "select[id='sortDropdown']")
	WebElement drpdn_sort;

	@FindBy(css = "#uitk-tabs-button-container li")
	List<WebElement> list_TabContainers;

	@FindBy(css = "#departure-times-Afternoon-flights-checkbox +input")
	WebElement chk_departuretime;

	/**
	 * This method used to select the desired menu
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
				}
			}

		} catch (Exception e) {
			log.error("In Flight search page, error while selecting menu bar:::" + e.getMessage());
		}
	}

	/**
	 * This method is used to be set the round trip radio button using the
	 */
	public void verifyRoundtrip() {
		try {
			input_leavingFrom.click();
			txt_origin.sendKeys("glasgow");
			txt_origin.sendKeys(Keys.ARROW_DOWN.ENTER);

			input_goingTo.click();
			txt_destination.sendKeys("london");
			implicitWait(2);
			scrollToView(txt_destination);
			txt_destination.sendKeys(Keys.ARROW_DOWN.ARROW_DOWN.ENTER);
		} catch (Exception e) {
			log.error("In Flight search page, error while verifying the roundtrip:::" + e.getMessage());
		}

	}

	/**
	 * This method is used to select check in Date
	 * 
	 * @param MonthName
	 * @param date
	 */
	public void selectCheckinDate(String MonthName, String date) {
		try {
			btn_departing.click();
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
			log.error("In Flight search page, error while selecting check in Date:::" + e.getMessage());
		}
	}

	/**
	 * This method is used to select check out Date
	 * 
	 * @param MonthName
	 * @param date
	 */
	public void selectCheckOutDate(String MonthName, String date) {
		try {
			implicitWait(2);
			btn_returning.click();
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
			log.error("In Flight search page, error while selecting Check out date:::" + e.getMessage());
		}
	}

	/**
	 * This method is used to set the traveller information
	 * 
	 * @param Adultcount
	 * @param childcount
	 * @param infantcount
	 * @param childage
	 * @param infantage
	 */
	public void VerifytravellersInfo(int Adultcount, int childcount, int infantcount, String childage,
			String infantage) {
		try {
			drpdn_traveller.click();
			for (int i = 1; i < Adultcount; i++) {
				btn_increaseAdults.click();
			}
			for (int j = 0; j < childcount; j++) {
				btn_increaseChild.click();
				drpdn_childage.click();
				Select childAge = new Select(drpdn_childage);
				childAge.selectByValue(childage);
			}
			for (int k = 0; k < infantcount; k++) {
				btn_increaseinfants.click();
				drpdn_infantAge.click();
				Select infant = new Select(drpdn_infantAge);
				infant.selectByValue(infantage);
				btn_Done.click();
			}
		} catch (Exception e) {
			log.error("In Flight search page, error while selecting traveller info:::" + e.getMessage());
		}

	}

	/**
	 * This method is used to set select the flight class
	 * 
	 * @param className
	 */
	public void flightClass(String className) {
		try {
			lnk_flight.click();
			for (WebElement flightClass : lnk_flightclass) {
				if (flightClass.getText().equalsIgnoreCase(className)) {
					flightClass.click();
				}

			}
		} catch (Exception e) {
			log.error("In Flight search page, error while selecting flight class:::" + e.getMessage());
		}

	}

	/**
	 * This method is used to click the search button
	 */
	public void clickSearch() {
		try {
			btn_Search.click();
		} catch (Exception e) {
			log.error("In Flight search page, error while click the search button:::" + e.getMessage());
		}
	}

	/**
	 * This method is used to apply filters
	 */
	public void sortandFilter() {
		try {
			drpdn_sort.click();
			Select filtersearch = new Select(drpdn_sort);
			filtersearch.selectByValue("price:desc");
			implicitWait(5);
			chk_departuretime.click();
			Assert.assertTrue(chk_departuretime.isSelected());  
		} catch (Exception e) {
			log.error("In Flight search page, error while applying the filters:::" + e.getMessage());
		}

	}
}
