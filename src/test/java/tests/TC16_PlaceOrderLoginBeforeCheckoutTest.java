package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC16_PlaceOrderLoginBeforeCheckoutTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc16_PlaceOrderLoginBeforeCheckout() {
        int randomNumber = 1000 + (int)(Math.random() * 9000);
        String username = "TestJerome";
        String email = "testjerome" + randomNumber + "@example.com";
        String password = "Password123!";

        signupEvents.clickSignupLoginButton();
        signupEvents.enterNameAndEmail(username, email);
        signupEvents.clickSignupButton();
        signupEvents.fillAccountDetails(password, "10", "5", "1995");
        signupEvents.fillAddressDetails("Jerome", "Mallari", "Test Company", "123 Test St", "Apt 4", "United States", "Manila", "Biñan", "4024", "09123456789");
        signupEvents.clickCreateAccount();
        signupEvents.clickContinue();
        signupEvents.clickLogout(); 

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickSignupLoginButton();

        signupEvents.enterLoginCredentials(email, password);
        signupEvents.clickLoginButton();

        signupEvents.verifyLoggedInAsUser(username);

        productsEvents.addFirstProductToCart();

        productsEvents.clickModalViewCart();

        productsEvents.clickProceedToCheckout();

        productsEvents.enterCommentAndPlaceOrder("Fast delivery please.");

        productsEvents.fillPaymentDetailsAndPay("Test Jerome", "4111111111111111", "311", "12", "2026");

        productsEvents.verifyOrderPlacedSuccess();

        signupEvents.clickDeleteAccount();

        signupEvents.verifyAccountDeleted();
        signupEvents.clickContinue();
    }
}