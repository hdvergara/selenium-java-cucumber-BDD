package co.com.example.automation.actions;


import com.aventstack.extentreports.ExtentTest;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class WebAction {
    private final ExtentTest extentTest;

    private final WebDriver driver;

    /**
     * Constructor for WebAction class.
     *
     * @param driver     The WebDriver instance to interact with the web application.
     * @param extentTest The ExtentTest instance to report test results.
     */
    public WebAction(WebDriver driver, ExtentTest extentTest) {
        this.driver = driver;
        this.extentTest = extentTest;
    }

    /**
     * Sends text to a WebElement.
     *
     * @param element The WebElement to send text to.
     * @param text    The text to send to the element.
     * @param timeout The maximum time to wait for the element to be visible.
     * @throws Exception If an error occurs while sending text to the element.
     */
    public void sendText(WebElement element, String text, int timeout) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
            extentTest.info("Sent text '" + text + "' to element: " + element);
            log.info("Sent text '" + text + "' to element: " + element);
        } catch (Exception e) {
            extentTest.fail("An error occurred while performing sendText action" + e);
            throw new Exception("An error occurred while performing sendText action", e);
        }
    }

    /**
     * Checks if a WebElement is visible.
     *
     * @param element The WebElement to check for visibility.
     * @param timeout The maximum time to wait for the element to be visible.
     * @return true if the element is visible, false otherwise.
     */
    public boolean isVisible(WebElement element, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException | NoSuchElementException | NullPointerException e) {
            return false;
        }
    }

    /**
     * Clicks on a WebElement.
     *
     * @param element The WebElement to click on.
     * @param timeout The maximum time to wait for the element to be clickable.
     * @throws Exception If an error occurs while clicking on the element.
     */
    public void click(WebElement element, int timeout) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            extentTest.info("Clicked on element: " + element);
            log.info("Clicked on element: " + element);
            element.click();
        } catch (NoSuchElementException | NullPointerException | TimeoutException e) {
            extentTest.fail("An error occurred while performing click action" + e);
            throw new Exception("An error occurred while performing click action", e);
        }
    }

    /**
     * Retrieves the text of a WebElement.
     *
     * @param element The WebElement to retrieve the text from.
     * @param timeout The maximum time to wait for the element to be clickable.
     * @return The text of the WebElement.
     * @throws Exception If an error occurs while retrieving the text.
     */
    public String getText(WebElement element, int timeout) throws Exception {
        String value = "";
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            value = element.getText();
        } catch (NoSuchElementException | NullPointerException | TimeoutException e) {
            extentTest.fail("An error occurred getting the text: " + e);
            throw new Exception("An error occurred getting the text", e);

        }
        extentTest.info("The text " + value + "was obtained from the element: " + element);
        log.info("The text " + value + "was obtained from the element: " + element);
        return value;
    }

}
