package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SearchPage;
import utils.Element;
import utils.InstanceContainer;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class TestAdactin {

    @Test
    public void testLogin() {
        InstanceContainer ic = setTestInstance("To verify valid login details");
        LoginPage.login(ic);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test
    public void testCheckIn() {
        InstanceContainer ic = setTestInstance("To verify whether the check-out date field accepts a later date than check-in date");
        LoginPage.login(ic);
        SearchPage.validateCheckInDateLaterThanCheckOutDate(ic);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test
    public void testCheckOut() {
        InstanceContainer ic = setTestInstance("To check if error is reported if check-out date field is in the past");
        LoginPage.login(ic);
        SearchPage.validatePastCheckOutDate(ic);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @BeforeClass
    public void setup() {
        reports = new ExtentReports("./reports/result.html", true);
    }

    @AfterClass
    public void quit() {
        reports.flush();
        reports.close();

    }

    public InstanceContainer setTestInstance(String caller){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        ExtentTest testReport = reports.startTest(caller);
        WebDriver driver = new ChromeDriver();
        Element element = new Element(driver, testReport);
        InstanceContainer ic = new InstanceContainer(element, driver, reports, testReport);
        driver.get("http://adactin.com/HotelApp/index.php");
        driver.manage().window().maximize();
        return ic;
    }
    ExtentReports reports;
}
