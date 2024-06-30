package utilities;

import common.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.time.Duration;

public class Driver {

    public void startDriver() throws MalformedURLException {
        if (Action.webDriver == null) {
            String browser = Configuration.getProperty("browser");

            switch (browser) {
                case "CHROME":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.addArguments("--incognito");
                    Action.webDriver = new ChromeDriver(options);
                    break;
                case "EDGE":
                    Action.webDriver = new EdgeDriver();
                    break;
                case "FIREFOX":
                    Action.webDriver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Unsupported browser specified in configuration, defaulting to Chrome.");
                    options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    options.addArguments("--incognito");
                    Action.webDriver = new ChromeDriver(options);
            }

            Action.webDriver.manage().window().maximize();
            Action.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            Action.webDriver.get(Configuration.getProperty("url"));

        }
    }

    public void quitDriver() {
        if (null != Action.webDriver) {
            Action.webDriver.quit();
        }
    }
}
