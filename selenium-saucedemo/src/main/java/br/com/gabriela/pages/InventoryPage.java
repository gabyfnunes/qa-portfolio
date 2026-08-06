package br.com.gabriela.pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    private final By title = By.className("title");
    private static final String INVENTORY_URL =
            "https://www.saucedemo.com/inventory.html";

    public void open() {
        open(INVENTORY_URL);
    }

    public String getPageTitle() {
        return find(title).getText();
    }
}
