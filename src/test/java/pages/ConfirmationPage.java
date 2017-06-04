package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import ui.Book;
import ui.Confirmation;
import ui.Select;
import utils.InstanceContainer;
import utils.Utils;

/**
 * Created by SXK8780 on 5/31/2017.
 */
@SuppressWarnings("Duplicates")
public class ConfirmationPage {
    public String hotelName;
    public String location;
    public String arrivalDate;
    public String departureDate;
    public String roomType;
    public String noOfRooms;
    public String adultsPerRoom;
    public String childrensPerRoom;
    public String pricePerNight;
    public String totalPrice;
    public String gst;
    public String finalBilledPrice;
    public String firstNameField;
    public String lastNameField;
    public String addressField;
    public String orderNo;

    public ConfirmationPage(InstanceContainer ic){
        this.hotelName = ic.element.getText(Confirmation.hotelName);
        this.location = ic.element.getText(Confirmation.location);
        this.arrivalDate = ic.element.getText(Confirmation.arrivalDate);
        this.departureDate = ic.element.getText(Confirmation.departureDate);
        this.roomType = ic.element.getText(Confirmation.roomType);
        this.noOfRooms = ic.element.getText(Confirmation.noOfRooms);
        this.adultsPerRoom = ic.element.getText(Confirmation.adultsPerRoom);
        this.childrensPerRoom = ic.element.getText(Confirmation.childrensPerRoom);
        this.pricePerNight = ic.element.getText(Confirmation.pricePerNight);
        this.totalPrice = ic.element.getText(Confirmation.totalPrice);
        this.gst = ic.element.getText(Confirmation.gst);
        this.finalBilledPrice = ic.element.getText(Confirmation.finalBilledPrice);
        this.firstNameField = ic.element.getText(Confirmation.firstNameField);
        this.lastNameField = ic.element.getText(Confirmation.lastNameField);
        this.addressField = ic.element.getText(Confirmation.addressField);
        this.orderNo = ic.element.getText(Confirmation.orderNo);
    }

    public static ConfirmationPage validateAllFieldsMatchSelectedRecord(InstanceContainer ic, boolean stopTestOnFailure, SelectPage selectPage,BookingPage bookingPage) {
        ConfirmationPage confirmationPage = new ConfirmationPage(ic);
        BookingPage bookingPageDtls = bookingPage;
        SelectPage selectPageDtls = selectPage;
        boolean isFailurePresent = false;
        if (confirmationPage.hotelName.equalsIgnoreCase(bookingPage.hotelName)){
            ic.testReport.log(LogStatus.PASS, "Expected HotelName : "+bookingPage.hotelName, "Actual : " +confirmationPage.hotelName);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected HotelName : "+bookingPage.hotelName, "Actual : " +confirmationPage.hotelName);
            isFailurePresent=true;
        }
        if (confirmationPage.location.equalsIgnoreCase(bookingPage.location)){
            ic.testReport.log(LogStatus.PASS, "Expected Location : "+bookingPage.location, "Actual : " +confirmationPage.location);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected Location : "+bookingPage.location, "Actual : " +confirmationPage.location);
            isFailurePresent=true;
        }
        if (confirmationPage.arrivalDate.equalsIgnoreCase(selectPage.selectedArrivalDate)){
            ic.testReport.log(LogStatus.PASS, "Expected Arrival Date : "+selectPage.selectedArrivalDate, "Actual : " +confirmationPage.arrivalDate);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected Arrival Date : "+selectPage.selectedArrivalDate, "Actual : " +confirmationPage.arrivalDate);
            isFailurePresent=true;
        }
        if (confirmationPage.departureDate.equalsIgnoreCase(selectPage.selectedDepartureDate)){
            ic.testReport.log(LogStatus.PASS, "Expected Arrival Date : "+selectPage.selectedDepartureDate, "Actual : " +confirmationPage.departureDate);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected Arrival Date : "+selectPage.selectedDepartureDate, "Actual : " +confirmationPage.departureDate);
            isFailurePresent=true;
        }

        if (confirmationPage.roomType.equalsIgnoreCase(bookingPage.roomType)){
            ic.testReport.log(LogStatus.PASS, "Expected RoomType : "+bookingPage.roomType, "Actual : " +confirmationPage.roomType);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected RoomType : "+bookingPage.roomType, "Actual : " +confirmationPage.roomType);
            isFailurePresent=true;
        }
        if (confirmationPage.noOfRooms.substring(0,confirmationPage.noOfRooms.indexOf(" ")).equalsIgnoreCase(bookingPage.noOfRooms.substring(0,bookingPage.noOfRooms.indexOf(" ")))){
            ic.testReport.log(LogStatus.PASS, "Expected NoOfRooms : "+bookingPage.noOfRooms, "Actual : " +confirmationPage.noOfRooms);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected NoOfRooms : "+bookingPage.noOfRooms, "Actual : " +confirmationPage.noOfRooms);
            isFailurePresent=true;
        }

        if (confirmationPage.pricePerNight.equalsIgnoreCase(bookingPage.pricePerNight)){
            ic.testReport.log(LogStatus.PASS, "Expected PricePerNight : "+bookingPage.pricePerNight, "Actual : " +confirmationPage.pricePerNight);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected PricePerNight : "+bookingPage.pricePerNight, "Actual : " +confirmationPage.pricePerNight);
            isFailurePresent=true;
        }
        if (confirmationPage.totalPrice.equalsIgnoreCase(bookingPage.totalPrice)){
            ic.testReport.log(LogStatus.PASS, "Expected TotalPrice : "+bookingPage.totalPrice, "Actual : " +confirmationPage.totalPrice);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected TotalPrice : "+bookingPage.totalPrice, "Actual : " +confirmationPage.totalPrice);
            isFailurePresent=true;
        }
        if (confirmationPage.gst.equalsIgnoreCase(bookingPage.gst)){
            ic.testReport.log(LogStatus.PASS, "Expected gst : "+bookingPage.gst, "Actual : " +confirmationPage.gst);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected gst : "+bookingPage.gst, "Actual : " +confirmationPage.gst);
            isFailurePresent=true;
        }
        if (confirmationPage.finalBilledPrice.equalsIgnoreCase(bookingPage.finalBilledPrice)){
            ic.testReport.log(LogStatus.PASS, "Expected finalBilledPrice : "+bookingPage.finalBilledPrice, "Actual : " +confirmationPage.finalBilledPrice);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected finalBilledPrice : "+bookingPage.finalBilledPrice, "Actual : " +confirmationPage.finalBilledPrice);
            isFailurePresent=true;
        }
        if (confirmationPage.firstNameField.equalsIgnoreCase(bookingPage.firstNameField)){
            ic.testReport.log(LogStatus.PASS, "Expected firstNameField : "+bookingPage.firstNameField, "Actual : " +confirmationPage.firstNameField);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected firstNameField : "+bookingPage.firstNameField, "Actual : " +confirmationPage.firstNameField);
            isFailurePresent=true;
        }
        if (confirmationPage.lastNameField.equalsIgnoreCase(bookingPage.lastNameField)){
            ic.testReport.log(LogStatus.PASS, "Expected lastNameField : "+bookingPage.lastNameField, "Actual : " +confirmationPage.lastNameField);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected lastNameField : "+bookingPage.lastNameField, "Actual : " +confirmationPage.lastNameField);
            isFailurePresent=true;
        }
        if (confirmationPage.addressField.equalsIgnoreCase(bookingPage.addressField)){
            ic.testReport.log(LogStatus.PASS, "Expected addressField : "+bookingPage.addressField, "Actual : " +confirmationPage.addressField);
        }
        else {
            ic.testReport.log(LogStatus.FAIL,"Expected addressField : "+bookingPage.addressField, "Actual : " +confirmationPage.addressField);
            isFailurePresent=true;
        }
        if (isFailurePresent) {
            ic.driver.quit();
            ic.reports.endTest(ic.testReport);
        }
        return confirmationPage;
    }

