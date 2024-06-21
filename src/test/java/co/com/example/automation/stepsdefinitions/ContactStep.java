package co.com.example.automation.stepsdefinitions;

import co.com.example.automation.hooks.Hooks;
import co.com.example.automation.pages.CommonsPage;
import co.com.example.automation.pages.ContactPage;
import co.com.example.automation.pages.HomePage;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import static co.com.example.automation.stepsdefinitions.LoginStep.driver;
import static co.com.example.automation.stepsdefinitions.LoginStep.extentTest;

public class ContactStep {
    ContactPage contactPage;
    Faker faker;
    @When("we click on the contact option")
    public void weClickOnTheContactOption() throws Exception {
        Hooks.getTest().log(Status.INFO, "Navigated to Contact Option");
        HomePage homePage = new HomePage(driver, extentTest);
        homePage.clickOnContactOption();
    }

    @And("we fill the form")
    public void weFillTheForm() throws Exception {
        Hooks.getTest().log(Status.INFO, "Fill the form");
        contactPage = new ContactPage(driver, extentTest);
        faker = new Faker();
        Assertions.assertThat(contactPage.isTitleModalContactDisplayed())
                .as("Modal title is not displayed")
                .isTrue();
        contactPage.setEmail(faker.internet().emailAddress());
        contactPage.setName(faker.name().fullName());
        contactPage.enterMessage(faker.company().profession());
    }

    @Then("the form is sent")
    public void theFormIsSent() throws Exception {
        Hooks.getTest().log(Status.INFO, "Form submitted");
        contactPage.clickOnSendButton();
        CommonsPage commonsPage = new CommonsPage(driver, extentTest);
        Assertions.assertThat(commonsPage.getPopUpMessage())
                .as("The expected message is not displayed")
                .isEqualTo("Thanks for the message!!");
    }
}
