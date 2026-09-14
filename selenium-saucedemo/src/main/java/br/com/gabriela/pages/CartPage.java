package br.com.gabriela.pages;

import br.com.gabriela.elements.CartPageElements;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    private static final String CART_URL =
            "https://www.saucedemo.com/cart.html";

    public void open() {
        open(CART_URL);
    }

    public String getPageTitle() {
        return find(CartPageElements.CART_TITLE).getText();
    }

    public boolean isCartPageDisplayed() {
        return find(CartPageElements.CART_TITLE).isDisplayed();
    }

    public int getCartItemCount() {
        return driver.findElements(
                CartPageElements.CART_ITEM
        ).size();
    }

    public boolean isCartEmpty() {
        return driver.findElements(
                CartPageElements.CART_ITEM
        ).isEmpty();
    }

    public boolean isProductDisplayedInCart() {
        return !driver.findElements(
                CartPageElements.CART_ITEM
        ).isEmpty();
    }

    public boolean cartProductHasName() {
        List<WebElement> names =
                driver.findElements(
                        CartPageElements.CART_ITEM_NAME
                );

        return !names.isEmpty()
                && names.stream()
                .allMatch(element ->
                        !element.getText().isBlank());
    }

    public boolean cartProductHasDescription() {
        List<WebElement> descriptions =
                driver.findElements(
                        CartPageElements.CART_ITEM_DESCRIPTION
                );

        return !descriptions.isEmpty()
                && descriptions.stream()
                .allMatch(element ->
                        !element.getText().isBlank());
    }

    public boolean cartProductHasPrice() {
        List<WebElement> prices =
                driver.findElements(
                        CartPageElements.CART_ITEM_PRICE
                );

        return !prices.isEmpty()
                && prices.stream()
                .allMatch(element ->
                        !element.getText().isBlank());
    }

    public String getProductQuantity() {
        return find(
                CartPageElements.CART_ITEM_QUANTITY
        ).getText();
    }

    public void removeProduct() {
        List<WebElement> buttons =
                driver.findElements(
                        CartPageElements.REMOVE_BUTTON
                );

        buttons.get(0).click();
    }

    public void continueShopping() {
        find(
                CartPageElements.CONTINUE_SHOPPING_BUTTON
        ).click();
    }

    public void checkout() {
        find(
                CartPageElements.CHECKOUT_BUTTON
        ).click();
    }
}
