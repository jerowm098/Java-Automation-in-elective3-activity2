package tests;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC10_VerifySubscriptionInHomePageTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc10_VerifySubscriptionInHomePage() {

        signupEvents.verifyHomePageIsVisible();

        signupEvents.enterSubscriptionEmailAndClick("testjerome@example.com");
        signupEvents.verifySubscriptionSuccess();
    }
}