    public static ConfirmationPage validateOrderNo(InstanceContainer ic, boolean stopTestOnFailure) {
        ConfirmationPage confirmationPage = new ConfirmationPage(ic);
        boolean isFailurePresent = false;
        if (confirmationPage.orderNo!=null && !confirmationPage.orderNo.isEmpty()){
            ic.testReport.log(LogStatus.PASS, "Orrder Nbr Generation Check ", confirmationPage.orderNo);
        }
        else {
            ic.testReport.log(LogStatus.FAIL, "Orrder Nbr Generation Check ", confirmationPage.orderNo);
            isFailurePresent=true;
        }
        if (isFailurePresent) {
            ic.driver.quit();
            ic.reports.endTest(ic.testReport);
        }
        return confirmationPage;
    }
    public static void validateNextScreen(InstanceContainer ic, boolean stopTestOnFailure, By by) {
        if (ic.element.waitForElement(by))
            ic.testReport.log(LogStatus.PASS, "Verify booking operation", "booking successful");
        else {
            ic.testReport.log(LogStatus.FAIL, "Verify booking operation", "booking failed");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }
    public static void validatePageEditable(InstanceContainer ic, boolean stopTestOnFailure) {
        if (ic.element.isNotEditable(Confirmation.hotelName) && ic.element.isNotEditable(Confirmation.location) && ic.element.isNotEditable(Confirmation.roomType) && ic.element.isNotEditable(Confirmation.arrivalDate) && ic.element.isNotEditable(Confirmation.departureDate) && ic.element.isNotEditable(Confirmation.noOfRooms) && ic.element.isNotEditable(Confirmation.adultsPerRoom) && ic.element.isNotEditable(Confirmation.childrensPerRoom) && ic.element.isNotEditable(Confirmation.pricePerNight) && ic.element.isNotEditable(Confirmation.totalPrice) && ic.element.isNotEditable(Confirmation.gst) && ic.element.isNotEditable(Confirmation.finalBilledPrice) && ic.element.isNotEditable(Confirmation.firstNameField) && ic.element.isNotEditable(Confirmation.lastNameField) && ic.element.isNotEditable(Confirmation.addressField) && ic.element.isNotEditable(Confirmation.orderNo))
            ic.testReport.log(LogStatus.PASS, "Fields Editable ?", "Non-Editable");
        else {
            ic.testReport.log(LogStatus.FAIL, "Fields Editable ?", "Editable");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }
    }
