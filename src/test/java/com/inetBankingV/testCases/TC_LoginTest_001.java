package com.inetBankingV.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {

		logger.info("URL loaded successfully");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username accepted");
		lp.setPassword(password);
		logger.info("Password accepted");
		lp.setSubmit();
		logger.info("Login successful");
		Thread.sleep(5000);

		// Get the page title
		String pageTitle = driver.getTitle();

		// Expected page title
		String expectedTitle = "My Contacts";

		// Check if the actual page title matches the expected title
		if (pageTitle.equals(expectedTitle)) {
			logger.info("Page title is correct: " + pageTitle);
		} else {
			captureScreen(driver, "loginTest");
			logger.error("Expected page title: " + expectedTitle);
			logger.error("Actual page title: " + pageTitle);
			throw new AssertionError("Page title assertion failed");
		}
	}
}
