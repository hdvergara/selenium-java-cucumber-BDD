package co.com.example.automation.stepsdefinitions;

import co.com.example.automation.hooks.Hooks;
import co.com.example.automation.pages.CommonsPage;
import co.com.example.automation.pages.HomePage;
import co.com.example.automation.pages.SignUpPage;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import static co.com.example.automation.stepsdefinitions.LoginStep.driver;
import static co.com.example.automation.stepsdefinitions.LoginStep.extentTest;

public class SignUpStep {
    Faker faker;
    @When("the user selects the Sign Up option")
    public void theUserSelectsTheSignUpOption() throws Exception {
        Hooks.getTest().log(Status.INFO, "Navigated Sign Up option");
        HomePage homePage = new HomePage(driver, extentTest);
        homePage.clickOnSignUpOption();
    }
    @And("enter the data for registration")
    public void enterTheDataForRegistration() throws Exception {
        Hooks.getTest().log(Status.INFO, "Enter the data for de register");
        SignUpPage signUpPage = new SignUpPage(driver, extentTest);
        faker = new Faker();
        signUpPage.setUserName(faker.name().username());
        signUpPage.setInputPassword("Test12345");
        signUpPage.clickOnSignUpButton();
    }

    @Then("a successful registration confirmation message is displayed")
    public void aSuccessfulRegistrationConfirmationMessageIsDisplayed() {
        Hooks.getTest().log(Status.INFO, "Creation user");
        CommonsPage commonsPage = new CommonsPage(driver, extentTest);
        Assertions.assertThat(commonsPage.getPopUpMessage())
                .as("The expected message is not displayed")
                .isEqualTo("Sign up successful.");
    }
}
