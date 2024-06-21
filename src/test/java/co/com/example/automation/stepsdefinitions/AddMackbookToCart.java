package co.com.example.automation.stepsdefinitions;

import co.com.example.automation.hooks.Hooks;
import co.com.example.automation.pages.CommonsPage;
import co.com.example.automation.pages.HomePage;
import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import static co.com.example.automation.stepsdefinitions.LoginStep.driver;
import static co.com.example.automation.stepsdefinitions.LoginStep.extentTest;

public class AddMackbookToCart {
    HomePage homePage;
    @When("the user clicks on the laptops category")
    public void theUserClicksOnTheLaptopsCategory() throws Exception {
        Hooks.getTest().log(Status.INFO, "Navigated to Laptops category");
        homePage = new HomePage(driver, extentTest);
        homePage.clickOnLaptopsOption();
    }

    @And("the user adds the MacBook to the cart")
    public void theUserAddsTheMacBookToTheCart() throws Exception {
        Hooks.getTest().log(Status.INFO, "Selecting a MackBook Air");
        homePage.selectMacbookAir();
        Assertions.assertThat(homePage.isTitleMacbookDisplayed())
                .as("The page Mackbook did not load")
                .isTrue();
        homePage.clickOnAddToCart();
    }

    @Then("the MacBook should be added to the cart successfully")
    public void theMacBookShouldBeAddedToTheCartSuccessfully() {
        Hooks.getTest().log(Status.INFO, "Article added to cart");
        CommonsPage commonsPage = new CommonsPage(driver, extentTest);
        Assertions.assertThat(commonsPage.getPopUpMessage())
                .as("The expected message is not displayed")
                .isEqualTo("Product added");
    }
}
