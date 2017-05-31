package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import ui.Login;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class TestGoogle {

    ExtentReports reports;


    @BeforeClass
    public void setup() {
        reports = new ExtentReports("./reports/result.html", true);
    }

    @Test
    public void testLogin() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://adactin.com/HotelApp/index.php");
        driver.manage().window().maximize();
        ExtentTest testReport = reports.startTest("Logintest");
        LoginPage.login(driver, testReport);
        reports.endTest(testReport);
        driver.quit();
    }

    @Test
    public void testGoogle() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        ExtentTest testReport = reports.startTest("Google test");
        testReport.log(LogStatus.PASS, "Verify google home", "gogle home");
        reports.endTest(testReport);
        driver.quit();
    }


    @AfterClass
    public void quit() {
        reports.flush();
        reports.close();

    }

}
