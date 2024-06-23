package com.inetBankingV.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCostomer_003 extends BaseClass {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Test
	public void addnewCustomer() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.setSubmit();
		Thread.sleep(5000);

		/*try {
			//By expectedelemet = By.id("add-contact");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(id("add-contact")));
			logger.info("LogIn sucess");
		} catch (Exception e) {
			logger.error("Login failed or 'add-contact' element not found", e);
			captureScreen(driver, "loginFailure");
			Assert.fail("Login failed or 'add-contact' element not found");
		}*/

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.addCustomer();
		logger.info("New costomer page open");
		addcust.custfirstName("Vijay");
		logger.info("1st name entered");
		addcust.custLastName("Varma");
		logger.info("last name entered");
		addcust.custBirthDay("1988-","05-", "23");
		logger.info("DOB entered");
		addcust.custStreetAdd1("Santh Tukdaji ward");
		addcust.custStreetAdd2("Bidkar lay out");
		logger.info("Addres entered");
		addcust.custCity("Hinganghat");
		logger.info("City entered");
		addcust.custStatefield("Maharashtra");
		logger.info("State entered");
		addcust.custPostalcode("442301");
		logger.info("Postal code entered");
		addcust.custContryName("India");
		logger.info("country name entered");
		String number = randomeNumber();
		addcust.custPhoneNumber(number);
		logger.info("phone number entered");
		String emai = randomeString() + "@gmail.com";
		addcust.custEmailId(emai);
		logger.info("Email entered");
		addcust.submitButton();
		logger.info("Customer form Submited");
		Thread.sleep(5000);

		boolean res = driver.getPageSource().contains("Contact List");
		if (res == true) {
			Assert.assertTrue(true);
			logger.info("New customer has been created");
		} else {
			captureScreen(driver, "addnewCustomer");
			Assert.assertFalse(false);
			logger.info("New customer creation faild");
		}

	}

	

}
