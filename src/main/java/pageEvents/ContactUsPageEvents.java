package pageEvents;

import org.openqa.selenium.By;
import org.testng.Assert;
import base.BaseTest;
import pageObjects.ContactUsPageObjects;

public class ContactUsPageEvents implements ContactUsPageObjects {

    public void clickContactUsButton() {
        BaseTest.driver.findElement(By.xpath(CONTACT_US_BUTTON)).click();
    }

    public void verifyGetInTouchHeader() {
        boolean isHeaderDisplayed = BaseTest.driver.findElement(By.xpath(GET_IN_TOUCH_HEADER)).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "'GET IN TOUCH' header is not visible.");
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        BaseTest.driver.findElement(By.xpath(NAME_FIELD)).sendKeys(name);
        BaseTest.driver.findElement(By.xpath(EMAIL_FIELD)).sendKeys(email);
        BaseTest.driver.findElement(By.xpath(SUBJECT_FIELD)).sendKeys(subject);
        BaseTest.driver.findElement(By.xpath(MESSAGE_FIELD)).sendKeys(message);
    }

    public void uploadFile(String filePath) {
        BaseTest.driver.findElement(By.name(UPLOAD_FILE_INPUT)).sendKeys(filePath);
    }

    public void clickSubmitButton() {
        BaseTest.driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }

    public void acceptAlert() {
        BaseTest.driver.switchTo().alert().accept();
    }

    public void verifySuccessMessage() {
        boolean isSuccess = BaseTest.driver.findElement(By.xpath(SUCCESS_MESSAGE)).isDisplayed();
        Assert.assertTrue(isSuccess, "Success message is not visible.");
    }

    public void clickHomeButton() {
        BaseTest.driver.findElement(By.xpath(HOME_BUTTON)).click();
    }
}