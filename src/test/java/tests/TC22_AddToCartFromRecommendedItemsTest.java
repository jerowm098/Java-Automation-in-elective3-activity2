package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ProductsPageEvents;

public class TC22_AddToCartFromRecommendedItemsTest extends BaseTest {

    @Test
    public void verifyAddToCartFromRecommendedItems() {
        ProductsPageEvents productsPageEvents = new ProductsPageEvents();

        productsPageEvents.scrollToBottomAndVerifyRecommended();

        productsPageEvents.addRecommendedProductToCart();

        productsPageEvents.clickViewCartFromModal();

        productsPageEvents.verifyCartProductsVisible();
    }
}