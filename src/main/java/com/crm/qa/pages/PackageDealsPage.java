package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class PackageDealsPage extends TestBase{
	
	public PackageDealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[aria-label='Leaving from']")
	WebElement input_leavingfrom;
	

	@FindBy(css="[aria-label='Going to']")
	WebElement input_Goingto;


	@FindBy(css="#location-field-origin")
	WebElement txt_origins;


	@FindBy(css="#location-field-destination")
	WebElement txt_destination;


	@FindBy(css="[data-testid='submit-button']")
	WebElement clkSearch;


}
