package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC15_PlaceOrderRegisterBeforeCheckoutTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc15_PlaceOrderRegisterBeforeCheckout() {

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickSignupLoginButton();

        int randomNumber = 1000 + (int)(Math.random() * 9000);
        String name = "TestJerome";
        String email = "testjerome" + randomNumber + "@example.com";

        signupEvents.enterNameAndEmail(name, email);
        signupEvents.clickSignupButton();
        signupEvents.fillAccountDetails("Password123!", "10", "5", "1995");
        signupEvents.fillAddressDetails("Jerome", "Mallari", "Test Company", "123 Test St", "Apt 4", "United States", "Manila", "Biñan", "4024", "09123456789");
        signupEvents.clickCreateAccount();

        signupEvents.verifyAccountCreated();
        signupEvents.clickContinue();

        signupEvents.verifyLoggedInAsUser(name);

        productsEvents.addFirstProductToCart();

        productsEvents.clickModalViewCart();

        productsEvents.clickProceedToCheckout();

        productsEvents.enterCommentAndPlaceOrder("Please handle with care.");

        productsEvents.fillPaymentDetailsAndPay("Test Jerome", "4111111111111111", "311", "12", "2026");

        productsEvents.verifyOrderPlacedSuccess();

        signupEvents.clickDeleteAccount();

        signupEvents.verifyAccountDeleted();
        signupEvents.clickContinue();
    }
}