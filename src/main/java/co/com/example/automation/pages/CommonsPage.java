package co.com.example.automation.pages;

import co.com.example.automation.actions.WebAction;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonsPage {

    private final WebAction webAction;
    private final WebDriver driver;

    /**
     * Initializes a new instance of the CommonsPage class.
     * <p>
     * This constructor initializes the WebAction object and sets the WebDriver and ExtentTest instances.
     * It also initializes the page elements using PageFactory.
     *
     * @param driver     The WebDriver instance to use for interacting with the browser.
     * @param extentTest The ExtentTest instance to use for reporting test results.
     */
    public CommonsPage(WebDriver driver, ExtentTest extentTest) {
        this.webAction = new WebAction(driver, extentTest);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Retrieves the text of the current alert dialog.
     * <p>
     * This method waits for up to 20 seconds for the alert dialog to be present, then switches to the alert and retrieves its text.
     *
     * @return The text of the alert dialog.
     */
    public String getPopUpMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }
}
