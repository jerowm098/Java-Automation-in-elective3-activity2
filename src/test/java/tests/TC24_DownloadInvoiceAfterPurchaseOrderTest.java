package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.SignupLoginPageEvents;

public class TC24_DownloadInvoiceAfterPurchaseOrderTest extends BaseTest {

    @Test
    public void downloadInvoiceAfterPurchaseOrder() throws InterruptedException {
        SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

        signupEvents.verifyHomePageIsVisible();

        BaseTest.driver.get("https://automationexercise.com/product_details/1");
        BaseTest.driver.findElement(org.openqa.selenium.By.xpath("//button[@class='btn btn-default cart']")).click();
        Thread.sleep(1000);

        signupEvents.clickCartButton();

        Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("/view_cart"), "Cart page is not displayed!");

        signupEvents.clickProceedToCheckout();

        signupEvents.clickRegisterLoginInModal();

        String email = "testjerome" + System.currentTimeMillis() + "@test.com";
        String firstName = "Jerome";
        String lastName = "Mallari";
        String company = "PUP";
        String address1 = "123 Main Street";
        String address2 = "Apt 4B";
        String country = "United States";
        String state = "Laguna";
        String city = "Biñan";
        String zipcode = "4024";
        String mobile = "09123456789";

        signupEvents.enterNameAndEmail(firstName + " " + lastName, email);
        signupEvents.clickSignupButton();

        signupEvents.verifyEnterAccountInfoHeader();
        signupEvents.fillAccountDetails("Password123!", "10", "5", "1995");
        signupEvents.selectCheckboxes();
        signupEvents.fillAddressDetails(firstName, lastName, company, address1, address2, country, state, city, zipcode, mobile);
        signupEvents.clickCreateAccount();

        signupEvents.verifyAccountCreated();
        signupEvents.clickContinue();

        signupEvents.verifyLoggedInAsUser(firstName + " " + lastName);

        signupEvents.clickCartButton();

        signupEvents.clickProceedToCheckout();

        Assert.assertTrue(BaseTest.driver.getPageSource().contains("Address Details"), "Address Details not displayed!");

        signupEvents.enterCommentAndPlaceOrder("Test Order comment by TestJerome");

        signupEvents.fillPaymentDetailsAndPay("Jerome Mallari", "4111111111111111", "311", "12", "2028");

        Thread.sleep(1000);
        Assert.assertTrue(BaseTest.driver.getPageSource().contains("Order Placed!") || 
                          BaseTest.driver.getPageSource().contains("Congratulations! Your order has been confirmed!"), 
                          "Order placement failed!");

        signupEvents.clickDownloadInvoice();
        Thread.sleep(2000); 

        signupEvents.clickContinue();

        signupEvents.clickDeleteAccount();

        signupEvents.verifyAccountDeleted();
        signupEvents.clickContinue();
    }
}