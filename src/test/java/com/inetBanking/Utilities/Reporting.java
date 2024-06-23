package com.inetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
    ExtentReports extent;
    ExtentSparkReporter Spark;
    public ExtentTest logger;
    WebDriver driver;
    
    public Reporting() {
        extent = new ExtentReports();
        Spark = new ExtentSparkReporter("extentreport/Spark.html");
        extent.attachReporter(Spark);
        
        extent.setSystemInfo("Hostname", "Local Host");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Suraj");
        
        Spark.config().setDocumentTitle("InetBanking Test Project");
        Spark.config().setReportName("Functional Test Report");
        Spark.config().setTheme(Theme.DARK);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger = extent.createTest(result.getName()); // create new entry in report
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN)); // send the passed information
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger = extent.createTest(result.getName()); // create new entry in report
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED)); // send the failed information
        
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png";
        File f = new File(screenshotPath);
        
        if (f.exists()) {
            try {
                logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger = extent.createTest(result.getName()); // create new entry in report
        logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE)); // send the skipped information
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    // Utility method to capture screenshots
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/Screenshots/"));
            String dest = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + ".png";
            File destination = new File(dest);
            Files.copy(src.toPath(), destination.toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}