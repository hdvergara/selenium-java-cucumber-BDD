package co.com.example.automation.utils;

import co.com.example.automation.helpers.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    /**
     * Returns a WebDriver instance based on the specified browser type.
     * <p>
     * This method sets up the WebDriverManager for the specified browser, creates a new instance of the corresponding driver,
     * and maximizes the browser window.
     *
     * @param browser The type of browser to use (CHROME, FIREFOX, or EDGE).
     * @return A WebDriver instance for the specified browser.
     */
    public static WebDriver getDriver(Browsers browser) {
        WebDriver driver = null;
        switch (browser) {
            case CHROME:
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
}
