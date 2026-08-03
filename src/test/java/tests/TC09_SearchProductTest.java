package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC09_SearchProductTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc09_SearchProduct() {

        signupEvents.verifyHomePageIsVisible();

        productsEvents.clickProductsButton();

        productsEvents.verifyAllProductsPage();

        productsEvents.searchProduct("Tshirt");

        productsEvents.verifySearchedProducts();
    }
}