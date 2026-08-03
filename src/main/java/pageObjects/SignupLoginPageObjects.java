package pageObjects;

public interface SignupLoginPageObjects {
    // Step 3: Homepage visibility verification
    String HOME_PAGE_LOGO = "//div[@class='logo pull-left']//img";
    
    // Step 4 & 5: Signup / Login section
    String SIGNUP_LOGIN_BUTTON = "//a[contains(text(),'Signup / Login')]";
    String NEW_USER_SIGNUP_HEADER = "//div[@class='signup-form']/h2";
    
    // Login Form Locators
    String LOGIN_HEADER = "//div[@class='login-form']/h2";
    String LOGIN_EMAIL_FIELD = "//input[@data-qa='login-email']";
    String LOGIN_PASSWORD_FIELD = "//input[@data-qa='login-password']";
    String LOGIN_SUBMIT_BUTTON = "//button[@data-qa='login-button']";
    
    // Step 6 & 7: Initial Signup Form
    String SIGNUP_NAME_FIELD = "//input[@data-qa='signup-name']";
    String SIGNUP_EMAIL_FIELD = "//input[@data-qa='signup-email']";
    String SIGNUP_SUBMIT_BUTTON = "//button[@data-qa='signup-button']";
    
    // Step 8 & 9: Enter Account Information Section
    String ENTER_ACCOUNT_INFO_HEADER = "//b[contains(text(),'Enter Account Information')]";
    String TITLE_MR_RADIO = "id_gender1";
    String PASSWORD_FIELD = "password";
    String DAYS_DROPDOWN = "days";
    String MONTHS_DROPDOWN = "months";
    String YEARS_DROPDOWN = "years";
    
    // Step 10 & 11: Checkboxes
    String NEWSLETTER_CHECKBOX = "newsletter";
    String SPECIAL_OFFERS_CHECKBOX = "optin";
    
    // Step 12: Address Information Section
    String FIRST_NAME_FIELD = "first_name";
    String LAST_NAME_FIELD = "last_name";
    String COMPANY_FIELD = "company";
    String ADDRESS1_FIELD = "address1";
    String ADDRESS2_FIELD = "address2";
    String COUNTRY_DROPDOWN = "country";
    String STATE_FIELD = "state";
    String CITY_FIELD = "city";
    String ZIPCODE_FIELD = "zipcode";
    String MOBILE_NUMBER_FIELD = "mobile_number";
    
    // Step 13, 14, 15: Create Account & Continuation
    String CREATE_ACCOUNT_BUTTON = "//button[@data-qa='create-account']";
    String ACCOUNT_CREATED_HEADER = "//b[contains(text(),'Account Created!')]";
    String CONTINUE_BUTTON = "//a[@data-qa='continue-button']";
    
    // Step 16: Logged in verification
    String LOGGED_IN_AS_USER_HEADER = "//a[contains(text(),'Logged in as')]";
    
    // Step 17 & 18: Delete Account
    String DELETE_ACCOUNT_BUTTON = "//a[contains(text(),'Delete Account')]";
    String ACCOUNT_DELETED_HEADER = "//b[contains(text(),'Account Deleted!')]";

    String LOGOUT_BUTTON = "//a[contains(text(),'Logout')]";
    String LOGIN_ERROR_MESSAGE = "//p[contains(text(),'Your email or password is incorrect!')]";
    String SIGNUP_ERROR_MESSAGE = "//p[contains(text(),'Email Address already exist!')]";

    String TEST_CASES_BUTTON = "//a[contains(text(),'Test Cases')]";
    String TEST_CASES_HEADER = "//b[contains(text(),'Test Cases')]";

    String SUBSCRIPTION_HEADER = "//h2[contains(text(),'Subscription')]";
    String SUBSCRIPTION_EMAIL_INPUT = "susbscribe_email";
    String SUBSCRIPTION_BUTTON = "subscribe";
    String SUBSCRIPTION_SUCCESS_ALERT = "//div[contains(@class,'alert-success') and contains(text(),'You have been successfully subscribed!')]";

    String CART_BUTTON = "//a[contains(@href,'/view_cart')]";
}