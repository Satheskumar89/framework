package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import ui.Login;
import ui.Logout;
import ui.Search;
import utils.InstanceContainer;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class LogoutPage {
    public static void logout(InstanceContainer ic) {
        ic.element.click(Logout.logOutLink);
    }

    public static void validateNextScreen(InstanceContainer ic, boolean stopTestOnFailure,By by) {
        if (ic.element.waitForElement(by))
            ic.testReport.log(LogStatus.PASS, "Verify logout operation", "Logged out successfully"+by);
        else {
            ic.testReport.log(LogStatus.FAIL, "Verify logout operation", "log out failed");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }

}
