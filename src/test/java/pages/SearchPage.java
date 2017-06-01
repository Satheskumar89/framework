package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ui.Login;
import ui.Search;
import utils.Element;
import utils.InstanceContainer;
import utils.Utils;

/**
 * Created by SXK8780 on 5/31/2017.
 */
@SuppressWarnings("Duplicates")
public class SearchPage {

    public static void validateCheckInDateLaterThanCheckOutDate(InstanceContainer ic) {
        ic.element.click(Search.resetButton);
        ic.element.selectTextByValue(Search.locationField, "Sydney");
        ic.element.selectTextByValue(Search.hotelsField, "Hotel Creek");
        ic.element.selectTextByValue(Search.roomTypeField, "Standard");
        ic.element.selectTextByValue(Search.noOfRoomsField, "1");
        ic.element.enterText(Search.checkInDateField, Utils.getDay(7));
        ic.element.enterText(Search.checkOutDateField, Utils.getDay(5));
        ic.element.click(Search.submitButton);
        if (ic.element.waitForElement(Search.checkInDateError) && ic.element.waitForElement(Search.checkOutDateError))
            ic.testReport.log(LogStatus.PASS, "Verify Check-in date accepted after Check-out date", "Not accepting");
        else {
            ic.testReport.log(LogStatus.FAIL, "Verify Check-in date accepted after Check-out date", "Accepting");
            ic.driver.quit();
            ic.reports.endTest(ic.testReport);
        }
    }

    public static void validatePastCheckOutDate(InstanceContainer ic) {
        ic.element.click(Search.resetButton);
        ic.element.selectTextByValue(Search.locationField, "Sydney");
        ic.element.selectTextByValue(Search.hotelsField, "Hotel Creek");
        ic.element.selectTextByValue(Search.roomTypeField, "Standard");
        ic.element.selectTextByValue(Search.noOfRoomsField, "1");
        ic.element.enterText(Search.checkInDateField, Utils.getDay(-5));
        ic.element.enterText(Search.checkOutDateField, Utils.getDay(-3));
        ic.element.click(Search.submitButton);
        if (ic.element.getText(Search.checkInDateError).equalsIgnoreCase("Check-In Date should be either Today or " +
                "Later Date"))
            ic.testReport.log(LogStatus.PASS, "Verify past date is not accepted in Check-in field", "Not accepting");
        else {
            ic.testReport.log(LogStatus.FAIL, "Verify past date is not accepted in Check-in field", "Accepting");
            ic.driver.quit();
            ic.reports.endTest(ic.testReport);
        }

    }

}
