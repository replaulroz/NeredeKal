package common;

import dev.failsafe.internal.util.Assert;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Configuration;
import utilities.Driver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Action {
    public static final Logger LOGGER = Logger.getLogger(String.valueOf(Action.class));


    public static WebDriver webDriver;
    Driver driver = new Driver();
    Actions actions;

    public void initializeTest() throws MalformedURLException {driver.startDriver();
    }

    public void tearDownTest() {
        driver.quitDriver();
    }

    public void staticWait(int waitInMSeconds) {
        try {
            Thread.sleep(waitInMSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void click(By by, String log) {
        try {
            Assert.isTrue(isElementPresent(by), log);
            webDriver.findElement(by).click();
            LOGGER.info("Clicked on element: " + by);
        } catch (AssertionError e) {
        }
    }

    public void clickByText(String text, String log) {
        try {
            Assert.isTrue(isElementPresentByText(text),log);
            webDriver.findElement(By.xpath("//*[text()='"+ text +"']")).click();
        } catch (AssertionError e) {
        }
    }


    public boolean isElementPresent(By by){
        try {
            LOGGER.info("Checking is element present");
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(Integer.parseInt(Configuration.getProperty("timeout"))));
            webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException var4) {
            return false;
        }
    }

    public boolean isElementPresentByText(String text){
        try {
            LOGGER.info("Checking is element present");
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(Integer.parseInt(Configuration.getProperty("timeout"))));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+ text +"']")));
            webDriver.findElement(By.xpath("//*[text()='"+ text +"']"));
            return true;
        } catch (NoSuchElementException var4) {
            return false;
        }
    }

    public void hover(By by, String log){
        WebElement element = webDriver.findElement(by);
        actions = new Actions(webDriver);
        try {
            Assert.isTrue(isElementPresent(by), log);
            actions.moveToElement(element).perform();
            LOGGER.info("Clicked on element: " + by);
        } catch (AssertionError e) {
        }
    }


    public void hoverByText(String text, String log){
        WebElement element = webDriver.findElement(By.xpath("//*[text()='"+ text +"']"));
        actions = new Actions(webDriver);
        try {
            Assert.isTrue(isElementPresentByText(text), log);
            actions.moveToElement(element).perform();
            LOGGER.info("Clicked on element: " + text);
        } catch (AssertionError e) {
        }
    }

    public void scrollJs(By by){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(by));
    }

    public void scrollJsByText(String text){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(By.xpath("//*[text()='"+ text +"']")));
    }


    public void enter(By textbox,String value, String log) {
        try {
            Assert.isTrue(isElementPresent(textbox),log);
            webDriver.findElement(textbox).clear();
            webDriver.findElement(textbox).sendKeys(value);
        } catch (AssertionError e) {
        }
    }

    public void enterByText(String textbox, String value, String log) {
        try {
            Assert.isTrue(isElementPresentByText(textbox),log);
            webDriver.findElement(By.xpath("//div[text()='"+ textbox +"']/../input")).clear();
            webDriver.findElement(By.xpath("//div[text()='"+ textbox +"']/../input")).sendKeys(value);
        } catch (AssertionError e) {
        }
    }

    public void confirmTheSubtitle(String text) {
        By by = By.xpath("//h1[text()='"+ text +"']");
        isElementPresent(by);
    }
}
