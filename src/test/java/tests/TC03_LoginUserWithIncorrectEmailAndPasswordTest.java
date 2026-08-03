package tests;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC03_LoginUserWithIncorrectEmailAndPasswordTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc03_LoginUserWithIncorrectEmailAndPassword() {

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickSignupLoginButton();

        signupEvents.verifyLoginHeader();

        signupEvents.enterLoginCredentials("wrongtestemail@example.com", "WrongPassword123!");

        signupEvents.clickLoginButton();

        signupEvents.verifyLoginErrorMessage();
    }
}