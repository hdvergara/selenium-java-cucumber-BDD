package co.com.example.automation.stepsdefinitions;

import co.com.example.automation.hooks.Hooks;
import co.com.example.automation.pages.CommonsPage;
import co.com.example.automation.pages.HomePage;
import co.com.example.automation.pages.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class LoginStep {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    LoginPage loginPage;
    String username = "";

    @Given("^the user enter to the application$")
    public void theUserEnterToTheApplication() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        Hooks.driver.get("https://www.demoblaze.com/index.html");
        Hooks.getTest().log(Status.INFO, "Navigated to Home Page");
    }

    @When("the user click on the login option")
    public void theUserClickOnTheLoginOption() throws Exception {
        Hooks.getTest().log(Status.INFO, "Navigated to Login Option");
        HomePage homePage = new HomePage(driver, extentTest);
        homePage.clickOnLoginOption();
    }
    @And("enter incorrect login credentials")
    public void enterIncorrectLoginCredentials() throws Exception {
        Hooks.getTest().log(Status.INFO, "Enter the incorrect data");
        LoginPage loginPage = new LoginPage(driver, extentTest);
        loginPage.setUserName("testuser");
        loginPage.setPassword("14587444");
        loginPage.clickOnLoginButton();
    }
    @Then("a message indicating that the credentials are incorrect is displayed")
    public void aMessageIndicatingThatTheCredentialsAreIncorrectIsDisplayed() {
        Hooks.getTest().log(Status.INFO, "View the credentials incorrect message");
        CommonsPage commonsPage = new CommonsPage(driver, extentTest);
        Assertions.assertThat(commonsPage.getPopUpMessage())
                .as("")
                .isEqualTo("Wrong password.");
    }
    @And("enter login credentials")
    public void enterLoginCredentials(DataTable dataTable) throws Exception {
        Hooks.getTest().log(Status.INFO, "Enter the correct data");
        List<Map<String, String>> loginData = dataTable.asMaps(String.class, String.class);
        loginPage = new LoginPage(driver, extentTest);
        username = loginData.get(0).get("Username");
        loginPage.setUserName(username);
        loginPage.setPassword(loginData.get(0).get("Password"));
        loginPage.clickOnLoginButton();
    }
    @Then("user is logged correctly")
    public void userIsLoggedInCorrectly() throws Exception {
        Hooks.getTest().log(Status.INFO, "View logged user");
        Assertions.assertThat(loginPage.getUserNameLogged())
                .as("The expected message is not displayed")
                .containsIgnoringCase(username);
    }
}
