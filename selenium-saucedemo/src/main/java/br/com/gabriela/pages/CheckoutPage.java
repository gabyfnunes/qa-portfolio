package br.com.gabriela.pages;

import br.com.gabriela.elements.CheckoutPageElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage{
    public String getPageTitle() {
        return find(CheckoutPageElements.CHECKOUT_TITLE).getText();
    }

    public void fillFirstName(String firstName) {
        find(CheckoutPageElements.FIRST_NAME).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        find(CheckoutPageElements.LAST_NAME).sendKeys(lastName);
    }

    public void fillPostalCode(String postalCode) {
        find(CheckoutPageElements.POSTAL_CODE).sendKeys(postalCode);
    }

    public void fillCheckoutInformation(
            String firstName,
            String lastName,
            String postalCode
    ) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillPostalCode(postalCode);
    }

    public void continueCheckout() {
        find(CheckoutPageElements.CONTINUE_BUTTON).click();
    }

    public void cancelCheckout() {
        find(CheckoutPageElements.CANCEL_BUTTON).click();
    }

    public String getErrorMessage() {
        return find(CheckoutPageElements.ERROR_MESSAGE).getText();
    }
    public void finishPurchase() {
        find(CheckoutPageElements.FINISH_BUTTON).click();
    }

    public boolean isOrderConfirmationPageDisplayed() {
        return find(
                CheckoutPageElements.COMPLETE_CONTAINER
        ).isDisplayed();
    }

    public String getSuccessMessage() {
        return find(
                CheckoutPageElements.SUCCESS_MESSAGE
        ).getText();
    }
    public boolean isCheckoutInformationPageDisplayed() {

        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        CheckoutPageElements.FIRST_NAME
                )
        ).isDisplayed();
    }
}
