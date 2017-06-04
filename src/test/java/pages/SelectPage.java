package pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ui.Search;
import ui.Select;
import utils.Element;
import utils.InstanceContainer;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SXK8780 on 5/31/2017.
 */
@SuppressWarnings("Duplicates")
public class SelectPage {
    public String selectedHotelName;
    public String selectedLocation;
    public String selectedRoom;
    public String selectedArrivalDate;
    public String selectedDepartureDate;
    public String selectedNoDay;
    public String selectedRoomType;
    public String selectedPricePerNight;
    public String selectedTotalPrice;

    public SelectPage(InstanceContainer ic) {
        this.selectedHotelName = ic.element.getText(Select.selectedHotelName);
        this.selectedLocation = ic.element.getText(Select.selectedLocation);
        this.selectedRoom = ic.element.getText(Select.selectedRoom);
        this.selectedArrivalDate = ic.element.getText(Select.selectedArrivalDate);
        this.selectedDepartureDate = ic.element.getText(Select.selectedDepartureDate);
        this.selectedNoDay = ic.element.getText(Select.selectedNoDay);
        this.selectedRoomType = ic.element.getText(Select.selectedRoomType);
        this.selectedPricePerNight = ic.element.getText(Select.selectedPricePerNight);
        this.selectedTotalPrice = ic.element.getText(Select.selectedTotalPrice);
    }

    public static List<String> getColumnValues(InstanceContainer ic, By by,String columName) {
        List<String> values = new ArrayList<>();
        try {
        WebElement mytable = ic.driver.findElement(by);
        List<WebElement> rows = mytable.findElements(By.tagName("tr"));
        int noOfRows = rows.size();
        if (noOfRows<=1) {
            ic.testReport.log(LogStatus.WARNING, "NoOfRows Retrieved","No Rows Retrieved");
            return values;
        }
        else {
            ic.testReport.log(LogStatus.INFO, "NoOfRows Retrieved", String.valueOf(noOfRows-1));
        }

        WebElement columnPosition = rows.get(0).findElement(By.xpath("*[. = '"+columName+"']"));
        List<WebElement> columnNames = rows.get(0).findElements(By.tagName("td"));
        int columnIndex = columnNames.indexOf(columnPosition);

        for (int row = 1; row < noOfRows; row++) {
            List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
            values.add(columns.get(columnIndex).findElement(By.tagName("input")).getAttribute("value"));
            }
        return values;
        }
        catch(Exception e) {
            return values;
        }
    }

        public static void validateColumn(InstanceContainer ic, boolean stopTestOnFailure, List<String> columnValues, String expectedValue) {
        List<String> values = columnValues;
        Boolean isFailurePresent = false;
            for (String temp : values) {
                if (temp.equalsIgnoreCase(expectedValue));
                else {
                    ic.testReport.log(LogStatus.FAIL, "Check columnValues matching "+ expectedValue, "Not Matching");
                    isFailurePresent = true;
                    if (stopTestOnFailure) {
                        ic.driver.quit();
                        ic.reports.endTest(ic.testReport);
                    }
                }
            }
            if(!isFailurePresent) ic.testReport.log(LogStatus.PASS, "Check columnValues matching '"+ expectedValue+"'", "Matching");
        }
        public static SelectPage selectFirstHotel(InstanceContainer ic, boolean stopTestOnFailure) {
            SelectPage obj = new SelectPage(ic);;
        if (ic.element.click(Select.firstRow) && ic.element.click(Select.continueButton)) {
            ic.testReport.log(LogStatus.PASS, "Select First Row","Row selected");
            return obj;
        }
        else {
            ic.testReport.log(LogStatus.FAIL, "Select First Row ", "Unable to select first row");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
            return obj;
        }
        }

    public static void validateNextScreen(InstanceContainer ic, boolean stopTestOnFailure, By by) {
        if (ic.element.waitForElement(by))
            ic.testReport.log(LogStatus.PASS, "Verify select operation", "Select successful");
        else {
            ic.testReport.log(LogStatus.FAIL, "Verify select operation", "Select failed");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }

    }
