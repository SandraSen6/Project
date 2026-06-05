package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.LoginPage;
import page.ShoppingCartPage;
import page.ShippingDetailsPage;
import utility.ConfigReader;

public class Base {

    public static WebDriver driver;

    public LoginPage login;
    public ShoppingCartPage cart;
    public ShippingDetailsPage detail;

    public static ExtentReports extent;
    public static ExtentSparkReporter reporter;
    public static ExtentTest test;

    @BeforeTest
    public void setUp() {

        reporter = new ExtentSparkReporter("./Reports/myreport.html");
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Ecommerce Test");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Tester", "Sandra");
        extent.setSystemInfo("Browser", "Chrome");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(ConfigReader.getProperty("url"));
    }

  
    @BeforeMethod
    public void initPages() {

        test = extent.createTest(Thread.currentThread().getStackTrace()[2].getMethodName());

        login = new LoginPage(driver);
        cart = new ShoppingCartPage(driver);
        detail = new ShippingDetailsPage(driver);
    }

   
    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL, result.getName());
            test.log(Status.FAIL, result.getThrowable());

            String path = takeScreenshot(result.getName());
            test.addScreenCaptureFromPath(path);

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, result.getName());
        }
    }

    @AfterTest
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        extent.flush();
    }


    public String takeScreenshot(String testName) throws IOException {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir")
                + "/Screenshots/" + testName + ".png";

        File dest = new File(path);
        FileUtils.copyFile(src, dest);

        return path;
    }
}