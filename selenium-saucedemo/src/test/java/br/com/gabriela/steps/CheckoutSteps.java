package br.com.gabriela.steps;

import br.com.gabriela.pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutSteps {
    private final CheckoutPage checkoutPage = new CheckoutPage();


    @Then("the checkout information page should be displayed")
    public void theCheckoutInformationPageShouldBeDisplayed() {
        assertTrue(
                checkoutPage.isCheckoutInformationPageDisplayed()
        );

        assertEquals(
                "Checkout: Your Information",
                checkoutPage.getPageTitle()
        );
    }


    @When("the user fills in the checkout information with valid data")
    public void theUserFillsInTheCheckoutInformationWithValidData() {
        checkoutPage.fillCheckoutInformation(
                "Gabriela",
                "Nunes",
                "72000-000"
        );
    }


    @When("the user fills in the first name")
    public void theUserFillsInTheFirstName() {
        checkoutPage.fillFirstName("Gabriela");
    }


    @When("the user leaves the first name field empty")
    public void theUserLeavesTheFirstNameFieldEmpty() {
    }


    @When("the user fills in the last name")
    public void theUserFillsInTheLastName() {
        checkoutPage.fillLastName("Nunes");
    }


    @When("the user leaves the last name field empty")
    public void theUserLeavesTheLastNameFieldEmpty() {
    }


    @When("the user fills in the postal code")
    public void theUserFillsInThePostalCode() {
        checkoutPage.fillPostalCode("72000-000");
    }


    @When("the user leaves the postal code field empty")
    public void theUserLeavesThePostalCodeFieldEmpty() {
    }


    @When("the user continues the checkout")
    public void theUserContinuesTheCheckout() {
        checkoutPage.continueCheckout();
    }


    @Then("the error message should contain {string}")
    public void theErrorMessageShouldContain(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();

        assertEquals(
                "Error: " + expectedMessage,
                actualMessage
        );
    }


    @Then("the checkout overview page should be displayed")
    public void theCheckoutOverviewPageShouldBeDisplayed() {
        assertEquals(
                "Checkout: Overview",
                checkoutPage.getPageTitle()
        );
    }
    @When("the user finishes the purchase")
    public void theUserFinishesThePurchase() {
        checkoutPage.finishPurchase();
    }

    @Then("the order confirmation page should be displayed")
    public void theOrderConfirmationPageShouldBeDisplayed() {
        assertTrue(
                checkoutPage.isOrderConfirmationPageDisplayed()
        );
    }

    @Then("the success message should be {string}")
    public void theSuccessMessageShouldBe(String expectedMessage) {
        assertEquals(
                expectedMessage,
                checkoutPage.getSuccessMessage()
        );
    }
}
