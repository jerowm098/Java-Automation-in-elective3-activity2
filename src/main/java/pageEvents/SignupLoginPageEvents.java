package pageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import base.BaseTest;
import utils.ElementFetch;
import pageObjects.SignupLoginPageObjects;


public class SignupLoginPageEvents implements SignupLoginPageObjects {

    ElementFetch elementFetch = new ElementFetch();

    public void verifyHomePageIsVisible() {
        boolean isLogoVisible = elementFetch.getWebElement("XPATH", HOME_PAGE_LOGO).isDisplayed();
        Assert.assertTrue(isLogoVisible, "Home page is not visible!");
    }

    public void clickSignupLoginButton() {
        elementFetch.getWebElement("XPATH", SIGNUP_LOGIN_BUTTON).click();
    }

    public void verifyNewUserSignupHeader() {
        boolean isHeaderDisplayed = elementFetch.getWebElement("XPATH", NEW_USER_SIGNUP_HEADER).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "'New User Signup!' header is not displayed.");
    }

    public void verifyLoginHeader() {
        boolean isHeaderDisplayed = elementFetch.getWebElement("XPATH", LOGIN_HEADER).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "'Login to your account' header is not displayed.");
    }

    public void enterLoginCredentials(String email, String password) {
        elementFetch.getWebElement("XPATH", LOGIN_EMAIL_FIELD).sendKeys(email);
        elementFetch.getWebElement("XPATH", LOGIN_PASSWORD_FIELD).sendKeys(password);
    }

    public void clickLoginButton() {
        elementFetch.getWebElement("XPATH", LOGIN_SUBMIT_BUTTON).click();
    }

    public void enterNameAndEmail(String name, String email) {
        elementFetch.getWebElement("XPATH", SIGNUP_NAME_FIELD).sendKeys(name);
        elementFetch.getWebElement("XPATH", SIGNUP_EMAIL_FIELD).sendKeys(email);
    }

    public void clickSignupButton() {
        elementFetch.getWebElement("XPATH", SIGNUP_SUBMIT_BUTTON).click();
    }

    public void verifyEnterAccountInfoHeader() {
        boolean isHeaderDisplayed = elementFetch.getWebElement("XPATH", ENTER_ACCOUNT_INFO_HEADER).isDisplayed();
        Assert.assertTrue(isHeaderDisplayed, "'ENTER ACCOUNT INFORMATION' header is not displayed.");
    }

    public void fillAccountDetails(String password, String day, String month, String year) {
        WebElement radio = BaseTest.driver.findElement(By.id("id_gender1"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", radio);

        BaseTest.driver.findElement(By.id("password")).sendKeys(password);
        
        new Select(BaseTest.driver.findElement(By.id("days"))).selectByValue(day);
        new Select(BaseTest.driver.findElement(By.id("months"))).selectByValue(month);
        new Select(BaseTest.driver.findElement(By.id("years"))).selectByValue(year);
    }

    public void selectCheckboxes() {
        WebElement news = BaseTest.driver.findElement(By.id("newsletter"));
        WebElement offers = BaseTest.driver.findElement(By.id("optin"));
        
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", news);
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", offers);
    }

    public void fillAddressDetails(String firstName, String lastName, String company, String addr1, String addr2, String country, String state, String city, String zipcode, String mobile) {
        BaseTest.driver.findElement(By.id("first_name")).sendKeys(firstName);
        BaseTest.driver.findElement(By.id("last_name")).sendKeys(lastName);
        BaseTest.driver.findElement(By.id("company")).sendKeys(company);
        BaseTest.driver.findElement(By.id("address1")).sendKeys(addr1);
        BaseTest.driver.findElement(By.id("address2")).sendKeys(addr2);
        
        new Select(BaseTest.driver.findElement(By.id("country"))).selectByVisibleText(country);
        
        BaseTest.driver.findElement(By.id("state")).sendKeys(state);
        BaseTest.driver.findElement(By.id("city")).sendKeys(city);
        BaseTest.driver.findElement(By.id("zipcode")).sendKeys(zipcode);
        BaseTest.driver.findElement(By.id("mobile_number")).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        WebElement createAccountBtn = BaseTest.driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", createAccountBtn);
    }

    public void verifyAccountCreated() {
        boolean isCreated = elementFetch.getWebElement("XPATH", ACCOUNT_CREATED_HEADER).isDisplayed();
        Assert.assertTrue(isCreated, "'ACCOUNT CREATED!' is not visible.");
    }

    public void clickContinue() {
        WebElement continueBtn = BaseTest.driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", continueBtn);
    }

    public void verifyLoggedInAsUser(String username) {
        boolean isLoggedIn = elementFetch.getWebElement("XPATH", LOGGED_IN_AS_USER_HEADER).isDisplayed();
        Assert.assertTrue(isLoggedIn, "'Logged in as " + username + "' is not visible.");
    }

    public void clickDeleteAccount() {
    WebElement deleteAccountBtn = elementFetch.getWebElement("XPATH", DELETE_ACCOUNT_BUTTON);
    ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", deleteAccountBtn);
    try {
        Thread.sleep(1000); // Konting pahinga para maka-load ang URL
        if (BaseTest.driver.getCurrentUrl().contains("#google_vignette")) {
            BaseTest.driver.navigate().refresh();
        }
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}

    public void verifyAccountDeleted() {
    if (BaseTest.driver.getCurrentUrl().contains("#google_vignette")) {
        BaseTest.driver.navigate().refresh();
    }
    
    boolean isDeleted = elementFetch.getWebElement("XPATH", ACCOUNT_DELETED_HEADER).isDisplayed();
    Assert.assertTrue(isDeleted, "'ACCOUNT DELETED!' is not visible.");
}

    public void clickLogout() {
        elementFetch.getWebElement("XPATH", LOGOUT_BUTTON).click();
    }

    public void verifyLoginErrorMessage() {
        boolean isErrorVisible = elementFetch.getWebElement("XPATH", LOGIN_ERROR_MESSAGE).isDisplayed();
        Assert.assertTrue(isErrorVisible, "Error message 'Your email or password is incorrect!' is not visible.");
    }

    public void verifySignupErrorMessage() {
        boolean isErrorVisible = elementFetch.getWebElement("XPATH", SIGNUP_ERROR_MESSAGE).isDisplayed();
        Assert.assertTrue(isErrorVisible, "Error message 'Email Address already exist!' is not visible.");
    }

    public void clickTestCasesButton() {
        elementFetch.getWebElement("XPATH", TEST_CASES_BUTTON).click();
    }

    public void verifyTestCasesPageHeader() {
        boolean isHeaderVisible = elementFetch.getWebElement("XPATH", TEST_CASES_HEADER).isDisplayed();
        Assert.assertTrue(isHeaderVisible, "Test Cases page header is not visible.");
    }

    public void enterSubscriptionEmailAndClick(String email) {
        elementFetch.getWebElement("ID", SUBSCRIPTION_EMAIL_INPUT).sendKeys(email);
        elementFetch.getWebElement("ID", SUBSCRIPTION_BUTTON).click();
    }

    public void verifySubscriptionSuccess() {
        boolean isHeaderVisible = elementFetch.getWebElement("XPATH", SUBSCRIPTION_HEADER).isDisplayed();
        boolean isSuccessVisible = elementFetch.getWebElement("XPATH", SUBSCRIPTION_SUCCESS_ALERT).isDisplayed();

        Assert.assertTrue(isHeaderVisible, "'SUBSCRIPTION' text is not visible.");
        Assert.assertTrue(isSuccessVisible, "Success message 'You have been successfully subscribed!' is not visible.");
    }

    public void clickCartButton() {
        try {
            WebElement modalCartBtn = BaseTest.driver.findElement(By.xpath("//div[@id='cartModal']//u[contains(text(),'View Cart')]"));
            ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", modalCartBtn);
        } catch (Exception e) {
            WebElement topCartBtn = BaseTest.driver.findElement(By.xpath("//a[contains(@href,'/view_cart')]"));
            ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", topCartBtn);
        }
    }

    public void dismissAdsIfPresent() {
        try {
            WebElement closeAdBtn = BaseTest.driver.findElement(By.id("dismiss-button"));
            ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", closeAdBtn);
        } catch (Exception e) {
        }
    }

    public void clickProceedToCheckout() {
        WebElement proceedBtn = BaseTest.driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", proceedBtn);
    }

    public void clickRegisterLoginInModal() {
        WebElement regLoginModalBtn = BaseTest.driver.findElement(By.xpath("//u[contains(text(),'Register / Login')]"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", regLoginModalBtn);
    }

    public void enterCommentAndPlaceOrder(String comment) {
        BaseTest.driver.findElement(By.name("message")).sendKeys(comment);
        WebElement placeOrderBtn = BaseTest.driver.findElement(By.xpath("//a[contains(text(),'Place Order')]"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", placeOrderBtn);
    }

    public void fillPaymentDetailsAndPay(String nameOnCard, String cardNumber, String cvc, String month, String year) {
        BaseTest.driver.findElement(By.name("name_on_card")).sendKeys(nameOnCard);
        BaseTest.driver.findElement(By.name("card_number")).sendKeys(cardNumber);
        BaseTest.driver.findElement(By.name("cvc")).sendKeys(cvc);
        BaseTest.driver.findElement(By.name("expiry_month")).sendKeys(month);
        BaseTest.driver.findElement(By.name("expiry_year")).sendKeys(year);

        WebElement payBtn = BaseTest.driver.findElement(By.id("submit"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", payBtn);
    }

    public void clickDownloadInvoice() {
        WebElement downloadBtn = BaseTest.driver.findElement(By.xpath("//a[contains(text(),'Download Invoice')]"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", downloadBtn);
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) BaseTest.driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void clickScrollUpArrow() {
        WebElement scrollUpArrow = BaseTest.driver.findElement(By.id("scrollUp"));
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", scrollUpArrow);
    }

    public void scrollToTop() {
        ((JavascriptExecutor) BaseTest.driver).executeScript("window.scrollTo(0, 0);");
    }

    
}