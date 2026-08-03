package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC12_AddProductsInCartTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc12_AddProductsInCart() {

        signupEvents.verifyHomePageIsVisible();

        productsEvents.clickProductsButton();

        productsEvents.addFirstProductToCart();

        productsEvents.clickContinueShopping();

        productsEvents.addSecondProductToCart();

        productsEvents.clickModalViewCart();

        productsEvents.verifyCartProductsAndDetails();
    }
}