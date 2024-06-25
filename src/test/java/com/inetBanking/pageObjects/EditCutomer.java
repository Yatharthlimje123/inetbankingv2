package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

import java.time.Duration;

public class EditCutomer {

	private WebDriver driver;
	private WebDriverWait wait;

	public EditCutomer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(id = "edit-contact")
	WebElement edit_button;

	@FindBy(xpath = "//form[@id='edit-contact']/p[1]/input")
	WebElement first_name;

	@FindBy(id = "lastName")
	WebElement Last_name;

	@FindBy(id = "phone")
	WebElement phon_no;
	
	@FindBy(id = "submit")
	WebElement submit_button;
	
	@FindBy(id = "firstName")
	WebElement Veri_firstname;

	// Method to click anywhere on customer row to open edit section
	public void openEditSectionByEmail(String email) {
		// XPath to locate the customer row based on the email dynamically
		String xpath = "//table[@class='contactTable']//tr[td[text()='" + email + "']]";
		WebElement customerRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		customerRow.click(); // Clicking on the row to open edit section
	}
	public void cust_edit() {
		edit_button.click();
		
	}
	
	public void cust_FirstName(String fistname) {
		first_name.clear();
		first_name.sendKeys(fistname);
		
	}
	
	public void cust_lastName(String lastname) {
		Last_name.clear();
		Last_name.sendKeys(lastname);
	}
	public void cust_phone(String lastname) {
		phon_no.clear();
		phon_no.sendKeys(lastname);
		
	}
	public void cust_subButton() {
		submit_button.click();
		
	}
	
	public String verify_FirstName() {
	String firstnameverify=	Veri_firstname.getText();
	return firstnameverify;
		
	}
	
	public String verify_lastName( ) {
		String lastnameverify= Last_name.getText();
		return lastnameverify;
	}
	public String verify_phone() {
		String phoneVerify= phon_no.getText();
		return phoneVerify;
	}

}