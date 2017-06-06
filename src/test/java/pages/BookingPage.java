package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import ui.Book;
import ui.Select;
import utils.InstanceContainer;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SXK8780 on 5/31/2017.
 */
@SuppressWarnings("Duplicates")
public class BookingPage {
    public String hotelName;
    public String location;
    public String roomType;
    public String noOfRooms;
    public String totalDays;
    public String pricePerNight;
    public String totalPrice;
    public String gst;
    public String finalBilledPrice;
    public String firstNameField;
    public String lastNameField;
    public String addressField;
    public String creditCardNoField;
    public String creditCardTypeField;
    public String creditCardExpiryMonthField;
    public String creditCardExpiryYearField;
    public String creditCardCvvField;

    public BookingPage(InstanceContainer ic){
        this.hotelName = ic.element.getText(Book.hotelName);
        this.location = ic.element.getText(Book.location);
        this.roomType = ic.element.getText(Book.roomType);
        this.noOfRooms = ic.element.getText(Book.noOfRooms);
        this.totalDays = ic.element.getText(Book.totalDays);
        this.pricePerNight = ic.element.getText(Book.pricePerNight);
        this.totalPrice = ic.element.getText(Book.totalPrice);
        this.gst = ic.element.getText(Book.gst);
        this.finalBilledPrice = ic.element.getText(Book.finalBilledPrice);
        this.firstNameField = ic.element.getText(Book.firstNameField);
        this.lastNameField = ic.element.getText(Book.lastNameField);
        this.addressField = ic.element.getText(Book.addressField);
        this.creditCardNoField = ic.element.getText(Book.creditCardNoField);
        this.creditCardTypeField = ic.element.getSelectedText(Book.creditCardTypeField);
        this.creditCardExpiryMonthField = ic.element.getSelectedText(Book.creditCardExpiryMonthField);
        this.creditCardExpiryYearField = ic.element.getSelectedText(Book.creditCardExpiryYearField);
        this.creditCardCvvField = ic.element.getText(Book.creditCardCvvField);
    }

