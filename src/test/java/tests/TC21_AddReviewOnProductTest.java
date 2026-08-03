package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ProductsPageEvents;

public class TC21_AddReviewOnProductTest extends BaseTest {

    @Test
    public void verifyAddReviewOnProduct() {
        ProductsPageEvents productsPageEvents = new ProductsPageEvents();

        productsPageEvents.clickProductsButton();

        productsPageEvents.verifyAllProductsPageTitle();

        productsPageEvents.clickFirstViewProduct();

        productsPageEvents.verifyWriteYourReviewVisible();

        productsPageEvents.enterReviewDetails("Jerome Mallari", "jerome@test.com", "Great product, very useful and high quality!");

        productsPageEvents.clickReviewSubmitButton();

        productsPageEvents.verifyReviewSuccessMessage();
    }
}