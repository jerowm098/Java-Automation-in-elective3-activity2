package tests;

import base.BaseTest;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;

public class TC07_VerifyTestCasesPageTest extends BaseTest {

    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc07_VerifyTestCasesPage() {

        signupEvents.verifyHomePageIsVisible();

        signupEvents.clickTestCasesButton();

        signupEvents.verifyTestCasesPageHeader();
    }
}