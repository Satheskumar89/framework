package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import ui.Login;
import ui.Search;
import utils.InstanceContainer;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class LoginPage {
    public static void login(InstanceContainer ic, String userNameField, String passwordField) {
        ic.element.enterText(Login.userNameField, userNameField);
        ic.element.enterText(Login.passwordField, passwordField);
        ic.element.click(Login.loginButton);
    }

    public static void validateNextScreen(InstanceContainer ic, boolean stopTestOnFailure,By by) {
        if (ic.element.waitForElement(Search.displayUserName) && ic.element.waitForElement(by))
            ic.element.logStep(LogStatus.PASS, "Verify login operation", "logged in successfully"+by);
        else {
            ic.element.logStepWithScreenShot(LogStatus.FAIL, "Verify login operation", "log in failed");
            if (stopTestOnFailure) {
                ic.driver.quit();
                ic.reports.endTest(ic.testReport);
            }
        }
    }

}
