package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;

public class TC01_RegisterUserTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc01_RegisterUser() {
        int randomNumber = 1000 + (int)(Math.random() * 9000);

        String username = "TestJerome";
        String email = "testjerome" + randomNumber + "@example.com"; 

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickSignupLoginButton();

        signupEvents.verifyNewUserSignupHeader();

        signupEvents.enterNameAndEmail(username, email);

        signupEvents.clickSignupButton();

        signupEvents.verifyEnterAccountInfoHeader();

        signupEvents.fillAccountDetails("Password123!", "10", "5", "1995");

        signupEvents.selectCheckboxes();

        signupEvents.fillAddressDetails(
            "TestFirstName", 
            "TestLastName", 
            "TestCompany", 
            "123 Test Street", 
            "Apt 1", 
            "United States", 
            "TestState", 
            "TestCity", 
            "12345", 
            "09123456789"
        );

        signupEvents.clickCreateAccount();

        signupEvents.verifyAccountCreated();

        signupEvents.clickContinue();

        signupEvents.verifyLoggedInAsUser(username);

        signupEvents.clickDeleteAccount();

        signupEvents.verifyAccountDeleted();
        
        signupEvents.clickContinue();
    }
}