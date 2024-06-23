package com.inetBankingV.testCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.Utilities.XLUtils;
import com.inetBanking.pageObjects.LoginPage;

import ch.qos.logback.classic.Logger;

public class TC_LoginTest_002 extends BaseClass{
	
	@Test (dataProvider="Exceldata", dataProviderClass =XLUtils.class)
	public void name(String username, String password) throws IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.setSubmit();
		String name = driver.findElement(By.xpath("//h1[normalize-space()='Contact List']")).getText();
		Assert.assertEquals(name, "Contact List");
		logger.info("LogIn sucess");
		
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
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("aleart is present");
		}
		else {
		Assert.assertTrue(true);
		lp.logOutButton();
		}
		
	}
	
	//JUT FOR FEATURE WE HAVE ADDED ALERT EXCEPTION
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
 		}
	}
	

}
