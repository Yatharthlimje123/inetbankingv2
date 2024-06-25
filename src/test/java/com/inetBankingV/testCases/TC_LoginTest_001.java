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
		
	}
}
