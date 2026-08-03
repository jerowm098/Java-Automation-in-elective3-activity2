package tests;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC02_LoginUserTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc02_LoginUserWithCorrectEmailAndPassword() {
        int randomNumber = 1000 + (int)(Math.random() * 9000);

        String username = "TestJerome";
        String email = "testjerome" + randomNumber + "@example.com";
        String password = "Password123!";

        signupEvents.clickSignupLoginButton();
        signupEvents.enterNameAndEmail(username, email);
        signupEvents.clickSignupButton();
        signupEvents.fillAccountDetails(password, "10", "5", "1995");
        signupEvents.fillAddressDetails("TestFirstName", "TestLastName", "TestCompany", "123 Test Street", "Apt 1", "United States", "TestState", "TestCity", "12345", "09123456789");
        signupEvents.clickCreateAccount();
        signupEvents.clickContinue();
        
        signupEvents.clickLogout(); 

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickSignupLoginButton();

        signupEvents.verifyLoginHeader();

        signupEvents.enterLoginCredentials(email, password);

        signupEvents.clickLoginButton();

        signupEvents.verifyLoggedInAsUser(username);

        signupEvents.clickDeleteAccount();

        signupEvents.verifyAccountDeleted();
        signupEvents.clickContinue();
    }
}