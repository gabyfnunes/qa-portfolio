package br.com.gabriela.elements;

import org.openqa.selenium.By;

public class InventoryPageElements {
        public static final By PRODUCTS_TITLE = By.cssSelector("[data-test='title']");
        public static final By INVENTORY_LIST = By.cssSelector("[data-test='inventory-list']");
        public static final By INVENTORY_ITEM = By.cssSelector("[data-test='inventory-item']");
        public static final By INVENTORY_ITEM_NAME = By.cssSelector("[data-test='inventory-item-name']");
        public static final By INVENTORY_ITEM_DESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
        public static final By INVENTORY_ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
        public static final By INVENTORY_ADD_TO_CART_BTN = By.cssSelector("button[id^='add-to-cart']");
        public static final By INVENTORY_REMOVE_BTN = By.cssSelector("button[id^='remove']");
        public static final By INVENTORY_CART_BTN = By.cssSelector("[data-test='shopping-cart-link']");
        public static final By CART_BADGE = By.cssSelector("[data-test='shopping-cart-badge']");
        public static final By INVENTORY_SORT_SELECT = By.cssSelector("[data-test='product-sort-container']");
        public static final By BACK_TO_PRODUCTS_BTN = By.cssSelector("[data-test='back-to-products']");
        public static final By PRODUCT_DETAILS_NAME = By.cssSelector("[data-test='inventory-item-name']");
        public static final By PRODUCT_DETAILS_DESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
        public static final By PRODUCT_DETAILS_PRICE = By.cssSelector("[data-test='inventory-item-price']");



}
