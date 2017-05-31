package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import ui.Login;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class LoginPage {

    public static void login(WebDriver driver, ExtentTest testReport) {
        driver.findElement(Login.userNameField).clear();
        driver.findElement(Login.userNameField).sendKeys("home1234");
        driver.findElement(Login.passwordField).clear();
        driver.findElement(Login.passwordField).sendKeys("root1234");
        driver.findElement(Login.loginButton).click();
        testReport.log(LogStatus.PASS, "Verify login", "logged in successfully");
    }


}
