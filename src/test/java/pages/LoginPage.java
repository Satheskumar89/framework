package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import ui.Login;
import ui.Search;
import utils.Element;
import utils.InstanceContainer;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class LoginPage {
    public static void login(InstanceContainer ic) {
        ic.element.enterText(Login.userNameField,"home1234");
        ic.element.enterText(Login.passwordField,"root1234");
        ic.element.click(Login.loginButton);
        if(ic.element.waitForElement(Search.displayUserName))
            ic.testReport.log(LogStatus.PASS, "Verify login", "logged in successfully");
        else
            ic.testReport.log(LogStatus.FAIL, "Verify login", "log in failed");
    }


}