    public static BookingPage validateAllFieldsMatchSelectedRecord(InstanceContainer ic, boolean stopTestOnFailure,SelectPage selectPage) {
        BookingPage bookingPage = new BookingPage(ic);
        boolean isFailurePresent = false;
        if (selectPage.selectedHotelName.equalsIgnoreCase(bookingPage.hotelName)){
            ic.element.logStep(LogStatus.PASS, "Expected HotelName : "+selectPage.selectedHotelName, "Actual : " +bookingPage.hotelName);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected HotelName : "+selectPage.selectedHotelName, "Actual : " +bookingPage.hotelName);
            isFailurePresent=true;
        }
        if (selectPage.selectedLocation.equalsIgnoreCase(bookingPage.location)){
            ic.element.logStep(LogStatus.PASS, "Expected Location : "+selectPage.selectedLocation, "Actual : " +bookingPage.location);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected Location : "+selectPage.selectedLocation, "Actual : " +bookingPage.location);
            isFailurePresent=true;
        }
        if (selectPage.selectedRoomType.equalsIgnoreCase(bookingPage.roomType)){
            ic.element.logStep(LogStatus.PASS, "Expected RoomType : "+selectPage.selectedRoomType, "Actual : " +bookingPage.roomType);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected RoomType : "+selectPage.selectedRoomType, "Actual : " +bookingPage.roomType);
            isFailurePresent=true;
        }
        if (selectPage.selectedRoom.substring(0,selectPage.selectedRoom.indexOf(" ")).equalsIgnoreCase(bookingPage.noOfRooms.substring(0,bookingPage.noOfRooms.indexOf(" ")))){
            ic.element.logStep(LogStatus.PASS, "Expected NoOfRooms : "+selectPage.selectedRoom, "Actual : " +bookingPage.noOfRooms);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected NoOfRooms : "+selectPage.selectedRoom, "Actual : " +bookingPage.noOfRooms);
            isFailurePresent=true;
        }
        if (selectPage.selectedNoDay.substring(0,selectPage.selectedNoDay.indexOf(" ")).equalsIgnoreCase(bookingPage.totalDays.substring(0,bookingPage.totalDays.indexOf(" ")))){
            ic.element.logStep(LogStatus.PASS, "Expected NoOfDays : "+selectPage.selectedNoDay, "Actual : " +bookingPage.totalDays);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected NoOfDays : "+selectPage.selectedNoDay, "Actual : " +bookingPage.totalDays);
            isFailurePresent=true;
        }
        if (selectPage.selectedPricePerNight.equalsIgnoreCase(bookingPage.pricePerNight)){
            ic.element.logStep(LogStatus.PASS, "Expected PricePerNight : "+selectPage.selectedPricePerNight, "Actual : " +bookingPage.pricePerNight);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected PricePerNight : "+selectPage.selectedPricePerNight, "Actual : " +bookingPage.pricePerNight);
            isFailurePresent=true;
        }
        if (selectPage.selectedTotalPrice.equalsIgnoreCase(bookingPage.totalPrice)){
            ic.element.logStep(LogStatus.PASS, "Expected TotalPrice : "+selectPage.selectedTotalPrice, "Actual : " +bookingPage.totalPrice);
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL,"Expected TotalPrice : "+selectPage.selectedTotalPrice, "Actual : " +bookingPage.totalPrice);
            isFailurePresent=true;
        }
        if (isFailurePresent) {
            ic.driver.quit();
            ic.reports.endTest(ic.testReport);
        }
        return bookingPage;
    }

    public static void validateTotalPrice(InstanceContainer ic, boolean stopTestOnFailure) {
        String totalPrice = ic.element.getText(Book.totalPrice);
        float totalPriceInFloat = Float.parseFloat(totalPrice.substring(totalPrice.indexOf("$ ")+2));
        String pricePerNight = ic.element.getText(Book.pricePerNight);
        int pricePerNightInInt = Integer.parseInt(pricePerNight.substring(pricePerNight.indexOf("$ ")+2));
        String noOfRooms = ic.element.getText(Book.noOfRooms);
        int noOfRoomsInInt = Integer.parseInt(noOfRooms.substring(0,noOfRooms.indexOf(" ")));
        String noOfDays = ic.element.getText(Book.totalDays);
        int noOfDaysInInt = Integer.parseInt(noOfDays.substring(0,noOfDays.indexOf(" ")));
        float expectedTotalPrice = pricePerNightInInt*noOfRoomsInInt*noOfDaysInInt;
        ic.element.logStep(LogStatus.INFO, "Expected / Actual Total Price :", expectedTotalPrice +" / "+ totalPriceInFloat);
            if (expectedTotalPrice==totalPriceInFloat){
                ic.element.logStep(LogStatus.PASS, "Total Price = price-per-night*noof-rooms*no-of-days", "TRUE");
            }
            else {
                ic.element.logStepWithScreenShot(LogStatus.FAIL, "Total Price = price-per-night*noof-rooms*no-of-days", "FALSE");
                if (stopTestOnFailure) {
                    ic.driver.quit();
                    ic.reports.endTest(ic.testReport);
                }
            }
    }
    public static BookingPage bookHotel(InstanceContainer ic) {
    ic.element.enterText(Book.firstNameField,"Test");
    ic.element.enterText(Book.lastNameField,"Customer");
    ic.element.enterText(Book.addressField,"1234 Smyrna,GA, 30189");
    ic.element.enterText(Book.creditCardNoField,"1111111111111111");
    ic.element.selectTextByValue(Book.creditCardTypeField,"VISA");
    ic.element.selectTextByValue(Book.creditCardExpiryMonthField,"12");
    ic.element.selectTextByValue(Book.creditCardExpiryYearField, String.valueOf(Utils.getYear(1)));
    ic.element.enterText(Book.creditCardCvvField,"123");
    BookingPage obj = new BookingPage(ic);
    ic.element.click(Book.bookButton);
    return obj;
    }
    public static void validateFinalBilledPrice(InstanceContainer ic, boolean stopTestOnFailure) {
        String finalBilledPrice = ic.element.getText(Book.finalBilledPrice);
        float finalBilledPriceInFloat = Float.parseFloat(finalBilledPrice.substring(finalBilledPrice.indexOf("$ ")+2));
        String pricePerNight = ic.element.getText(Book.pricePerNight);
        int pricePerNightInInt = Integer.parseInt(pricePerNight.substring(pricePerNight.indexOf("$ ")+2));
        String noOfRooms = ic.element.getText(Book.noOfRooms);
        int noOfRoomsInInt = Integer.parseInt(noOfRooms.substring(0,noOfRooms.indexOf(" ")));
        String noOfDays = ic.element.getText(Book.totalDays);
        int noOfDaysInInt = Integer.parseInt(noOfDays.substring(0,noOfDays.indexOf(" ")));
        float expectedTotalPrice = pricePerNightInInt*noOfRoomsInInt*noOfDaysInInt;
        float gst = (expectedTotalPrice*10)/100;
        float expectedFinalBilledPrice = expectedTotalPrice+gst;
        ic.element.logStep(LogStatus.INFO, "Expected / Actual finalBilledPrice :", expectedFinalBilledPrice +" / "+ finalBilledPriceInFloat);
        if (expectedFinalBilledPrice==finalBilledPriceInFloat){
            ic.element.logStep(LogStatus.PASS, "FinalBilledPrice = (price-per-night*noof-rooms*no-of-days)+10% gst", "TRUE");
        }
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL, "FinalBilledPrice = (price-per-night*noof-rooms*no-of-days)+10% gst", "FALSE");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }
    public static void validateNextScreen(InstanceContainer ic, boolean stopTestOnFailure, By by) {
        if (ic.element.waitForElement(by))
            ic.element.logStep(LogStatus.PASS, "Verify booking operation", "booking successful");
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL, "Verify booking operation", "booking failed");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }
    }
