package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.SignupLoginPageEvents;

public class TC25_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionalityTest extends BaseTest {

    @Test
    public void verifyScrollUpUsingArrowButtonAndScrollDown() throws InterruptedException {
        SignupLoginPageEvents signupEvents = new SignupLoginPageEvents();

        signupEvents.verifyHomePageIsVisible();

        signupEvents.scrollToBottom();
        Thread.sleep(1000);

        WebElement subscriptionHeader = BaseTest.driver.findElement(By.xpath("//h2[contains(text(),'Subscription')]"));
        Assert.assertTrue(subscriptionHeader.isDisplayed(), "'SUBSCRIPTION' text is not visible!");

        signupEvents.clickScrollUpArrow();
        Thread.sleep(1000);

        WebElement topHeading = BaseTest.driver.findElement(By.xpath("//*[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
        Assert.assertTrue(topHeading.isDisplayed(), "Top heading text is not visible on screen after scroll up!");
    }
}