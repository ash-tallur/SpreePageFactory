package org.vapasi.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Reports {
    static ExtentReports extent =new ExtentReports();
    static ExtentSparkReporter spark;
    ExtentTest test;

    @BeforeSuite
    public void reportSetup(){
        extent.setSystemInfo("OS", "Mac");
        extent.setSystemInfo("Application", "Spree For Demo");
        extent.setSystemInfo("Env", "CI");
        if(spark == null) {
            spark = new ExtentSparkReporter("reports/testReport.html");
            extent.attachReporter(spark);
        }
    }

    @BeforeMethod
    public void testReportSetup(ITestResult result){
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void reportTest(ITestResult result, WebDriver driver){
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            TakesScreenshot ts = (TakesScreenshot)driver;
            test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64), "Failure Screenshot");
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
        extent.flush();
    }

}
