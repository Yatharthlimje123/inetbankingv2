package com.inetBankingV.testCases;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event.ID;

import com.inetBanking.pageObjects.EditCutomer;
import com.inetBanking.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass {
	WebDriverWait wait;

	@Test
	public void editCustomer() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		logger.info("URL loaded successfully");
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username accepted");
		lp.setPassword(password);
		logger.info("Password accepted");
		lp.setSubmit();

		EditCutomer ed=new EditCutomer(driver);
		String customerEmail = "nansoyic@gmail.com";
		ed.openEditSectionByEmail(customerEmail);
		logger.info("Click on xyz customer");
		ed.cust_edit();
		logger.info("edit button click");
		Thread.sleep(2000);
		
		
		String name_cust=randomFirstName();
		ed.cust_FirstName(name_cust);
		logger.info("FirstName updated");
		
		String lastName_cust=randomLastName();
		ed.cust_lastName(lastName_cust);
		logger.info("Lastname updated");
		
		String phoneNumber_cust=randomeNumber();
		ed.cust_phone(phoneNumber_cust);
		logger.info("PhoneNumnber updated");
		
		ed.cust_subButton();
		logger.info("customer updatd updated");
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
			    .withTimeout(Duration.ofSeconds(20))
			    .pollingEvery(Duration.ofSeconds(2))
			    .ignoring(NoSuchElementException.class);

			// Function to check if element text is not empty
			WebElement firstNameElement = wait.until(new Function<WebDriver, WebElement>() {
			    public WebElement apply(WebDriver driver) {
			        WebElement element = driver.findElement(By.id("firstName"));
			        String text = element.getText();
			        if (!text.isEmpty()) {
			            return element;
			        } else {
			            return null;
			        }
			    }
			});


	
		logger.info("PhoneNumnber updated");
		

		try {
			// Assertions
			Assert.assertEquals(ed.verify_FirstName(), name_cust);
			Assert.assertEquals(ed.verify_lastName(), lastName_cust);
			Assert.assertEquals(ed.verify_phone(), phoneNumber_cust);
		} catch (AssertionError e) {
			// Handle assertion failure
			logger.error("Assertion failed: " + e.getMessage());
			// You can add further steps here like capturing screenshots, logging additional
			// information, etc.
			throw e; // Re-throw the exception to mark the test as failed
		}
		
	}
}