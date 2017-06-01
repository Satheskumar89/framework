package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

/**
 * Created by SXK8780 on 6/1/2017.
 */
public class InstanceContainer {
    public Element element;
    public WebDriver driver;
    public ExtentTest testReport;
    public ExtentReports reports;

    public InstanceContainer(Element element, WebDriver driver, ExtentReports reports,ExtentTest testReport){
        this.driver = driver;
        this.element = element;
        this.testReport = testReport;
        this.reports = reports;
    }
}
