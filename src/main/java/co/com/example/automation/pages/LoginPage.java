package co.com.example.automation.pages;

import co.com.example.automation.actions.WebAction;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebAction webAction;
    private final WebDriver driver;

    public LoginPage(WebDriver driver, ExtentTest extentTest) {
        this.webAction = new WebAction(driver, extentTest);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private int DEFAULT_TIME = 30;

    @FindBy(how = How.ID, using = "loginusername")
    public WebElement inputUserName;
    @FindBy(how = How.ID, using = "loginpassword")
    public WebElement inputPassword;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Log in')]")
    public WebElement btnLogin;
    @FindBy(how = How.XPATH, using = "//h5[@id='logInModalLabel']")
    public WebElement lblTitleModalLogin;
    @FindBy(how = How.ID, using = "nameofuser")
    public WebElement lblNameUserLogged;

    public boolean isTitleModalLoginDisplayed() {
        return webAction.isVisible(lblTitleModalLogin, DEFAULT_TIME);
    }
    public void setUserName(String userName) throws Exception {
        webAction.sendText(inputUserName, userName, DEFAULT_TIME);
    }
    public void setPassword(String password) throws Exception {
        webAction.sendText(inputPassword, password, DEFAULT_TIME);
    }
    public void clickOnLoginButton() throws Exception {
        webAction.click(btnLogin, DEFAULT_TIME);
    }
    public String getUserNameLogged() throws Exception {
        return webAction.getText(lblNameUserLogged,DEFAULT_TIME);
    }
}
