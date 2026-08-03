package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.SignupLoginPageEvents;


public class TC23_VerifyAddressDetailsInCheckoutTest extends BaseTest {

    @Test
    public void verifyAddressDetailsInCheckoutPage() {
        SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickSignupLoginButton();

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

        signupEvents.clickDeleteAccount();

        signupEvents.verifyAccountDeleted();
        signupEvents.clickContinue();
    }
}