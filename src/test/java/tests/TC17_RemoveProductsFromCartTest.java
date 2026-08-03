package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC17_RemoveProductsFromCartTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc17_RemoveProductsFromCart() {

        signupEvents.verifyHomePageIsVisible();

        productsEvents.addFirstProductToCart();

        productsEvents.clickModalViewCart();

        productsEvents.clickRemoveProductFromCart();

        productsEvents.verifyProductRemovedFromCart();
    }
}