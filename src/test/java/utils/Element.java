package utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by SXK8780 on 6/1/2017.
 */
public class Element {
    WebDriver driver;
    ExtentTest testReporter;

    public Element(WebDriver driver, ExtentTest testReporter) {
        this.driver = driver;
        this.testReporter = testReporter;
    }

    /***************************************************************************************************************
     *********************************************BUTTON************************************************************
     ***************************************************************************************************************/

    public boolean click(By by) {
        if (waitForElement(by)) {
            driver.findElement(by).click();
            return true;
        }
        return false;
    }
    /***************************************************************************************************************
     **********************************************TEXT*************************************************************
     ***************************************************************************************************************/

    public boolean enterText(By by, String text) {
        if (waitForElement(by)) {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys(text);
            return true;
        }
        return false;
    }

    public boolean enterKeys(By by, Keys key) {
        if (waitForElement(by)) {
            driver.findElement(by).sendKeys(key);
            return true;
        }
        return false;
    }

    public boolean clear(By by) {
        if (waitForElement(by)) {
            driver.findElement(by).clear();
            return true;
        }
        return false;
    }

    /***************************************************************************************************************
     **********************************************DROP DOWN********************************************************
     ***************************************************************************************************************/
    public boolean selectByText(By by, String text) {
        if (waitForElement(by)) {
            new Select(driver.findElement(by)).selectByVisibleText(text);
            return true;
        }
        return false;
    }

    public boolean selectTextByIndex(By by, int index) {
        if (waitForElement(by)) {
            new Select(driver.findElement(by)).selectByIndex(index);
            return true;
        }
        return false;
    }
    public String getSelectedText(By by) {
        if (waitForElement(by)) {
            return new Select(driver.findElement(by)).getFirstSelectedOption().getText();
        }
        return null;
    }

    public boolean selectTextByValue(By by, String value) {
        try {
            if (waitForElement(by)) {
                new Select(driver.findElement(by)).selectByValue(value);
                return true;
            }
            return false;
        } catch (Exception e) {
            testReporter.log(LogStatus.WARNING, by.toString(), "Value '"+value+"' not available");
            return false;
        }
    }

    public List<String> getAllOptions(By by) {
        List<WebElement> options = new ArrayList<>();
        List<String> values = new ArrayList<>();
        if (waitForElement(by)) {
            Select select = new Select(driver.findElement(by));
            options = select.getOptions();
            for (WebElement element : options)
                values.add(element.getText());
            return values;
        }
        return values;
    }

    public boolean isOptionPresent(By by, String option) {
        List<WebElement> options = new ArrayList<>();
        if (waitForElement(by)) {
            Select select = new Select(driver.findElement(by));
            options = select.getOptions();
            for (WebElement element : options) {
                if (element.getText().equals(option))
                    return true;
            }
        }
        return false;
    }

    public boolean isOptionPresentIgnoreCase(By by, String option) {
        List<WebElement> options = new ArrayList<>();
        if (waitForElement(by)) {
            Select select = new Select(driver.findElement(by));
            options = select.getOptions();
            for (WebElement element : options) {
                if (element.getText().equalsIgnoreCase(option))
                    return true;
            }
        }
        return false;
    }


    /***************************************************************************************************************
     **********************************************ALERTS******************************************************
     ***************************************************************************************************************/

    public boolean acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean cancelAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getAlertText() {
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();

        } catch (Exception e) {
            return "";
        }
    }

    public boolean sendTextToAlert(String text) {
        try {
            Alert alert = driver.switchTo().alert();
            alert.sendKeys(text);
            alert.accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /***************************************************************************************************************
     **********************************************ACTIONS********************************************************
     ***************************************************************************************************************/
    public boolean mouseOver(By by) {
        if (waitForElement(by)) {
            new Actions(driver).moveToElement(driver.findElement(by)).build().perform();
            return true;
        }
        return false;
    }

    public boolean doubleClick(By by) {
        if (waitForElement(by)) {
            new Actions(driver).doubleClick(driver.findElement(by)).build().perform();
            return true;
        }
        return false;
    }

    public boolean clickAndHold(By by) {
        if (waitForElement(by)) {
            new Actions(driver).clickAndHold(driver.findElement(by)).build().perform();
            return true;
        }
        return false;
    }

    public boolean dragAndDrop(By src, By dest) {
        if (waitForElement(src) && waitForElement(dest)) {
            new Actions(driver).dragAndDrop(driver.findElement(src), driver.findElement(dest)).build().perform();
            return true;
        }
        return false;
    }


    /***************************************************************************************************************
     **********************************************PAGE LEVEl********************************************************
     ***************************************************************************************************************/


    /***************************************************************************************************************
     **********************************************COMMON********************************************************
     ***************************************************************************************************************/
    //TODO : Check getText for all UI elements like button, textbox, etc -- It may not work as expected
    public String getText(By by) {
        if (waitForElement(by)) {
            String text = driver.findElement(by).getText();
            if (text == null || text.equalsIgnoreCase(""))
                text = driver.findElement(by).getAttribute("value");
            return text;
        }
        return "";
    }

    public boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException er) {
            return false;
        }
    }
    public boolean isNotEditable(By by) {
        if (waitForElement(by)) {
            if(!driver.findElement(by).isEnabled()) return true;
            else {
                testReporter.log(LogStatus.WARNING, by.toString(), "Editable");
            }
        }
        return false;
    }
    public boolean isEditable(By by) {
        if (waitForElement(by)) {
            if(driver.findElement(by).isEnabled()) return true;
            else {
                testReporter.log(LogStatus.WARNING, by.toString(), "Not-Editable");
            }
        }
        return false;
    }

    public boolean containsText(By by, String searchText) {
        if (waitForElement(by)) {
            String text = driver.findElement(by).getText();
            if (text == null || text.equalsIgnoreCase(""))
                text = driver.findElement(by).getAttribute("value");
            return text.contains(searchText);
        }
        return false;
    }

    public boolean waitForElement(By by) {
        boolean isElementPresent = false;
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(5, SECONDS)
                    .pollingEvery(50, TimeUnit.MILLISECONDS)
                    .ignoring(WebDriverException.class, java.util.NoSuchElementException.class);
            wait.until(driver -> driver.findElement(by));
        } catch (Exception e) {
            testReporter.log(LogStatus.WARNING, by.toString(), "Not available");
            return false;
        }
        return true;
    }

    public boolean wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void logStep(LogStatus status, String expected, String actual) {
        testReporter.log(status, expected, actual);
    }

    public void logStepWithScreenShot(LogStatus status, String expected, String actual) {
        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        try {
            File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(image, new File("./reports/images/" + number + ".jpg"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
        testReporter.log(status, expected, actual + testReporter.addScreenCapture("./images/" + number + ".jpg"));
    }

}
