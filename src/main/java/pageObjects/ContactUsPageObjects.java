package pageObjects;

public interface ContactUsPageObjects {

    String CONTACT_US_BUTTON = "//a[contains(text(),'Contact us')]";
    String GET_IN_TOUCH_HEADER = "//h2[contains(text(),'Get In Touch')]";
    
    String NAME_FIELD = "//input[@data-qa='name']";
    String EMAIL_FIELD = "//input[@data-qa='email']";
    String SUBJECT_FIELD = "//input[@data-qa='subject']";
    String MESSAGE_FIELD = "//textarea[@data-qa='message']";
    String UPLOAD_FILE_INPUT = "upload_file";
    String SUBMIT_BUTTON = "//input[@data-qa='submit-button']";
    
    String SUCCESS_MESSAGE = "//div[contains(@class,'alert-success')]";
    String HOME_BUTTON = "//a[contains(@class,'btn-success')]";
}