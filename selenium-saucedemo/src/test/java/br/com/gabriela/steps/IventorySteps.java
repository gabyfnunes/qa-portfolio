package br.com.gabriela.steps;

import br.com.gabriela.pages.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IventorySteps {
    private final InventoryPage inventoryPage =
            new InventoryPage();



    @Given("the user is on the inventory page")
    public void theUserIsOnTheInventoryPage() {
        inventoryPage.open();
    }



    @Then("the inventory page should be displayed")
    public void theInventoryPageShouldBeDisplayed() {
        assertTrue(
                inventoryPage.isInventoryPageDisplayed()
        );
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(
            String expectedTitle
    ) {

        assertEquals(
                expectedTitle,
                inventoryPage.getPageTitle()
        );
    }



    @Then("the product list should be displayed")
    public void theProductListShouldBeDisplayed() {

        assertTrue(
                inventoryPage.isProductListDisplayed()
        );
    }

    @Then("the inventory should contain available products")
    public void theInventoryShouldContainAvailableProducts() {

        assertTrue(
                inventoryPage.getProductCount() > 0
        );
    }



    @Then("each product should display a name")
    public void eachProductShouldDisplayAName() {

        assertTrue(
                inventoryPage.allProductsHaveName()
        );
    }

    @Then("each product should display a description")
    public void eachProductShouldDisplayADescription() {

        assertTrue(
                inventoryPage.allProductsHaveDescription()
        );
    }

    @Then("each product should display a price")
    public void eachProductShouldDisplayAPrice() {

        assertTrue(
                inventoryPage.allProductsHavePrice()
        );
    }

    @Then("each product should display an {string} button")
    public void eachProductShouldDisplayAButton(
            String buttonText
    ) {

        assertTrue(
                inventoryPage
                        .allProductsHaveAddToCartButton(
                                buttonText
                        )
        );
    }



    @When("the user adds a product to the cart")
    public void theUserAddsAProductToTheCart() {

        inventoryPage.addProductToCart();
    }

    @Then("the product should be added to the cart")
    public void theProductShouldBeAddedToTheCart() {

        assertEquals(
                "1",
                inventoryPage.getCartBadge()
        );
    }



    @Given("the user has added a product to the cart")
    public void theUserHasAddedAProductToTheCart() {

        inventoryPage.addProductToCart();
    }

    @When("the user removes the product from the inventory page")
    public void theUserRemovesTheProductFromTheInventoryPage() {

        inventoryPage.removeProductFromCart();
    }

    @Then("the product should be removed from the cart")
    public void theProductShouldBeRemovedFromTheCart() {

        assertFalse(
                inventoryPage.isCartBadgeDisplayed()
        );
    }



    @When("the user adds multiple products to the cart")
    public void theUserAddsMultipleProductsToTheCart() {

        inventoryPage.addMultipleProductsToCart();
    }

    @Then("all selected products should be added to the cart")
    public void allSelectedProductsShouldBeAddedToTheCart() {

        assertEquals(
                "2",
                inventoryPage.getCartBadge()
        );
    }



    @Then("the cart badge should display {string}")
    public void theCartBadgeShouldDisplay(
            String expectedQuantity
    ) {

        assertEquals(
                expectedQuantity,
                inventoryPage.getCartBadge()
        );
    }

    @Given("the user has added two products to the cart")
    public void theUserHasAddedTwoProductsToTheCart() {

        inventoryPage.addMultipleProductsToCart();
    }

    @When("the user removes one product from the inventory page")
    public void theUserRemovesOneProductFromTheInventoryPage() {

        inventoryPage.removeProductFromCart();
    }



    @When("the user clicks on a product name")
    public void theUserClicksOnAProductName() {

        inventoryPage.clickProductName();
    }

    @Then("the product details page should be displayed")
    public void theProductDetailsPageShouldBeDisplayed() {

        assertTrue(
                inventoryPage
                        .isProductDetailsPageDisplayed()
        );
    }

    @Then("the selected product information should be displayed")
    public void theSelectedProductInformationShouldBeDisplayed() {

        assertTrue(
                inventoryPage
                        .isProductInformationDisplayed()
        );
    }

    @Given("the user is viewing a product details page")
    public void theUserIsViewingAProductDetailsPage() {

        inventoryPage.clickProductName();
    }

    @When("the user returns to the inventory")
    public void theUserReturnsToTheInventory() {

        inventoryPage.backToProducts();
    }



    @When("the user sorts the products by {string}")
    public void theUserSortsTheProductsBy(
            String option
    ) {

        inventoryPage.selectSortOption(option);
    }

    @Then("the products should be displayed in ascending alphabetical order")
    public void productsShouldBeDisplayedInAscendingAlphabeticalOrder() {

        List<String> actual =
                inventoryPage.getProductNames();

        List<String> expected =
                new ArrayList<>(actual);

        expected.sort(
                String.CASE_INSENSITIVE_ORDER
        );

        assertEquals(
                expected,
                actual
        );
    }

    @Then("the products should be displayed in descending alphabetical order")
    public void productsShouldBeDisplayedInDescendingAlphabeticalOrder() {

        List<String> actual =
                inventoryPage.getProductNames();

        List<String> expected =
                new ArrayList<>(actual);

        expected.sort(
                String.CASE_INSENSITIVE_ORDER
                        .reversed()
        );

        assertEquals(
                expected,
                actual
        );
    }

    @Then("the products should be displayed in ascending price order")
    public void productsShouldBeDisplayedInAscendingPriceOrder() {

        List<Double> actual =
                inventoryPage.getProductPrices();

        List<Double> expected =
                new ArrayList<>(actual);

        expected.sort(
                Comparator.naturalOrder()
        );

        assertEquals(
                expected,
                actual
        );
    }

    @Then("the products should be displayed in descending price order")
    public void productsShouldBeDisplayedInDescendingPriceOrder() {

        List<Double> actual =
                inventoryPage.getProductPrices();

        List<Double> expected =
                new ArrayList<>(actual);

        expected.sort(
                Comparator.reverseOrder()
        );

        assertEquals(
                expected,
                actual
        );
    }
}
