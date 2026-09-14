package br.com.gabriela.elements;

import org.openqa.selenium.By;

public class CartPageElements {

    public static final By CART_TITLE =By.cssSelector("[data-test='title']");
    public static final By CART_ITEM = By.cssSelector("[data-test='inventory-item']");
    public static final By CART_ITEM_NAME = By.cssSelector("[data-test='inventory-item-name']");
    public static final By CART_ITEM_DESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
    public static final By CART_ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
    public static final By CART_ITEM_QUANTITY = By.cssSelector("[data-test='item-quantity']");
    public static final By REMOVE_BUTTON = By.cssSelector("button[id^='remove']");
    public static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("[data-test='continue-shopping']");
    public static final By CHECKOUT_BUTTON = By.cssSelector("[data-test='checkout']");

}
