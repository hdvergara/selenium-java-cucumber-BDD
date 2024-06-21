package co.com.example.automation.pages;

import co.com.example.automation.actions.WebAction;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    private final WebAction webAction;
    private final WebDriver driver;

    public ContactPage(WebDriver driver, ExtentTest extentTest) {
        this.webAction = new WebAction(driver, extentTest);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private int DEFAULT_TIME = 30;

    @FindBy(how = How.ID, using = "exampleModalLabel")
    public WebElement lblTitleModalContact;

    @FindBy(how = How.ID, using = "recipient-email")
    public WebElement inputEmail;

    @FindBy(how = How.ID, using = "recipient-name")
    public WebElement inputName;

    @FindBy(how = How.ID, using = "message-text")
    public WebElement txtMessage;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Send message')]")
    public WebElement btnSendMessage;

    /**
     * Checks if the "Contact" title modal is displayed.
     * <p>
     * This method uses the WebAction class to check if the label element with the title "Contact" is visible within the default time.
     *
     * @return True if the "Contact" title modal is displayed, false otherwise.
     */
    public boolean isTitleModalContactDisplayed() {
        return webAction.isVisible(lblTitleModalContact, DEFAULT_TIME);
    }

    /**
     * Sets the email address in the input field.
     * <p>
     * This method uses the WebAction class to send the specified email address to the input field within the default time.
     *
     * @param email The email address to be set.
     * @throws Exception If the input field is not found or the email address cannot be sent within the default time.
     */
    public void setEmail(String email) throws Exception {
        webAction.sendText(inputEmail, email, DEFAULT_TIME);
    }

    /**
     * Sets the name in the input field.
     * <p>
     * This method uses the WebAction class to send the specified name to the input field within the default time.
     *
     * @param name The name to be set.
     * @throws Exception If the input field is not found or the name cannot be sent within the default time.
     */
    public void setName(String name) throws Exception {
        webAction.sendText(inputName, name, DEFAULT_TIME);
    }

    /**
     * Enters a message in the text area.
     * <p>
     * This method uses the WebAction class to send the specified message to the text area within the default time.
     *
     * @param message The message to be entered.
     * @throws Exception If the text area is not found or the message cannot be sent within the default time.
     */
    public void enterMessage(String message) throws Exception {
        webAction.sendText(txtMessage, message, DEFAULT_TIME);
    }

    /**
     * Clicks on the Send button.
     * <p>
     * This method uses the WebAction class to click on the Send button within the default time.
     *
     * @throws Exception If the Send button is not found or cannot be clicked within the default time.
     */
    public void clickOnSendButton() throws Exception {
        webAction.click(btnSendMessage, DEFAULT_TIME);
    }
}
