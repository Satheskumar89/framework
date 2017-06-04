package tests;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;
import ui.*;
import utils.Element;
import utils.InstanceContainer;
import utils.Utils;

import java.util.List;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class TestAdactin {

    @Test(priority = 1)
    public void testLoginCredentials() {
        InstanceContainer ic = setTestInstance("Verify valid login details");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test(priority = 2)
    public void testCheckInDateInSearch() {
        InstanceContainer ic = setTestInstance("Verify checkOutDate not accepted later than checkInDate");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "1", 7, 5, "", "");
        SearchPage.validateCheckInDateLaterThanCheckOutDate(ic, true);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test(priority = 3)
    public void testCheckOutDateInSearch() {
        InstanceContainer ic = setTestInstance("Verify past date is not accepted in CheckOutDate");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "1", -5, -3, "", "");
        SearchPage.validatePastCheckOutDate(ic, true);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test(priority = 4)
    public void testLocationInSelect() {
        InstanceContainer ic = setTestInstance("Verify location entered & displayed in search and selectPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "1", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        List <String> locationList= SelectPage.getColumnValues(ic,Select.selectTable,"Location");
        SelectPage.validateColumn(ic,true,locationList,"Sydney");
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test(priority = 5)
    public void testDatesInSelect() {
        InstanceContainer ic = setTestInstance("Verify checkIn/Out date entered & displayed in search and selectPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "1", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        List <String> arrivalDateList= SelectPage.getColumnValues(ic,Select.selectTable,"Arrival Date ");
        SelectPage.validateColumn(ic,false,arrivalDateList, Utils.getDay(0));
        List <String> departureDateList= SelectPage.getColumnValues(ic,Select.selectTable,"Departure Date ");
        SelectPage.validateColumn(ic,true,departureDateList, Utils.getDay(1));
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 6)
    public void testNoOfRoomsInSelect() {
        InstanceContainer ic = setTestInstance("Verify noOfRooms entered & displayed in search and selectPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "1", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        List <String> noOfRoomsList= SelectPage.getColumnValues(ic,Select.selectTable,"Rooms");
        SelectPage.validateColumn(ic,true,noOfRoomsList, "1 Rooms");
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 7)
    public void testRoomTypeInSelect() {
        InstanceContainer ic = setTestInstance("Verify RoomType entered & displayed in search and selectPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Deluxe", "1", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        List <String> roomTypeList= SelectPage.getColumnValues(ic,Select.selectTable,"Rooms Type ");
        SelectPage.validateColumn(ic,true,roomTypeList, "Deluxe");
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 8)
    public void testTotalPriceInBooking() {
        InstanceContainer ic = setTestInstance("Verify Total Price in bookHotelPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage.validateTotalPrice(ic,true);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 9)
    public void testLogout() {
        InstanceContainer ic = setTestInstance("Verify Logout operation in bookHotelPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        LogoutPage.logout(ic);
        LogoutPage.validateNextScreen(ic,true, Logout.loggedOutMessage);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }

    @Test(priority = 10)
    public void testFinalBilledPriceInBooking() {
        InstanceContainer ic = setTestInstance("Verify finalBilledPrice in bookHotelPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage.validateFinalBilledPrice(ic,true);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 11)
    public void testSelectedRecordMatchesBooking() {
        InstanceContainer ic = setTestInstance("Verify selected record matches with booking page");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage selectedRecord  = SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage.validateAllFieldsMatchSelectedRecord(ic,true,selectedRecord);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 12)
    public void testBooking() {
        InstanceContainer ic = setTestInstance("Verify bookButton in booking page");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage selectedRecord  = SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage bookingDetails = BookingPage.bookHotel(ic);
        BookingPage.validateNextScreen(ic, false,Confirmation.formName);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 13)
    public void testBookingMatchesConfirmation() {
        InstanceContainer ic = setTestInstance("Verify records displayed in confirmation matches booking");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage selectedRecord  = SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage bookingDetails = BookingPage.bookHotel(ic);
        BookingPage.validateNextScreen(ic, false,Confirmation.formName);
        ConfirmationPage.validateAllFieldsMatchSelectedRecord(ic,true,selectedRecord, bookingDetails);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 14)
    public void testOrderNoInConfirmation() {
        InstanceContainer ic = setTestInstance("Verify orderNo generation in confirmationPage");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage selectedRecord  = SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage bookingDetails = BookingPage.bookHotel(ic);
        BookingPage.validateNextScreen(ic, false,Confirmation.formName);
        ConfirmationPage.validateOrderNo(ic,true);
        reports.endTest(ic.testReport);
        ic.driver.quit();
    }
    @Test(priority = 15)
    public void testItinerarynotEditableInConfirmation() {
        InstanceContainer ic = setTestInstance("Verify itinerary non-editable in confirmationPage.");
        LoginPage.login(ic, "home1234", "root1234");
        LoginPage.validateNextScreen(ic, true, Search.formName);
        SearchPage.searchPage(ic, "Sydney", "Hotel Creek", "Standard", "2", 0, 1, "1", "");
        SearchPage.validateNextScreen(ic, true, Select.formName);
        SelectPage.selectFirstHotel(ic,true);
        SelectPage.validateNextScreen(ic, true, Book.formName);
        BookingPage.bookHotel(ic);
        BookingPage.validateNextScreen(ic, false,Confirmation.formName);
        ConfirmationPage.validatePageEditable(ic,true);
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

    public InstanceContainer setTestInstance(String caller) {
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
