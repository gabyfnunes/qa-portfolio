package br.com.gabriela.pages;

import br.com.gabriela.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage{

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By closeErrorMsgButton = By.cssSelector("[data-test='error-button']");

    public void open() {
        open(ConfigReader.getProperty("base.url"));
    }

    public void enterCredentials (String username, String password){
        type(usernameField, username);
        type(passwordField, password);
    }

    public void login(String username, String password) {
        enterCredentials(username, password);
        clickLoginButton(loginButton);

    }

    public String getLoginErrorMessage (){
        return find(errorMessage).getText();
    }

    public void closeErrorMessage (){
        find(closeErrorMsgButton).click();
    }

    public boolean isErrorMessageDisplayed (){
        return !driver.findElements(errorMessage).isEmpty();
    }

    public String getPasswordFieldType() {
        return driver.findElement(passwordField).getAttribute("type");
    }



}