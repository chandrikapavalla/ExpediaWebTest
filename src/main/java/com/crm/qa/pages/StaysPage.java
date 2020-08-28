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

/**
 * @author Chandu
 *
 */
public class StaysPage extends TestBase {

	Logger log = Logger.getLogger(StaysPage.class);

	public StaysPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".redirect-banner-body span[class='redirect-banner-welcomeText']")
	WebElement welcome_Text;

	@FindBy(css = "#uitk-tabs-button-container li")
	List<WebElement> list_TabContainers;

	@FindBy(css = "#location-field-destination-menu > div.uitk-field.has-floatedLabel-label.has-icon.has-no-placeholder > button")
	WebElement destination_Name;

	@FindBy(css = "[placeholder='Where are you going?']")
	WebElement txt_Goingto;

	@FindBy(css = "#d1-btn")
	WebElement check_in_Date;

	@FindBy(css = "#d2-btn")
	WebElement check_Out_Date;

	@FindBy(css = "[data-stid='apply-date-picker']")
	WebElement btn_ApplyDate;

	@FindBy(css = "[class='uitk-faux-input'][data-testid='travelers-field-trigger']")
	WebElement travellers_Info;

	@FindBy(css = "svg[aria-labelledby*='increase-adults']")
	WebElement btn_IncreaseAdults;

	@FindBy(css = "svg[aria-labelledby*='adults-decrease']")
	WebElement btn_DecreaseAdults;

	@FindBy(css = "svg[aria-labelledby*='children-increase']")
	WebElement btn_IncreaseChilds;

	@FindBy(css = "[aria-labelledby*='children-decrease']")
	WebElement btn_DecreaseChilds;

	@FindBy(css = "select[id='child-age-input-0-0'] option")
	WebElement drpdn_ChildAge;

	@FindBy(css = "input[name='add-flight-switch']")
	WebElement chk_AddFlight;

	@FindBy(css = "#wizard-hotel-pwa-v2-1 > div.uitk-layout-grid.uitk-layout-grid-gap-three.uitk-layout-grid-columns-small-1.uitk-layout-grid-columns-medium-8.all-b-margin-two.all-t-margin-six.undefined > div.uitk-layout-grid-item.uitk-layout-grid-item-columnspan-small-1.uitk-layout-grid-item-columnspan-medium-2 > button")
	WebElement btn_Search;

	@FindBy(css = "div[class='uitk-new-date-picker-desktop-months-container'] div>h2")
	List<WebElement> monthContainer;

	@FindBy(css = "[aria-label='Sep 1, 2020 selected, current check in date.']")
	WebElement checkIn;

	@FindBy(css = "[class='uitk-new-date-picker-day-number end endSelected'] button")
	WebElement checkOut;

	@FindBy(css = "button[type='button'] span")
	WebElement btn_done;

	@FindBy(css = "legend[class='filter-title'] div")
	List<WebElement> filterTitles;

	@FindBy(css = "[id='guestRating-legend']+div>fieldset>div>div>div>input+span+div>label")
	List<WebElement> guest_rating_filter;

	@FindBy(css = "#price-3-3")
	WebElement chk_budgetfilter;

	@FindBy(css = "#lodging-0-HOTEL")
	WebElement chk_property;

	@FindBy(css = "table[class='uitk-new-date-picker-weeks']>thead+tbody>tr>td>button")
	List<WebElement> clk_datePicker;
	
	@FindBy(css = "[class='uitk-icon uitk-step-input-icon uitk-icon-medium']")
	List<WebElement> list_travellers;
	
	

	/**
	 * This method is used to click the required menu
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
					log.info("tab name:::::" + req_Tab);
				}

			}
			log.info(req_Tab);
		} catch (Exception e) {
			log.error("In Stays page, error while selecting menu bar:::" + e.getMessage());
		}

	}

	/**
	 * method this method is used to set the destination location using the send
	 * keys
	 * 
	 * @param destinationPlace
	 */
	public void inputDestination(String destinationPlace) {
		try {
			destination_Name.click();
			txt_Goingto.sendKeys(destinationPlace);
			txt_Goingto.sendKeys(Keys.ARROW_DOWN.ENTER);
			// txt_Goingto.sendKeys(Keys.ENTER);
			// implicitWait(1);
			log.debug("Going location :::::::" + txt_Goingto.getText());
		} catch (Exception e) {
			log.error("In Stays page, error while setting the destination location:::" + e.getMessage());
		}

	}

	/**
	 * This method is used to set the check in date using date picker
	 * 
	 * @param MonthName
	 * @param date
	 */
	public void selectCheckinDate(String MonthName, String date) {
		try {
			check_in_Date.click();
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
			log.error("In Stays page, error while setting the check in date using date picker:::" + e.getMessage());
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
			check_Out_Date.click();
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
			log.error("In Stays page, error while setting the check out date using date picker:::" + e.getMessage());
		}
	}
	
	
	
	
	/**
	 * This method is used to set the traveller's information
	 * 
	 * @param Adultcount
	 * @param childcount
	 * @param ageOfChild
	 */
	public void verifytravellersInf(int Adultcount, int childcount, String ageOfChild) {
		try {
			travellers_Info.click();
			log.info("User adding travellers information");
			implicitWait(3);
			for( WebElement traveller: list_travellers) {
				String label = traveller.getAttribute("aria-labelledby");
				if(label.contains("increase")&& label.contains("adults")) {
					traveller.click();
					log.info("User added adult travellers information");
				}
				
                if(label.contains("increase")&& label.contains("child")) {
                	log.info("User adding child  travellers count");
                	traveller.click();
    				log.info("User added the child Travellers information");
    				log.info("User entering the child age");
    				drpdn_ChildAge.click();
    				Select childAge = new Select(drpdn_ChildAge);
    				childAge.selectByValue(ageOfChild);
				}
				
			}
			
			scrollToView(btn_done);
			implicitWait(2);
			btn_done.click();
			
		} catch (Exception e) {
			log.error("In Stays page, error occuring while setting the Travveller info:::" + e.getMessage());
		}

	}
	

	/**
	 * This method is used to set the traveller's information
	 * 
	 * @param Adultcount
	 * @param childcount
	 * @param ageOfChild
	 */
	public void verifytravellersInfo(int Adultcount, int childcount, String ageOfChild) {
		try {
			travellers_Info.click();
			log.info("User adding travellers information");
			for (int i = 1; i < Adultcount; i++) {

				btn_IncreaseAdults.click();
				log.info("User added adult travellers information");
			}
			for (int j = 0; j < childcount; j++) {
				log.info("User adding child  travellers count");
				btn_IncreaseChilds.click();
				log.info("User added the child Travellers information");
				log.info("User entering the child age");
				drpdn_ChildAge.click();
				Select childAge = new Select(drpdn_ChildAge);
				childAge.selectByValue(ageOfChild);
				scrollToView(btn_done);
				implicitWait(2);
				btn_done.click();
			}
		} catch (Exception e) {
			log.error("In Stays page, error occuring while setting the Travveller info:::" + e.getMessage());
		}

	}

	/**
	 * This method is used to be click the search button using the action method
	 */
	public void clickSearch() {
		try {
			btn_Search.click();
			log.info("user clicked on search button");
			implicitWait(10);
			log.info("user Navigated to hotels page");
		} catch (Exception e) {
			log.error("In Stays page, error occuring while click the serach button:::" + e.getMessage());
		}
	}

	/**
	 * This method is used to set the filters
	 */
	public void filters(String guestRate) {
		try {
			for (WebElement guestRating : guest_rating_filter) {
				if (guestRate.equalsIgnoreCase(guestRating.getText())) {
					scrollToView(guestRating);
					guestRating.click();
					break;
				}

			}

			log.info("user applied filters to the search");
			implicitWait(10);
			log.info("user sucessfully applied the filter");
			scrollToView(chk_budgetfilter);
			log.info("user applied another filter to search");
			implicitWait(2);
			chk_budgetfilter.click();
			implicitWait(10);
			Assert.assertTrue(chk_budgetfilter.isSelected());  
			implicitWait(5);
			log.info("User successfully applied the filter to search");
		} catch (Exception e) {
			log.error("In Stays page, error occuring while set the filters :::" + e.getMessage());
		}

	}

	/**
	 * This method is used to get the main title.
	 */
	public String verifyTitle() {
		String main_Title = driver.getTitle();
		log.info(main_Title);
		return main_Title;

	}

	/**
	 * This method used to be get the welcome text
	 */
	public String verifyWelcomeText() {
		String actualWelcomeText = welcome_Text.getText();
		log.info(actualWelcomeText);
		return actualWelcomeText;

	}

}
