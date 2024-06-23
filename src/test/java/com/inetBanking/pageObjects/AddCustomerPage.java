package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@id='add-contact']")
	WebElement Add_coustamer;

	@FindBy(xpath = "(//input[@id='firstName'])[1]")
	WebElement First_name;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement last_name;

	@FindBy(id = "email")
	WebElement email_id;

	@FindBy(id = "phone")
	WebElement phn_number;

	@FindBy(id = "street1")
	WebElement Strrt_add1;

	@FindBy(id = "street2")
	WebElement strrt_add2;

	@FindBy(id = "city")
	WebElement city_field;

	@FindBy(id = "stateProvince")
	WebElement State_filed;

	@FindBy(id = "postalCode")
	WebElement postal_code;

	@FindBy(id = "country")
	WebElement country_name;

	@FindBy(id = "submit")
	WebElement Submit_cust;

	@FindBy(id = "birthdate")
	WebElement cust_Bday;

	public void addCustomer() {
		Add_coustamer.click();
	}

	public void custfirstName(String firstName) {
		First_name.sendKeys(firstName);
	}

	public void custLastName(String lastName) {
		last_name.sendKeys(lastName);
	}

	public void custBirthDay(String yy, String mm, String dd) {
		cust_Bday.sendKeys(yy);
		cust_Bday.sendKeys(mm);
		cust_Bday.sendKeys(dd);

	}

	public void custEmailId(String emailID) {
		email_id.sendKeys(emailID);
	}

	public void custPhoneNumber(String phoneNumber) {
		phn_number.sendKeys(phoneNumber);
	}

	public void custStreetAdd1(String streetAdd1) {
		Strrt_add1.sendKeys(streetAdd1);
	}

	public void custStreetAdd2(String streetAdd1) {
		strrt_add2.sendKeys(streetAdd1);
	}

	public void custCity(String cityname) {
		city_field.sendKeys(cityname);
	}

	public void custStatefield(String stateName) {
		State_filed.sendKeys(stateName);
	}

	public void custPostalcode(String postalCode) {
		postal_code.sendKeys(postalCode);
	}

	public void custContryName(String countryName) {
		country_name.sendKeys(countryName);
	}

	public void submitButton() {
		Submit_cust.click();
		
	}

}
