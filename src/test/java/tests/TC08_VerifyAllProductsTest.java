package tests;

import base.BaseTest;
import pageEvents.ProductsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC08_VerifyAllProductsTest extends BaseTest {

    ProductsPageEvents productsEvents = new ProductsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc08_VerifyAllProductsAndProductDetailPage() {

        signupEvents.verifyHomePageIsVisible();

        productsEvents.clickProductsButton();

        productsEvents.verifyAllProductsPage();

        productsEvents.clickFirstProductViewButton();

        productsEvents.verifyProductDetailsVisible();
    }
}