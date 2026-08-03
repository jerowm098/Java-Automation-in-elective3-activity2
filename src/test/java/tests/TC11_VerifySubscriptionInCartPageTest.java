package tests;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC11_VerifySubscriptionInCartPageTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc11_VerifySubscriptionInCartPage() {

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickCartButton();

        signupEvents.enterSubscriptionEmailAndClick("testjerome@example.com");
        signupEvents.verifySubscriptionSuccess();
    }
}