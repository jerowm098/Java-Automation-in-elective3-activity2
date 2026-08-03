package tests;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC05_RegisterUserWithExistingEmailTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc05_RegisterUserWithExistingEmail() {
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

        signupEvents.verifyNewUserSignupHeader();

        signupEvents.enterNameAndEmail(username, email);

        signupEvents.clickSignupButton();

        signupEvents.verifySignupErrorMessage();
    }
}