package br.com.gabriela.tests;

import br.com.gabriela.driver.DriverManager;
import br.com.gabriela.pages.InventoryPage;
import br.com.gabriela.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void setUp (){
        loginPage.open();
    }

    @Test
    void shouldLoginSuccessfully() {
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login("standard_user", "secret_sauce");

        assertEquals("Products", inventoryPage.getPageTitle());
    }

    @Test
    void shouldNotLoginWithWrongUsername() {
        loginPage.login("wrong_user", "secret_sauce");

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldNotLoginWithWrongPassword() {
        loginPage.login("standard_user", "wrong_secret_sauce");

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldNotLoginWithWrongUsernameAndPassword() {
        loginPage.login("wrong_user", "wrong_secret_sauce");

        assertEquals("Epic sadface: Username and password do not match any user in this service", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldNotLoginWithCredentialsEmpty() {
        loginPage.login("", "");

        assertEquals("Epic sadface: Username is required", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldNotLoginWithUsernameEmpty() {
        loginPage.login("", "secret_sauce");

        assertEquals("Epic sadface: Username is required", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldNotLoginWithPasswordEmpty() {
        loginPage.login("standard_user", "");

        assertEquals("Epic sadface: Password is required", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldNotLoginWithLockeOutUser() {
        loginPage.login("locked_out_user", "secret_sauce");

        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getLoginErrorTxt());
    }

    @Test
    void shouldCloseErrorMessage() {
        loginPage.login("wrong_user", "wrong_password");

        assertTrue(loginPage.isErrorMessageDisplayed());

        loginPage.closeErrorMessage();
        assertFalse(loginPage.isErrorMessageDisplayed());
    }

    @Test
    void shouldKeepMaskedPassword() {
        loginPage.inputCredentials("standard_user", "wrong_secret_sauce");

        assertEquals("password", loginPage.getPasswordFieldType());
    }

    @Test
    void naoDevePermitirAcessoAoInventarioSemLogin() {
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.open();

        assertEquals("Epic sadface: You can only access '/inventory.html' when you are logged in.", loginPage.getLoginErrorTxt()
        );
    }

    @AfterEach
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
