package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.ProductsPageEvents;

public class TC19_ViewCartBrandProductsTest extends BaseTest {

    @Test
    public void verifyViewCartBrandProducts() {
        ProductsPageEvents productsPageEvents = new ProductsPageEvents();

        productsPageEvents.clickProductsButton();

        productsPageEvents.verifyBrandsSidebarVisible();

        productsPageEvents.clickFirstBrand();

        productsPageEvents.verifyBrandPageHeader();

        productsPageEvents.clickSecondBrand();

        productsPageEvents.verifyBrandPageHeader();
    }
}