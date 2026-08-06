package br.com.gabriela.pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    private final By title = By.className("title");

    public String getPageTitle() {
        return find(title).getText();
    }
}
