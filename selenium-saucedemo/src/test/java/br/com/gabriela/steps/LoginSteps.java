package br.com.gabriela.steps;

import br.com.gabriela.pages.InventoryPage;
import br.com.gabriela.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginPage.open();
    }

    @When("the user enters username {string} and password {string}")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        loginPage.login(username, password);
    }

    @When("the user enters username {string} and password {string} without logging in")
    public void theUserEntersCredentialsWithoutLoggingIn(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @Then("the Products page should be displayed")
    public void theProductsPageShouldBeDisplayed() {
        assertEquals(
                "Products",
                inventoryPage.getPageTitle()
        );
    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String expectedMessage) {
        assertEquals(
                expectedMessage,
                loginPage.getLoginErrorMessage()
        );
    }

    @Then("the password field should remain masked")
    public void thePasswordFieldShouldRemainMasked() {
        assertEquals(
                "password",
                loginPage.getPasswordFieldType()
        );
    }

    @When("the user accesses the inventory page without being logged in")
    public void theUserAccessesTheInventoryPageWithoutBeingLoggedIn() {
        inventoryPage.open();
    }

    @Then("the authentication error message should be displayed")
    public void theAuthenticationErrorMessageShouldBeDisplayed() {
        assertEquals(
                "Epic sadface: You can only access '/inventory.html' when you are logged in.",
                loginPage.getLoginErrorMessage()
        );
    }

    @When("closes the error message")
    public void closesTheErrorMessage() {
        loginPage.closeErrorMessage();
    }

    @Then("the error message should no longer be displayed")
    public void theErrorMessageShouldNoLongerBeDisplayed() {
        assertFalse(loginPage.isErrorMessageDisplayed());
    }
}