package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ProductsPageEvents;

public class TC20_SearchProductsAndVerifyCartAfterLoginTest extends BaseTest {

    @Test
    public void verifySearchProductsAndCartAfterLogin() {
        ProductsPageEvents productsPageEvents = new ProductsPageEvents();

        productsPageEvents.clickProductsButton();

        productsPageEvents.verifyAllProductsPageTitle();

        productsPageEvents.enterProductNameAndSearch("Top");

        productsPageEvents.verifySearchedProductsVisible();

        productsPageEvents.addProductsToCartFromSearch();
        productsPageEvents.clickContinueShopping();

        productsPageEvents.clickCartButton();
        productsPageEvents.verifyCartProductsVisible();

        productsPageEvents.loginToAccount("jerome@test.com", "password123");

        productsPageEvents.clickCartButton();

        productsPageEvents.verifyCartProductsVisible();
    }
}