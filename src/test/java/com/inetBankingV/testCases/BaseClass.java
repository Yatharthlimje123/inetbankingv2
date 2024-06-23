package com.inetBankingV.testCases;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.ReadConfig;

import ch.qos.logback.core.util.FileUtil;

public class BaseClass {
	ReadConfig readConfig=new ReadConfig();
	
    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    
    public static Logger logger;
    
    @Parameters("browser")
    @BeforeClass
    public void setUp(String br) {
       
        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");
        if(br.equals("chrome")) {
        	 driver = new ChromeDriver();
        }
        else if(br.equals("firefox")) {
        	 driver = new FirefoxDriver();
        }
        driver.get(baseURL);
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
    }
    
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    
    public void captureScreen(WebDriver driver, String screenshotName) throws IOException{
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File target=new File (System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot taken");
		
	}
 // To add randome email ID we have to use below user define function
 	public String randomeString() {
 		String genratedString = RandomStringUtils.randomAlphabetic(8);
 		return (genratedString);
 	}
 	// To add randome number we have to use below user define function
 	
 	public String randomeNumber() {
 		String gernatedNumber=RandomStringUtils.randomNumeric(10);
 		return(gernatedNumber);
 		
 	}
    
    
    
}