package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.ProductsPageEvents;

public class TC18_ViewCategoryProductsTest extends BaseTest {

    @Test
    public void verifyViewCategoryProducts() {
        ProductsPageEvents productsPageEvents = new ProductsPageEvents();

        productsPageEvents.verifyCategoriesSidebarVisible();

        productsPageEvents.clickWomenCategory();

        productsPageEvents.clickWomenSubCategory();

        productsPageEvents.verifyCategoryTitleText("WOMEN - Dress PRODUCTS");

        productsPageEvents.clickMenSubCategory();

        productsPageEvents.verifyCategoryTitleText("MEN - TSHIRTS PRODUCTS");
    }
}