package br.com.gabriela.pages;

import br.com.gabriela.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected final WebDriver driver = DriverManager.getDriver();

    private final WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

    protected WebElement find(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected void type(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void clickLoginButton(By locator) {
        find(locator).click();
    }
}