package br.com.gabriela.tests;

import br.com.gabriela.driver.DriverManager;
import br.com.gabriela.pages.InventoryPage;
import br.com.gabriela.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {

    @Test
    void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals("Products", inventoryPage.getPageTitle());
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
