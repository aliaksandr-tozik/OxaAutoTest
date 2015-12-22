package tests;

import check.Screenshoter;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Aliaksandr Tozik
 */
public class TestsWithReport {
    ExtentReports report;
    ExtentTest test;
    WebDriver driver;
    final String REPORT_PATH="./reports/my_test_report.html";
    final String SCREEN_FOLDER="./reports/screenshots/";
    final String IMG="./screenshots/";

    @BeforeClass
    public void beforeClass() {
        report= new ExtentReports(REPORT_PATH, true);
        report.addSystemInfo("Environment", "Test server");
        report.addSystemInfo("Host Name", "My host");
        report.addSystemInfo("User Name", "User");
    }


    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @Test
     public void myTest1(){
        test=report.startTest("My first test");
        test.log(LogStatus.INFO, "Test #1 is started");
        driver.get("http://oxagile.com");
        test.log(LogStatus.INFO, "Page #1 is opened");
        try{
            Assert.assertTrue(driver.getTitle().contains("Oxagile"));
            test.log(LogStatus.PASS, "Test #1 passed");
        }catch(AssertionError e){

            String screen=Screenshoter.takeScreenshot(driver, SCREEN_FOLDER+"test1fail.png");
            String img=test.addScreenCapture(IMG+screen);
            test.log(LogStatus.FAIL, "Test #1 failed "+img);
        }
    }

    @Test
    public void myTest2(){
        test=report.startTest("My second test");
        test.log(LogStatus.INFO, "Test #2 is started");
        driver.get("http://oxagile.com");
        test.log(LogStatus.INFO, "Page #2 is opened");
        try{
            Assert.assertTrue(driver.getTitle().contains("2Oxagile"));
            test.log(LogStatus.PASS, "Test #2 passed");
        }catch(AssertionError e){
            String screen=Screenshoter.takeScreenshot(driver, SCREEN_FOLDER+"test2fail.png");
            String img=test.addScreenCapture(IMG+screen);
            test.log(LogStatus.FAIL, "Test #2 failed "+img);
        }
    }

    @Test
    public void myTest3(){
        test=report.startTest("My third test");
        test.log(LogStatus.INFO, "Test #3 is started");
        driver.get("http://oxagile.com");
        test.log(LogStatus.INFO, "Home page #3 is opened");
        driver.get("http://oxagile.com/company");
        test.log(LogStatus.INFO, "'About us' page #3 is opened");
        try{
            Assert.assertTrue(driver.getTitle().contains("Oxagile"));
            test.log(LogStatus.PASS, "Test #3 passed");
        }catch(AssertionError e){
            String screen=Screenshoter.takeScreenshot(driver, SCREEN_FOLDER+"test3fail.png");
            String img=test.addScreenCapture(IMG+screen);
            test.log(LogStatus.FAIL, "Test #3 failed "+img);
        }

    }

    @AfterMethod
    public void tearDown(ITestResult result){
        report.endTest(test);
        report.flush();
        driver.quit();
    }

    @AfterSuite
    protected void afterSuite() {
        report.close();
    }

}

