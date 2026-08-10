package br.com.gabriela.hooks;

import br.com.gabriela.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            takeScreenshot(scenario);
        }

        DriverManager.quitDriver();
    }

    private void takeScreenshot(Scenario scenario) {

        WebDriver driver = DriverManager.getDriver();

        byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(
                screenshot,
                "image/png",
                "Failure Screenshot"
        );
    }
}