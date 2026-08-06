package br.com.gabriela.pages;

import br.com.gabriela.config.ConfigReader;
import org.openqa.selenium.By;


public class LoginPage extends BasePage{

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    public void open() {
        open(ConfigReader.getProperty("base.url"));
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        clickLoginButton(loginButton);

    }

}