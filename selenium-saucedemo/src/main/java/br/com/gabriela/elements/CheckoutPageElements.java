package br.com.gabriela.elements;

import org.openqa.selenium.By;

public class CheckoutPageElements {
    public static final By CHECKOUT_TITLE = By.cssSelector("[data-test='title']");
    public static final By FIRST_NAME = By.cssSelector("[data-test='firstName']");
    public static final By LAST_NAME = By.cssSelector("[data-test='lastName']");
    public static final By POSTAL_CODE = By.cssSelector("[data-test='postalCode']");
    public static final By CONTINUE_BUTTON = By.cssSelector("[data-test='continue']");
    public static final By CANCEL_BUTTON = By.cssSelector("[data-test='cancel']");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
    public static final By OVERVIEW_ITEM = By.cssSelector("[data-test='inventory-item']");
    public static final By OVERVIEW_ITEM_NAME = By.cssSelector("[data-test='inventory-item-name']");
    public static final By OVERVIEW_ITEM_DESCRIPTION = By.cssSelector("[data-test='inventory-item-desc']");
    public static final By OVERVIEW_ITEM_PRICE = By.cssSelector("[data-test='inventory-item-price']");
    public static final By OVERVIEW_ITEM_QUANTITY = By.cssSelector("[data-test='item-quantity']");
    public static final By FINISH_BUTTON = By.cssSelector("[data-test='finish']");
    public static final By COMPLETE_CONTAINER = By.cssSelector("[data-test='checkout-complete-container']");
    public static final By SUCCESS_MESSAGE = By.cssSelector("[data-test='complete-header']");
}
