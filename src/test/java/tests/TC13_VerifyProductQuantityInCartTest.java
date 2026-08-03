package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC13_VerifyProductQuantityInCartTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc13_VerifyProductQuantityInCart() {

        signupEvents.verifyHomePageIsVisible();

        productsEvents.clickFirstProductViewButton();

        productsEvents.verifyProductDetailsVisible();

        productsEvents.setProductQuantity("4");

        productsEvents.clickAddToCartOnDetail();

        productsEvents.clickModalViewCart();

        productsEvents.verifyExactQuantityInCart("4");
    }
}