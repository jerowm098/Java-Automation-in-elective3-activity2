package tests;

import base.BaseTest;
import pageEvents.ContactUsPageEvents;
import pageEvents.SignupLoginPageEvents;
import org.testng.annotations.Test;
import java.io.File;

public class TC06_ContactUsFormTest extends BaseTest {

    ContactUsPageEvents contactEvents = new ContactUsPageEvents();
    SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

    @Test
    public void tc06_ContactUsForm() throws Exception {

        signupEvents.verifyHomePageIsVisible();

        contactEvents.clickContactUsButton();

        contactEvents.verifyGetInTouchHeader();

        contactEvents.fillContactForm(
            "TestJerome", 
            "testjerome@example.com", 
            "Inquiry Topic", 
            "Hello, this is a test message for Contact Us form."
        );

        File dummyFile = File.createTempFile("sample_upload", ".txt");
        dummyFile.deleteOnExit();
        contactEvents.uploadFile(dummyFile.getAbsolutePath());

        contactEvents.clickSubmitButton();

        contactEvents.acceptAlert();

        contactEvents.verifySuccessMessage();

        contactEvents.clickHomeButton();
        signupEvents.verifyHomePageIsVisible();
    }
}