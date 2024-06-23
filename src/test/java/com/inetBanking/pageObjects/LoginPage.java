package com.inetBanking.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	WebElement user_name;;
	@FindBy(id = "password")
	WebElement pass_word;
	@FindBy(id = "submit")
	WebElement sub_button;
	@FindBy(id="logout")
	WebElement Log_out;

	public void setUsername(String username) {
		user_name.clear();
		user_name.sendKeys(username);
	}
	
	public void setPassword(String password) {
		pass_word.clear();
		pass_word.sendKeys(password);
	}
	
	public void setSubmit() {
		sub_button.click();
	}
	
	public void logOutButton() {
		Log_out.click();
		
	}

}
