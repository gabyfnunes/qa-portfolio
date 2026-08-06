package br.com.gabriela.hooks;

import br.com.gabriela.driver.DriverManager;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}