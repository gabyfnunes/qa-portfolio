package br.com.gabriela.steps;

import br.com.gabriela.pages.CartPage;
import br.com.gabriela.pages.InventoryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps {
    private final CartPage cartPage = new CartPage();
    private final InventoryPage inventoryPage = new InventoryPage();


    @When("the user opens the shopping cart")
    public void theUserOpensTheShoppingCart() {
        inventoryPage.openCart();
    }

    @Then("the cart page should be displayed")
    public void theCartPageShouldBeDisplayed() {
        assertTrue(cartPage.isCartPageDisplayed());
        assertEquals("Your Cart", cartPage.getPageTitle());
    }

    @Then("the added product should be displayed in the cart")
    public void theAddedProductShouldBeDisplayedInTheCart() {
        assertTrue(cartPage.isProductDisplayedInCart());
    }

    @Then("the cart product should display a name")
    public void theCartProductShouldDisplayAName() {
        assertTrue(cartPage.cartProductHasName());
    }

    @Then("the cart product should display a description")
    public void theCartProductShouldDisplayADescription() {
        assertTrue(cartPage.cartProductHasDescription());
    }

    @Then("the cart product should display a price")
    public void theCartProductShouldDisplayAPrice() {
        assertTrue(cartPage.cartProductHasPrice());
    }

    @Then("the cart product quantity should be {string}")
    public void theCartProductQuantityShouldBe(String expectedQuantity) {
        assertEquals(expectedQuantity, cartPage.getProductQuantity());
    }

    @When("the user removes the product from the cart")
    public void theUserRemovesTheProductFromTheCart() {
        cartPage.removeProduct();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        assertTrue(cartPage.isCartEmpty());
    }

    @When("the user clicks on continue shopping")
    public void theUserClicksOnContinueShopping() {
        cartPage.continueShopping();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        cartPage.checkout();
    }

    @Then("the checkout information page should be displayed")
    public void theCheckoutInformationPageShouldBeDisplayed() {
        assertEquals(
                "Checkout: Your Information",
                inventoryPage.getPageTitle()
        );
    }
}
