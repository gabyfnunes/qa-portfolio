package br.com.gabriela.pages;

import br.com.gabriela.elements.InventoryPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private static final String INVENTORY_URL =
            "https://www.saucedemo.com/inventory.html";

    public void open() {
        open(INVENTORY_URL);
    }

    public String getPageTitle() {
        return find(InventoryPageElements.PRODUCTS_TITLE).getText();
    }

    public boolean isInventoryPageDisplayed() {
        return find(InventoryPageElements.PRODUCTS_TITLE).isDisplayed();
    }

    public boolean isProductListDisplayed() {
        return find(InventoryPageElements.INVENTORY_LIST).isDisplayed();
    }

    public int getProductCount() {
        return driver.findElements(
                InventoryPageElements.INVENTORY_ITEM
        ).size();
    }

    public boolean allProductsHaveName() {
        List<WebElement> elements =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ITEM_NAME
                );

        return elements.stream()
                .allMatch(element ->
                        !element.getText().isBlank());
    }

    public boolean allProductsHaveDescription() {
        List<WebElement> elements =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ITEM_DESCRIPTION
                );

        return elements.stream()
                .allMatch(element ->
                        !element.getText().isBlank());
    }

    public boolean allProductsHavePrice() {
        List<WebElement> elements =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ITEM_PRICE
                );

        return elements.stream()
                .allMatch(element ->
                        !element.getText().isBlank());
    }

    public boolean allProductsHaveAddToCartButton(String buttonText) {
        List<WebElement> buttons =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ADD_TO_CART_BTN
                );

        return !buttons.isEmpty()
                && buttons.stream()
                .allMatch(button ->
                        button.getText().equalsIgnoreCase(buttonText));
    }

    public void addProductToCart() {
        List<WebElement> buttons =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ADD_TO_CART_BTN
                );

        buttons.get(0).click();
    }

    public void removeProductFromCart() {
        List<WebElement> buttons =
                driver.findElements(
                        InventoryPageElements.INVENTORY_REMOVE_BTN
                );

        buttons.get(0).click();
    }

    public void addMultipleProductsToCart() {
        List<WebElement> buttons =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ADD_TO_CART_BTN
                );

        buttons.get(0).click();
        buttons.get(1).click();
    }

    public String getCartBadge() {
        return find(
                InventoryPageElements.CART_BADGE
        ).getText();
    }

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(
                InventoryPageElements.CART_BADGE
        ).isEmpty();
    }

    public void clickProductName() {
        List<WebElement> products =
                driver.findElements(
                        InventoryPageElements.INVENTORY_ITEM_NAME
                );

        products.get(0).click();
    }

    public boolean isProductDetailsPageDisplayed() {
        return !driver.findElements(
                InventoryPageElements.BACK_TO_PRODUCTS_BTN
        ).isEmpty();
    }

    public boolean isProductInformationDisplayed() {

        boolean name =
                !driver.findElements(
                        InventoryPageElements.PRODUCT_DETAILS_NAME
                ).isEmpty();

        boolean description =
                !driver.findElements(
                        InventoryPageElements.PRODUCT_DETAILS_DESCRIPTION
                ).isEmpty();

        boolean price =
                !driver.findElements(
                        InventoryPageElements.PRODUCT_DETAILS_PRICE
                ).isEmpty();

        return name && description && price;
    }

    public void backToProducts() {
        find(
                InventoryPageElements.BACK_TO_PRODUCTS_BTN
        ).click();
    }

    public void selectSortOption(String option) {

        WebElement sortElement =
                driver.findElement(
                        InventoryPageElements.INVENTORY_SORT_SELECT
                );

        Select select = new Select(sortElement);

        select.selectByVisibleText(option);
    }

    public List<String> getProductNames() {

        return driver.findElements(
                        InventoryPageElements.INVENTORY_ITEM_NAME
                )
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getProductPrices() {

        return driver.findElements(
                        InventoryPageElements.INVENTORY_ITEM_PRICE
                )
                .stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
