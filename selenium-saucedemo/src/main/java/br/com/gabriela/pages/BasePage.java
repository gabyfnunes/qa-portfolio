package br.com.gabriela.pages;

import br.com.gabriela.config.ConfigReader;
import br.com.gabriela.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected final WebDriver driver = DriverManager.getDriver();

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected void type(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void clickLoginButton(By locator) {
        find(locator).click();
    }

}