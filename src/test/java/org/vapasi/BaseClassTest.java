package org.vapasi;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClassTest {

    WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports extentreports;
    ExtentTest extenttest;

    @BeforeClass
    public void beforeTest(){
        //setting the place where to store the report
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/testReport.html");
        extentreports = new ExtentReports();
        extentreports.attachReporter(htmlReporter);

        //Creating the test report name
        extenttest = extentreports.createTest("New user order");
        extenttest.log(Status.INFO,"Testing started");

        //setting the test report's details
        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        htmlReporter.config().setDocumentTitle("Test Report of New User Order");
        htmlReporter.config().setReportName("New user ordered using check ");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

    }

    @BeforeMethod
    public void openingBrowser(){
        System.setProperty("webdriver.chrome.driver","./Driver/chromedriver");
        driver = new ChromeDriver();

        //Asking browser to go for this particular website
        driver.get("https://spree-vapasi-prod.herokuapp.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closingBroswer(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE){
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir")+"/screenshots/"+"test.png";
            File destFile = new File(screenshotPath);
            System.out.println(destFile.getAbsoluteFile());
            // now copy the  screenshot to desired location using copyFile method
            FileUtils.copyFile(srcFile,destFile);
            extenttest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test Failed", ExtentColor.RED));
            extenttest.fail(result.getThrowable().getMessage());
            extenttest.addScreenCaptureFromPath(screenshotPath);
        }
        else if(result.getStatus() == ITestResult.SUCCESS)  {
            extenttest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Passes", ExtentColor.GREEN));
        }
        extenttest.log(Status.INFO,"Test Completed");
        extentreports.flush();
        driver.close();
        driver.quit();
    }
}
