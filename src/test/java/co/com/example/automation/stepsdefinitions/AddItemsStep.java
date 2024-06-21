package co.com.example.automation.stepsdefinitions;

import co.com.example.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddItemsStep {

    HomePage homePage;

    @When("user adds items")
    public void userAddsItems() throws Exception {
        homePage = new HomePage(LoginStep.driver, LoginStep.extentTest);
        homePage.clickOnMonitorsOption();
        homePage.selectAsusMonitor();
        homePage.clickOnAddToCart();
        homePage.clickAcceptPopUp();
        homePage.clickOnHomeOption();
        homePage.clickOnPhonesOption();
        homePage.selectHtcOne();
        homePage.clickOnAddToCart();
        homePage.clickAcceptPopUp();
    }

    @Then("items can be seen in the shopping cart")
    public void itemsCanBeSeenInTheShoppingCart() throws Exception {
        homePage.clickOnCartOption();
        homePage.validateItemsOnShoppingCart();
    }
}
