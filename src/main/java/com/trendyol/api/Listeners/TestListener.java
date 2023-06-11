package com.trendyol.api.Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;


import com.trendyol.api.Utils.ExtentReportManager;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static com.trendyol.ui.Utils.BrowserUtils.getDriver;

public class TestListener implements ITestListener {
    Logger logger;
    private ConcurrentHashMap<String, ExtentTest> allTests = new ConcurrentHashMap<>();
    String reportFolderPath = System.getProperty("user.dir") + "/AutomationReports/";
    String reportName = "AutomationReport.html";
    WebDriver driver;

    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentReportManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTest extentTest = ExtentReportManager.createInstance(reportFolderPath, reportName).createTest(iTestResult.getMethod().getMethodName());
        allTests.put(iTestResult.getClass().getSimpleName(), extentTest);
        ExtentReportManager.setTest(extentTest);
        extentTest.log(Status.INFO, MarkupHelper.createLabel("Test started: " + iTestResult.getMethod().getMethodName(), ExtentColor.BLUE));
        ExtentReportManager.getInstance().flush();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentReportManager.getTest().get().assignCategory(iTestResult.getClass().getSimpleName());
        ExtentReportManager.getTest().get().createNode(MarkupHelper.createLabel("Test passed", ExtentColor.GREEN).getMarkup());
        ExtentReportManager.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            ExtentReportManager.getTest().get().createNode(MarkupHelper.createLabel("Test Failed", ExtentColor.RED).getMarkup())
                    .fail(iTestResult.getThrowable());
            ExtentReportManager.getInstance().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }
}