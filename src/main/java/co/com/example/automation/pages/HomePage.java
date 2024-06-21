package co.com.example.automation.pages;

import co.com.example.automation.actions.WebAction;
import com.aventstack.extentreports.ExtentTest;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Log4j2
public class HomePage {

    private final WebAction webAction;
    private final WebDriver driver;

    public HomePage(WebDriver driver, ExtentTest extentTest) {
        this.webAction = new WebAction(driver, extentTest);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private final int DEFAULT_TIME = 30;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Contact')]")
    public WebElement lnkContact;
    @FindBy(how = How.XPATH, using = "//a[text()='MacBook air']")
    public WebElement lnkMacBookAir;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Laptops')]")
    public WebElement lnkLaptops;
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'MacBook air')]")
    public WebElement lblTitleMacbook;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Add to cart')]")
    public WebElement btnAddToCar;
    @FindBy(how = How.ID, using = "signin2")
    public WebElement lnkSignUp;
    @FindBy(how = How.ID, using = "login2")
    public WebElement lnkLogin;
    @FindBy(how = How.ID, using = "cartur")
    public WebElement lnkCart;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Home')]")
    public WebElement lnkHome;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'ASUS Full HD')]")
    public WebElement lnkAsusMonitor;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Phones')]")
    public WebElement lnkPhones;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Monitors')]")
    public WebElement lnkMonitors;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'HTC One M9')]")
    public WebElement lnkHtcOneM9;
    @FindBy(how = How.XPATH, using = "//*[@id='tbodyid']/tr/td[2]")
    public List<WebElement> tableCart;


    public void clickOnContactOption() throws Exception {
        webAction.click(lnkContact, DEFAULT_TIME);
    }

    public void clickOnLaptopsOption() throws Exception {
        webAction.click(lnkLaptops, DEFAULT_TIME);
    }

    public void selectMacbookAir() throws Exception {

        webAction.click(lnkMacBookAir, DEFAULT_TIME);
    }

    public boolean isTitleMacbookDisplayed() {
        return webAction.isVisible(lblTitleMacbook, DEFAULT_TIME);
    }

    public void clickOnAddToCart() throws Exception {
        webAction.click(btnAddToCar, DEFAULT_TIME);
    }

    public void clickAcceptPopUp() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public void clickOnSignUpOption() throws Exception {
        webAction.click(lnkSignUp, DEFAULT_TIME);
    }

    public void clickOnLoginOption() throws Exception {
        webAction.click(lnkLogin, DEFAULT_TIME);
    }

    public void clickOnCartOption() throws Exception {
        webAction.click(lnkCart, DEFAULT_TIME);
    }

    public void clickOnHomeOption() throws Exception {
        webAction.click(lnkHome, DEFAULT_TIME);
    }

    public void selectAsusMonitor() throws Exception {
        webAction.click(lnkAsusMonitor, DEFAULT_TIME);
    }

    public void clickOnPhonesOption() throws Exception {
        webAction.click(lnkPhones, DEFAULT_TIME);
    }

    public void clickOnMonitorsOption() throws Exception {
        webAction.click(lnkMonitors, DEFAULT_TIME);
    }

    public void selectHtcOne() throws Exception {
        webAction.click(lnkHtcOneM9, DEFAULT_TIME);
    }

    public void validateItemsOnShoppingCart() throws Exception {
        for (WebElement webElement : tableCart) {
            log.info(webAction.getText(webElement, DEFAULT_TIME));
            log.info(webAction.getText(webElement, DEFAULT_TIME));
        }
    }

}
