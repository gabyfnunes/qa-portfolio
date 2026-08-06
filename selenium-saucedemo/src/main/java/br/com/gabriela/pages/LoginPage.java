package br.com.gabriela.pages;

import br.com.gabriela.config.ConfigReader;
import br.com.gabriela.elements.LoginPageElements;

public class LoginPage extends BasePage {

    public void open() {
        open(ConfigReader.getProperty("base.url"));
    }

    public void enterCredentials(String username, String password) {
        type(LoginPageElements.USERNAME_INPUT, username);
        type(LoginPageElements.PASSWORD_INPUT, password);
    }

    public void login(String username, String password) {
        enterCredentials(username, password);
        clickLoginButton(LoginPageElements.LOGIN_BUTTON);
    }

    public String getLoginErrorMessage() {
        return find(LoginPageElements.ERROR_MESSAGE).getText();
    }

    public void closeErrorMessage() {
        find(LoginPageElements.CLOSE_ERROR_BUTTON).click();
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(LoginPageElements.ERROR_MESSAGE).isEmpty();
    }

    public String getPasswordFieldType() {
        return find(LoginPageElements.PASSWORD_INPUT).getAttribute("type");
    }
}