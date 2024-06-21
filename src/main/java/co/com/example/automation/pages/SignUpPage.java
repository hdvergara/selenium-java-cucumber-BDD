package co.com.example.automation.pages;

import co.com.example.automation.actions.WebAction;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    private final WebAction webAction;
    private final WebDriver driver;

    public SignUpPage(WebDriver driver, ExtentTest extentTest) {
        this.webAction = new WebAction(driver, extentTest);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private int DEFAULT_TIME = 30;

    @FindBy(how = How.ID, using = "sign-username")
    public WebElement inputUserName;
    @FindBy(how = How.ID, using = "sign-password")
    public WebElement inputPassword;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Sign up')]")
    public WebElement btnSignUp;
    @FindBy(how = How.XPATH, using = "//h5[@id='signInModalLabel']")
    public WebElement lblTitleModalSignUp;

    public boolean isTitleModalSignUpDisplayed() {
        return webAction.isVisible(lblTitleModalSignUp, DEFAULT_TIME);
    }
    public void setUserName(String userName) throws Exception {
        webAction.sendText(inputUserName, userName, DEFAULT_TIME);
    }
    public void setInputPassword(String password) throws Exception {
        webAction.sendText(inputPassword, password, DEFAULT_TIME);
    }
    public void clickOnSignUpButton() throws Exception {
        webAction.click(btnSignUp, DEFAULT_TIME);
    }
}
