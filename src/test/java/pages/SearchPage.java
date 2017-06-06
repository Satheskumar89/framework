package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import ui.Search;
import utils.InstanceContainer;
import utils.Utils;

/**
 * Created by SXK8780 on 5/31/2017.
 */
@SuppressWarnings("Duplicates")
public class SearchPage {

    public static void validateCheckInDateLaterThanCheckOutDate(InstanceContainer ic, boolean stopTestOnFailure) {
        if (ic.element.waitForElement(Search.checkInDateError) && ic.element.waitForElement(Search.checkOutDateError))
            ic.element.logStep(LogStatus.PASS, "Verify Check-in date accepted after Check-out date", "Not accepting");
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL, "Verify Check-in date accepted after Check-out date", "Accepting");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }

    public static void validatePastCheckOutDate(InstanceContainer ic, boolean stopTestOnFailure) {
        if (ic.element.getText(Search.checkInDateError).equalsIgnoreCase("Check-In Date should be either Today or " +
                "Later Date"))
            ic.element.logStep(LogStatus.PASS, "Verify past date is not accepted in Check-in field", "Not accepting");
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL, "Verify past date is not accepted in Check-in field", "Accepting");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }

    }

    public static void searchPage(InstanceContainer ic, String locationField, String hotelsField, String
            roomTypeField, String noOfRoomsField, int checkInDateField, int checkOutDateField, String
            adultsPerRoomField, String childrenPerRoomField) {
        ic.element.click(Search.resetButton);
        if (locationField != "") ic.element.selectTextByValue(Search.locationField, locationField);
        if (hotelsField != "") ic.element.selectTextByValue(Search.hotelsField, hotelsField);
        if (roomTypeField != "") ic.element.selectTextByValue(Search.roomTypeField, roomTypeField);
        if (noOfRoomsField != "") ic.element.selectTextByValue(Search.noOfRoomsField, noOfRoomsField);
        if (ic.element.isInt(String.valueOf(checkInDateField)))
            ic.element.enterText(Search.checkInDateField, Utils.getDay(checkInDateField));
        if (ic.element.isInt(String.valueOf(checkOutDateField)))
            ic.element.enterText(Search.checkOutDateField, Utils.getDay(checkOutDateField));
        if (adultsPerRoomField != "") ic.element.selectTextByValue(Search.adultsPerRoomField, adultsPerRoomField);
        if (childrenPerRoomField != "") ic.element.selectTextByValue(Search.childrenPerRoomField, childrenPerRoomField);
        ic.element.click(Search.submitButton);
    }

    public static void validateNextScreen(InstanceContainer ic, boolean stopTestOnFailure, By by) {
        if (ic.element.waitForElement(by))
            ic.element.logStep(LogStatus.PASS, "Verify search operation", "Search successful");
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL, "Verify search operation", "Search failed");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }
}
