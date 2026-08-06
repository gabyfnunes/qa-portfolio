package br.com.gabriela.elements;

import org.openqa.selenium.By;

public class LoginPageElements {

    public static final By USERNAME_INPUT = By.id("user-name");

    public static final By PASSWORD_INPUT = By.id("password");

    public static final By LOGIN_BUTTON = By.id("login-button");

    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public static final By CLOSE_ERROR_BUTTON = By.cssSelector("[data-test='error-button']");

}